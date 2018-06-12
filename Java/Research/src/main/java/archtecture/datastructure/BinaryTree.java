package archtecture.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yjw on 18-6-12.
 */
public class BinaryTree {
    private Node root ;


    public static Node generateTree(int[] arry) {
        Node root = new Node();
        Node ps = new Node();
        ps = root;
        if ( arry == null || arry.length == 0) {
            return null;
        }

        ps.setData(arry[0]);
        int i = 1;
        while (i < arry.length) {
            Node s = new Node();
            s.setData(arry[i]);
            ps = root;
            while (!((ps.getData() < arry[i] && ps.getRightNode() == null) ||
                    (ps.getData() > arry[i] && ps.getLeftNode() == null))) {
                if (ps.getData() < arry[i]) {
                    ps = ps.getRightNode();
                } else if (ps.getData() > arry[i]) {
                    ps = ps.getLeftNode();
                }
            }
            if ( ps.getData() < arry[i]) {
                ps.setRightNode(s);
            }

            if ( ps.getData() > arry[i]) {
                ps.setLeftNode(s);
            }
            i++;

        }

        return root;
    }

    public void showBinary () {
        int depth = getDepth(root);

    }

    /**
     * root->left->right
     */
    public void preOrder() {
        Stack<Node> stack = new Stack<>();
        Node ps = root;
        if (ps == null) {
            System.out.println(" empty tree");
            return ;
        }
        while (ps != null || stack.size()!=0) {
            while (ps != null) {
                System.out.print(ps.getData() + " ");
                stack.push(ps);
                ps = ps.getLeftNode();
            }
            ps = stack.pop();
            ps = ps.getRightNode();
        }
    }

    /**
     * left->root->right
     */
    public void midOrder() {
        Stack<Node> stack = new Stack<>();
        Node ps = root;
        if (ps == null) {
            System.out.println(" empty tree");
            return ;
        }
        while (ps != null || stack.size() !=0) {
            while (ps !=null) {
                stack.push(ps);
                ps = ps.getLeftNode();
            }
            ps = stack.pop();
            System.out.print(ps.getData()+" ");
            ps = ps.getRightNode();
        }
    }

    /**
     * left->right->root
     */
    public void postOrder() {
        Stack<Node> stack = new Stack<>();
        Node ps  = root;
        if (ps == null) {
            System.out.println("empty tree");
            return;
        }
        Node lastVisit = root;
        while (ps != null || stack.size() != 0) {
            while (ps != null) {
                stack.push(ps);
                ps = ps.getLeftNode();
            }
            ps = stack.peek();
            if (ps.getRightNode() == null || ps.getRightNode() == lastVisit) {
                System.out.print(ps.getData() + " ");
                stack.pop();
                lastVisit = ps;
                ps = null;
            } else {
                ps = ps.getRightNode();
            }
        }
    }

    public int getDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int rDepth = getDepth(node.getRightNode());
            int lDepth = getDepth(node.getLeftNode());
            if (lDepth > rDepth) {
                return lDepth + 1;
            } else
                return rDepth + 1;
        }
    }

    public int getDepth() {
        int depth = 0;
        if (root == null)
            return 0;
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        List<Node> list = new ArrayList<>();
        do {
            for (Node node : nodes) {
                if (node.getLeftNode() != null)
                    list.add(node.getLeftNode());
                if (node.getRightNode() != null)
                    list.add(node.getRightNode());
            }
            depth++;
            nodes.clear();
            nodes = list;
        } while (list.size() != 0);

        return depth;
    }

    public static void main(String[] args) {
        int[] arry = {4,2,1,3,7,5,8};
        Node root = generateTree(arry);
        BinaryTree test = new BinaryTree();
        test.setRoot(root);
        System.out.println("depth :" + test.getDepth(test.getRoot()));
        System.out.println("preorder :");
        test.preOrder();
        System.out.println();
        System.out.println("midorder :");
        test.midOrder();
        System.out.println();
        System.out.println("postorder :");
        test.postOrder();
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}

class Node {
    private int data;
    private Node leftNode;
    private Node rightNode;

    public Node() {
       // leftNode = null;
       // rightNode = null;
    }

    public Node(int data, Node leftNode, Node rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public void showNode() {
        System.out.println("data :" + data);
    }
}
