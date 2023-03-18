import java.io.*;
import java.util.Scanner;

/**
 * This class manages all functions relate to the product
 */
public class OperationToProduct {

    /**
     * Searching and returning the index of product p in the list. If not found
     * returning -1
     * @param p Product for searching
     * @param list The Linked List
     * @return The index of product p in the list
     */
    public int index(Product p, MyList<Product> list) {
        int index = -1;
        Node<Product> cur = list.getHead();
        while (cur != null) {
            index++;
            if (String.valueOf(cur.getInfo()).equals(String.valueOf(p))) {
                return index;
            }
            cur = cur.getNext();
        }
        return -1;
    }

    /**
     * Creating and returning a product with info input from keyboard.
     * @return The product
     */
    public Product createProduct() {
        Scanner sc = new Scanner(System.in);
        Product newProduct = new Product();

        System.out.println("Enter product information");

        System.out.print("Enter product ID: ");
        newProduct.setbCode(sc.next());
        System.out.print("Enter product title: ");
        newProduct.setTitle(sc.next());
        System.out.print("Enter product quantity: ");
        newProduct.setQuantity(sc.nextInt());
        System.out.print("Enter product price: ");
        newProduct.setPrice(sc.nextDouble());

        return newProduct;
    }

    /**
     * Reading all products from the file and insert them to the list at tail.
     * @param fileName The file name of the file
     * @param list The Linked List contains all products that read from file
     * @throws IOException
     */
    public void getAllItemsFromFile(String fileName, MyList<Product> list) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        while (line != null) {
            line = line.replaceAll("\\s", "");
            line = line.replace("|", " ");
            String[] arr = line.split(" ");

            Product p = new Product();
            p.setbCode(arr[0]);
            p.setTitle(arr[1]);
            p.setQuantity(Integer.parseInt(arr[2]));
            p.setPrice(Double.parseDouble(arr[3]));

            list.insertAfterPosition(list.length() - 1, p);

            line = reader.readLine();
        }
        reader.close();
    }

    /**
     * Reading all products from the file and insert them to the stack.
     * @param fileName The file name of the file
     * @param stack The Stack contains all products that read from file
     * @throws IOException
     */
    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        while (line != null) {
            line = line.replaceAll("\\s", "");
            line = line.replace("|", " ");
            String[] arr = line.split(" ");

            Product p = new Product();
            p.setbCode(arr[0]);
            p.setTitle(arr[1]);
            p.setQuantity(Integer.parseInt(arr[2]));
            p.setPrice(Double.parseDouble(arr[3]));

            stack.push(p);

            line = reader.readLine();
        }
        reader.close();
    }

    /**
     * Reading all products from the file and insert them to the queue.
     * @param fileName The file name of the file
     * @param queue The Queue contains all products that read from file
     * @throws IOException
     */
    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        while (line != null) {
            line = line.replaceAll("\\s", "");
            line = line.replace("|", " ");
            String[] arr = line.split(" ");

            Product p = new Product();
            p.setbCode(arr[0]);
            p.setTitle(arr[1]);
            p.setQuantity(Integer.parseInt(arr[2]));
            p.setPrice(Double.parseDouble(arr[3]));

            queue.enqueue(p);

            line = reader.readLine();
        }
        reader.close();
    }

    /**
     * Adding a product to the list, info of the product input from keyboard.
     * @param list The Linked list
     */
    public void addLast(MyList<Product> list) {
        Product product = createProduct();
        list.insertAfterPosition(list.length() - 1, product);
        System.out.println();
    }

    /**
     * Printing all products of the list to console screen
     * @param list The Linked list
     */
    public void displayAll(MyList<Product> list) {
        System.out.println("ID |  Title   | Quantity | price");
        System.out.println("--------------------------------");
        System.out.println(list);
        System.out.println();
    }

    /**
     * Writing all products from the list to the file
     * @param fileName Output file name
     * @param list Input Linked list
     * @throws IOException
     */
    public void writeAllItemsToFile(String fileName, MyList<Product> list) throws IOException {
        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter(fileName));
        Node<Product> cur = list.getHead();
        while (cur != null) {
            writer.write(cur.getInfo().toString());
            cur = cur.getNext();
            writer.newLine();
        }
        writer.close();
        System.out.println();
    }

    /**
     * Searching product by ID input from keyboard.
     * @param list The Linked list
     */
    public void searchByCode(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the ID to search = ");
        String idSearch = sc.next();
        Node<Product> cur = list.getHead();
        boolean has = false;
        while (cur != null) {
            if (cur.getInfo().getbCode().equals(idSearch)) {
                System.out.print("Result: " + cur.getInfo().toString());
                has = true;
                break;
            }
            cur = cur.getNext();
        }
        if (!has) {
            System.out.println("Not found!!!");
        }
        System.out.println();
    }

    /**
     * Deleting first product that has the ID input from keyboard from the list.
     * @param list The Linked list
     */
    public void deleteByCode(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the ID to delete = ");
        String idDelete = sc.next();
        Node<Product> cur = list.getHead();
        boolean has = false;
        while (cur != null) {
            if (cur.getInfo().getbCode().equals(idDelete)) {
                list.delete(cur.getInfo());
                System.out.println("Deleted!!!");
                has = true;
                break;
            }
            cur = cur.getNext();
        }
        if (!has) {
            System.out.println("Not found!!!");
        }
        System.out.println();
    }

    /**
     * Sorting products in linked list by ID
     * @param list The Linked list
     */
    public void sortByCode(MyList<Product> list) {
        for (int i = 0; i < list.length(); i++) {
            Node<Product> tmp = list.getHead();
            for (int j = i; j > 0; j--) {
                tmp = tmp.getNext();
            }
            Node<Product> min = tmp;
            Node<Product> x = tmp.getNext();
            while (x != null) {
                if (x.getInfo().getbCode().compareTo(min.getInfo().getbCode()) < 0) {
                    min = x;
                }
                x = x.getNext();
            }
            list.swap(min, tmp);
        }
        System.out.println();
    }

    /**
     * Adding new product to head of Linked List. The info input from keyboard.
     * @param list The linked list
     */
    public void addFirst(MyList<Product> list) {
        Product product = createProduct();
        list.insertToHead(product);
        System.out.println();
    }

    /**
     * Convert decimal to binary
     * @param i the positive integer number need to convert
     * @return int binary
     */
    public int convertToBinary(int i) {
        MyStack<Integer> stack = new MyStack<>();
        if (i==0) {
            stack.push(0);
        }else {
            while (i != 0) {
                int r = i % 2;
                stack.push(r);
                i = i / 2;
            }
        }
        String s = "";
        Node<Integer> cur = stack.getHead();
        while (cur != null) {
            s += cur.getInfo();
            cur = cur.getNext();
        }
        int binary = Integer.parseInt(s);
        return binary;
    }

    /**
     * Deleting the product at position
     * @param list The Linked List
     * @param pos The position of product to be deleted
     */
    public void deleteAtPosition(MyList<Product> list, int pos) {
        if (pos >= 0 && pos < list.length()-1) {
            Node<Product> tmp = list.getHead();
            for (int i = 0; i < pos; i++ ) {
                tmp = tmp.getNext();
            }
            list.delete(tmp.getInfo());
        }
        else if (pos == list.length()-1) {
            list.deleteTail();
        }
        System.out.println();
    }

    /**
     * Load data from list to stack and display
     * @param list The Linked List
     */
    public void loadToStack(MyList<Product> list) {
        MyStack<Product> stack = new MyStack<>();
        Node<Product> cur = list.getHead();
        while (cur != null) {
            stack.push(cur.getInfo());
            cur = cur.getNext();
        }
        System.out.println("ID |  Title   | Quantity | price");
        System.out.println("--------------------------------");
        System.out.println(stack);
        System.out.println();
    }

    /**
     * Load data from list to queue and display
     * @param list The Linked List
     */
    public void loadToQueue(MyList<Product> list) {
        MyQueue<Product> queue = new MyQueue<>();
         Node<Product> cur = list.getHead();
        while (cur != null) {
            queue.enqueue(cur.getInfo());
            cur = cur.getNext();
        }
        System.out.println("ID |  Title   | Quantity | price");
        System.out.println("--------------------------------");
        System.out.println(queue);
        System.out.println();
    }
}
