/**
 * Created by yjw on 18-5-9.
 */
public class LinkedList {


    public static void generateList(Node a, String str) throws CloneNotSupportedException {
        char[] strList = str.toCharArray();
        Node ps = new Node();
        ps = a;
        ps.setValue(String.valueOf(strList[0]));
        if(strList.length == 1){
            return;
        } else {
            for (int i = 1; i < strList.length; i++) {
                Node s = new Node();
                s.setValue(String.valueOf(strList[i]));
                ps.setNext(s);
                ps = ps.getNext();
            }
        }
    }

    public Node fanzhuan(Node ps) {
        if (ps.getNext()==null) {
            return ps;
        } else {
            Node aft = fanzhuan(ps.getNext());
            aft.setNext(ps);
            ps.setNext(null);
            return ps;
        }
    }

    public Node fanzhuan2(Node ps){
        Node s = ps.getNext();
        Node n = s.getNext();
        ps.setNext(null);
        while(n != null) {
            s.setNext(ps);
            ps = s;
            s = n;
            n = n.getNext();
        }
        s.setNext(ps);
        ps = s;
        return ps;
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Node root = new Node();
        generateList(root, "hello world!");
        Node tail = root.getNext().getNext().getNext().getNext()
                .getNext().getNext().getNext().getNext()
                .getNext().getNext().getNext();
        Node ps = new Node();
        ps = root;
        while (ps!= null) {
            System.out.print(ps.getValue());
            ps = ps.getNext();
        }
        ps = root;
        LinkedList t = new LinkedList();
        t.fanzhuan2(ps);
        ps = tail;
        System.out.println();
        while (ps != null) {
            System.out.print(ps.getValue());
            ps = ps.getNext();
        }
    }
}
