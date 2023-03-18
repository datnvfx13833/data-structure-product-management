/**
 * Generic version of the Node class.
 * @param <T> the type of the value
 */
public class Node<T> {
    /**
     * The info of this node
     */
    private T info;

    /**
     * The next node
     */
    private Node<T> next;

    /**
     * Default constructor
     */
    public Node() {
    }

    /**
     * Constructor with info and next node
     * @param info info of node
     * @param next the next node
     */
    public Node(T info, Node next) {
        this.info = info;
        this.next = next;
    }

    /**
     * Overriding to convert this node to String
     * @return string
     */
    @Override
    public String toString() {
        return this.info.toString();
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
}
