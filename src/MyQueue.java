/**
 * Generic version of the Queue class.
 * @param <T> The type of the value
 */
public class MyQueue<T> {
    /**
     * Head node contains front node in the queue
     */
    private Node<T> head;

    /**
     * Tail node contains last node in the queue
     */
    private Node<T> tail;

    /**
     * Default constructor
     */
    public MyQueue() {
        head  = null;
        tail = null;
    }

    /**
     * Add node to head of the queue
     * @param value value need to add
     */
    public void enqueue(T value) {
        if (tail != null) {
            tail.setNext(new Node(value, null));
            tail = tail.getNext();
        } else {
            tail = new Node(value, null);
            head = tail;
        }
    }

    /**
     * Delete the head node of the queue
     * @return value of head
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot dequeue - Queue is empty");
        }

        T value = head.getInfo();
        head = head.getNext();

        if (head == null) {
            tail = null;
        }

        return value;
    }

    /**
     * Checking if this queue is empty
     * @return true if queue is empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Read data of the head of the queue
     * @return value of head
     */
    public T peek() {
        return head.getInfo();
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
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
