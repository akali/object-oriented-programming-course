package ThirdTask;

/**
 * Created in 21.01.18. package ${PACKAGE_NAME}.
 * in project lab-s.
 */
public class Node {
    private Node next = null;

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    private Node prev = null;
    private int value;

    public Node(Node next){
        this.next=next;
    }
    public Node(int value){
        this.value=value;
    }
    public Node(){}

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", value=" + value +
                '}';
    }
}
