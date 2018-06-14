package archtecture.datastructure;

/**
 * Created by yjw on 18-6-14.
 *
 *
 * Binary Search Tree
 */
public class BST {


    /***
     * bst delete case
     *
     *
     *
     * case 1
     *
     *
     *           90                         90
     *         /   \                       /  \
     *       [50]  150                   *20   150
     *      /             =>            /  \
     *     *20                         5     25
     *    /  \
     *   5   25
     *
     *
     *
     * case 2
     *
     *                90                           90
     *               /  \                         /  \
     *              50  [150]                   50   *175
     *            /     /  \       =>          /     /
     *          20     125  *175              20     125
     *         /  \      \                  /  \      \
     *        5   25     140              5    25     140
     *
     *
     * case 3
     *
     *                  90                            90
     *                 /  \                          /  \
     *               [50]  150                     *66  150
     *              /   \                         /  \
     *            20    75          =>           20  75
     *           /     /  \                     /   /  \
     *          5    *66    80                 5   68   80
     *                 \
     *                  68
     */

    public static void testDelete() {
        int[] arry = {90, 50, 150, 20,5,25};
        Node root1 = BinaryTree.generateTree(arry);
        BST test = new BST();
        Node del = findNode(root1, 50);
        deleteNode(root1, del);
        int[] array2 = {90, 50,150,20,5,25,125,175,140};
        Node root2 = BinaryTree.generateTree(array2);
        Node del2 = findNode(root2, 150);
        deleteNode(root2, del2);
        int[] arry3 = {90,50,150,20,75,5,66,80,68};
        Node root3 = BinaryTree.generateTree(arry3);
        Node del3 = findNode(root3, 50);
        deleteNode(root3, del3);
    }


    public static void deleteNode(Node root, Node delNode) {
        Node ps = root;
        Node parent = null;
        boolean left = false;
        while (ps != null) {
            if (ps.getData() == delNode.getData()) {
                break;
            } else if (ps.getData() > delNode.getData()) {
                parent = ps;
                ps = ps.getLeftNode();
                left = true;
            } else if (ps.getData() < delNode.getData()) {
                parent = ps;
                ps = ps.getRightNode();
                left = false;
            }
        }

        if (delNode.getRightNode() == null) {
            // case 1
            if (left) {
                parent.setLeftNode(delNode.getLeftNode());
            } else {
                parent.setRightNode(delNode.getLeftNode());
            }
        } else if (delNode.getRightNode().getLeftNode() == null) {
            // case 2
            if (left) {
                parent.setLeftNode(delNode.getRightNode());
            } else {
                parent.setRightNode(delNode.getRightNode());
            }
            delNode.getRightNode().setLeftNode(delNode.getLeftNode());
        } else if (delNode.getRightNode().getLeftNode() != null) {
            // case 3
            // find min in right left tree
            Node s = delNode.getRightNode().getLeftNode();
            Node tmpRightNode = delNode.getRightNode();
            Node tmpLeftNode = delNode.getLeftNode();
            Node sParent = delNode.getRightNode();
            while (s.getLeftNode() != null) {
                sParent = s;
                s = s.getLeftNode();
            }

            if (left) {
                parent.setLeftNode(s);
            } else {
                parent.setRightNode(s);
            }
            if (s.getRightNode() != null) {
                sParent.setLeftNode(s.getRightNode());
            }
            s.setRightNode(tmpRightNode);
            s.setLeftNode(tmpLeftNode);
        } else {
            // do nothing
        }
    }

    public static Node findNode(Node root, int value) {
        Node ps = root;
        Node res = null;
        while ( ps != null ) {
            if (ps.getData() == value) {
                res = ps;
                break;
            } else if (ps.getData() > value) {
                ps = ps.getLeftNode();
            } else if (ps.getData() < value) {
                ps = ps.getRightNode();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        testDelete();
    }
}
