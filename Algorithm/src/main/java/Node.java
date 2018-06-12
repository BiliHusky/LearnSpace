/**
 * Created by yjw on 18-5-9.
 */
public class Node implements Cloneable{
    private String value=null;
    private Node next=null;

    public Node(){
        value = null;
        next = null;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Node node = null;
        node = (Node) super.clone();
        return node;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
