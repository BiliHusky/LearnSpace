package archtecture.datastructure;

/**
 * Created by yjw on 18-6-12.
 * this is a balance binary tree search
 */
public class AVL<T extends Comparable> {
    private AVLNode<T> root;
    /***
     * there are four case that no balance condition
     *           6            6         2           2
     *         /  \         /  \      /  \         / \
     *       3     7      2     7    1   5        1   4
     *     /  \         /  \            / \          / \
     *    1    4       1    4          3  6         3   6
     *     \               /            \              /
     *      2             3              4            5
     *
     *         1             2          3           4
     *
     *
     * for case 1 and 4 are symmetry need one rotation
     * for case 2 and 3 are symmetry need two rotation
     */



    /***
     *
     * case 1 solution
     *
     *             X                W
     *           /   \            /   \
     *         W     C    =>    A     X
     *       /  \               |    /  \
     *     A     B              ...  B   C
     *     |
     *    ...
     */
    public AVLNode<T> leftRotate(AVLNode<T> x) {
        AVLNode<T> w = x.getLeftNode();
        x.setLeftNode(w.getRightNode());
        w.setRightNode(x);
        x.setHeight(Math.max(height(x.getLeftNode()), height(x.getRightNode())) + 1);
        w.setHeight(Math.max(height(w.getLeftNode()), x.getHeight()) + 1);
        return w;
    }

    /***
     *
     * case 4 solution
     *            W                       X
     *          /   \                   /   \
     *         A     X                 W     C
     *             /   \      =>     /  \    |
     *            B     C           A   B    ...
     *                  |
     *                 ...
     */
    public AVLNode<T> rightRotate(AVLNode<T> w) {
        AVLNode<T> x = w.getRightNode();

        w.setRightNode(x.getLeftNode());
        x.setLeftNode(w);

        w.setHeight(Math.max(height(w.getLeftNode()), height(w.getRightNode())) + 1);
        x.setHeight(Math.max(height(x.getRightNode()), w.getHeight()) + 1);
        return x;
    }

    /***
     * case 2 solution
     *             X                    X                  Y
     *           /   \                /   \              /   \
     *         W      D              Y     D           W     X
     *       /   \        =>       /  \         =>   /  \   /  \
     *     A      Y               W    C           A    B  C    D
     *           /  \           /  \
     *         B     C        A     B
     */

    public AVLNode<T> doubleRotateLeft(AVLNode<T> x) {
        x.setLeftNode(rightRotate(x.getLeftNode()));
        return leftRotate(x);
    }


    /***
     *  case 3 solution
     *
     *          X                    X                          Y
     *        /   \                /   \                      /   \
     *      D     W              D      Y                   X      W
     *          /   \    =>           /   \        =>     /   \   /  \
     *        Y      A              C      W            D     C  B    A
     *      /   \                         /  \
     *    C      B                       B    A
     */
    public AVLNode<T> doubleRotateRight(AVLNode<T> x) {
        x.setRightNode(leftRotate(x.getRightNode()));
        return rightRotate(x);
    }

    public void insert(T data) {
        if (data == null)
            throw new RuntimeException("data cannot be null");
        this.root = insert(data, root);
    }

    private AVLNode<T> insert(T data, AVLNode<T> p) {
        if (p == null) {
            p = new AVLNode<T>(data);
        } else if (data.compareTo(p.getData()) < 0) {
            p.setLeftNode(insert(data, p.getLeftNode()));
            if (height(p.getLeftNode())-height(p.getRightNode()) == 2) {
                if (data.compareTo(p.getLeftNode().getData()) < 0) {
                    p = leftRotate(p);
                } else {
                    p = doubleRotateLeft(p);
                }
            }
        } else if (data.compareTo(p.getData()) > 0) {
            p.setRightNode(insert(data, p.getRightNode()));

            if (height(p.getRightNode()) - height(p.getLeftNode()) == 2) {
                if (data.compareTo(p.getRightNode().getData()) < 0) {
                    p = doubleRotateRight(p);
                } else {
                    p = rightRotate(p);
                }
            }
        } else {
            ;
        }

        p.setHeight(Math.max(height(p.getLeftNode()), height(p.getRightNode())) + 1);
        return p;
    }

    public int height(AVLNode<T> t) {
        return t == null ? -1 : t.getHeight();
    }

    public AVLNode<T> getRoot() {
        return root;
    }

    public void setRoot(AVLNode<T> root) {
        this.root = root;
    }

    private void printTree(AVLNode<T> t) {
        if (t!=null) {
            printTree(t.getLeftNode());
            System.out.print(t.getData() + " ");
            printTree(t.getRightNode());
        }
    }

    public boolean isEmpty() {
        return root == null;
    }
    public void printTree() {
        if (isEmpty()) {
            System.out.println("empty tree");
        } else {
            printTree(root);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AVL<Integer> test = new AVL<>();
        int[] nums = {3,2,1,4,5,6,7,10,9,8};
        for (int num : nums) {
            test.insert(num);
            test.printTree();
            System.out.println(test.height(test.getRoot()));
        }
    }
}

class AVLNode<T extends Comparable> {
    private T data;
    private int height;
    private AVLNode<T> leftNode;
    private AVLNode<T> rightNode;

    public AVLNode(T data) {
        this.data = data;
    }

    public AVLNode(AVLNode<T> leftNode, AVLNode<T> rightNode, T data, int height) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.data = data;
        this.height = height;
    }

    public AVLNode(AVLNode<T> leftNode, AVLNode<T> rightNode, T data) {

        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(AVLNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public AVLNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(AVLNode<T> rightNode) {
        this.rightNode = rightNode;
    }
}


