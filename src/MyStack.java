import java.util.EmptyStackException;

/**
 * Generic version of the Stack class.
 * @param <T> the type of the value
 */
public class MyStack<T> {
    /**
     * Head node contains front node in the stack
     */
    private Node<T> head;

    /**
     * Default constructor
     */
    public MyStack() {
        head = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * Checking if this stack is empty
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return (head==null);
    }

    /**
     * Add node to head of queue
     * @param x the value of node need to add
     */
    public void push(Object x) {
        head = new Node(x,head);
    }

    /**
     * Read data of head of the queue
     * @return value of the head
     * @throws EmptyStackException
     */
    Object top() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        return(head.getInfo());
    }
    public Object pop() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        Object x = head.getInfo();
        head = head.getNext();
        return(x);
    }

    /**
     * Override to convert this queue to string
     * @return string
     */
    @Override
    public String toString() {
        Node<T> cur = head;
        String result = "";
        while (cur != null) {
            result += cur.toString() + "\n";
            cur = cur.getNext();
        }
        return result;
    }
}
