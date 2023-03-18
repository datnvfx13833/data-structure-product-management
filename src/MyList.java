/**
 * Generic version of the LinkedList class.
 * @param <T> the type of the value
 */
public class MyList<T> {
    /**
     * Head node, default is null
     */
    private Node<T> head;

    /**
     * Tail node, default is null
     */
    private Node<T> tail;

    /**
     * Default constructor
     */
    public MyList() {

    }

    /**
     * Constructor with head and tail
     * @param head Head node of this list
     * @param tail Tail node of this list
     */
    public MyList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Checking if this list is empty
     * @return true if list is empty
     */
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    /**
     * Returning the length of this list
     * @return The length of this list
     */
    public int length() {
        int length = 0;
        if (this.head != null) {
            Node cur = this.head;
            while (cur != null) {
                length++;
                cur = cur.getNext();
            }
        }
        return length;
    }

    /**
     * Insert an item to the head of this list
     * @param item The item to be inserted
     */
    public void insertToHead(T item) {
        Node<T> temp = new Node<>(item,null);
        if (this.head == null) {
            this.head = temp;
            this.tail = temp;
        } else {
            temp.setNext(this.head);
            this.head = temp;
        }
    }

    /**
     * Insert an item at position to this list
     * @param position The position of new item
     * @param item The item to be inserted
     */
    public void insertAfterPosition(int position, T item) {
        if (position == -1) {
            insertToHead(item);
        } else if (position == length()-1 && position != -1) {
            Node<T> cur = tail;
            Node<T> newTail = new Node<>(item,null);
            tail = newTail;
            cur.setNext(tail);
        } else if (position >= 0 && position < length() - 1) {
            Node<T> cur = head;
            Node<T> next = cur.getNext();

            while (position > 0) {
                cur = next;
                next = next.getNext();
                position--;
            }

            cur.setNext(new Node<T>(item, next));
        } else {
            System.out.println("Position not found!!!");
        }
    }

    /**
     * Deleting the tail of this list
     */
    public void deleteTail() {
        if (length() == 0) {
            System.out.println("Linked list is empty");
        } else if (length() == 1) {
            head = null;
            tail = null;
        } else {
            Node<T> cur = head;
            Node<T> prev1 = null;
            Node<T> prev2 = null;

            while (cur != null) {
                prev2 = prev1;
                prev1 = cur;
                cur = cur.getNext();
            }
            prev2.setNext(null);
            tail = prev2;
        }
    }

    /**
     * Searching and deleting an item from this list
     * @param item The item to be deleted
     */
    public void delete(T item) {
        Node<T> prev = new Node<T>(null,null);

        // Dummy node pointing to head node
        prev.setNext(head);

        // Next node that points ahead of current node
        Node<T> next = head.getNext();

        // Temporary node for traversal
        Node<T> temp = head;

        // Boolean value that checks whether value to be
        // deleted exists or not
        boolean exists = false;

        // If head node needs to be deleted
        if (String.valueOf(head.getInfo()).equals(
                String.valueOf(item))) {
            head = head.getNext();

            // Node to be deleted exists
            exists = true;
        }

        // Iterating over LinkedList
        while (temp.getNext() != null) {

            // We convert value to be compared into Strings
            // and then compare using
            // String1.equals(String2) method

            // Comparing value of key and current node
            if (String.valueOf(temp.getInfo()).equals(
                    String.valueOf(item))) {

                // If node to be deleted is found previous
                // node now points to next node skipping the
                // current node
                prev.setNext(next);
                // node to be deleted exists
                exists = true;

                // As soon as we find the node to be deleted
                // we exit the loop
                break;
            }

            // Previous node now points to current node
            prev = temp;

            // Current node now points to next node
            temp = temp.getNext();

            // Next node points the node ahead of current
            // node
            next = temp.getNext();
        }

        // Comparing the last node with the given key value
        if (exists == false
                && String.valueOf(temp.getInfo()).equals(
                String.valueOf(item))) {

            // If found , last node is skipped over
            prev.setNext(null);

            // Node to be deleted exists
            exists = true;
        }

        // If node to be deleted exists
        if (!exists) {

            // Length of LinkedList reduced


            // Print statement
            System.out.println(
                    "Given Value is not present in linked list");
        }
    }

    /**
     * Swaping two nodes [firstNode] and [secondNode]
     * @param firstNode the first node
     * @param secondNode the second node
     */
    public void swap(Node<T> firstNode, Node<T> secondNode) {
        if (String.valueOf(firstNode.getInfo()).equals(String.valueOf(secondNode.getInfo())))
            return;

        // Search for x (keep track of prevX and CurrX)
        Node<T> prevX = null, currX = head;
        while (currX != null && !(String.valueOf(currX.getInfo()).equals(String.valueOf(firstNode.getInfo())))) {
            prevX = currX;
            currX = currX.getNext();
        }

        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && !(String.valueOf(currY.getInfo()).equals(String.valueOf(secondNode.getInfo())))) {
            prevY = currY;
            currY = currY.getNext();
        }

        if (currX == null || currY == null)
            return;

        if (prevX != null)
            prevX.setNext(currY);
        else
            head = currY;

        if (prevY != null)
            prevY.setNext(currX);
        else // make x the new head
            head = currX;

        // Swap next pointers
        Node temp = currX.getNext();
        currX.setNext(currY.getNext());
        currY.setNext(temp);
    }

    /**
     * Deleting all items in the list
     */
    public void clear() {
        head = null;
        tail = null;
    }

    /**
     * Override to convert this list to string
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

    public Node<T> getTail() {
        return tail;
    }
    public Node<T> getHead() {
        return head;
    }
}
