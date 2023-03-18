import java.io.IOException;
import java.util.Scanner;

/**
 * The Main class
 */
public class AS2_Main {
    public static int choice;
    public static MyList<Product> list = new MyList<>();
    public static MyStack<Product> stack;
    public static MyQueue<Product> queue;
    public static Scanner scanner = new Scanner(System.in);

    /**
     * show options to customers
     */
    public static void showMenu() {
        System.out.println("Choose one of this options:");
        System.out.println("Product list:");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) throws IOException {
        OperationToProduct operationToProduct = new OperationToProduct();

        while (true) {
            showMenu();

            System.out.print("choice = ");
            choice = scanner.nextInt();
            System.out.println();

            if (choice == 0) {
                System.out.println("Goodbye!!!");
                break;
            }

            switch (choice) {
                case 1:
                    operationToProduct.getAllItemsFromFile("src/data_input.txt",list);
                    operationToProduct.displayAll(list);
                    break;
                case 2:
                    operationToProduct.addLast(list);
                    break;
                case 3:
                    operationToProduct.displayAll(list);
                    break;
                case 4:
                    operationToProduct.writeAllItemsToFile("src/data_output.txt",list);
                    break;
                case 5:
                    operationToProduct.searchByCode(list);
                    break;
                case 6:
                    operationToProduct.deleteByCode(list);
                    break;
                case 7:
                    operationToProduct.sortByCode(list);
                    break;
                case 8:
                    System.out.print("Quantity = ");
                    int i = scanner.nextInt();
                    System.out.print("Binary = " + operationToProduct.convertToBinary(i));
                    System.out.println();
                    break;
                case 9:
                    operationToProduct.loadToStack(list);
                    break;
                case 10:
                    operationToProduct.loadToQueue(list);
                    break;
            }
        }
    }
}