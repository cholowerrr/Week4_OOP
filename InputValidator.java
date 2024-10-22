import java.util.Scanner;

public class InputValidator {

    // Method to validate integer input
    public static int getValidIntInput(Scanner scanner, String message) {
        int value;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value >= 0) {
                    return value;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    // Method to validate double input
    public static double getValidDoubleInput(Scanner scanner, String message) {
        double value;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value >= 0) {
                    return value;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    // Method to validate string input
    public static String getValidStringInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.next(); // Reads a single word
    }

    // Method to validate employee type input
    public static String getValidEmployeeType(Scanner scanner) {
        String type;
        while (true) {
            System.out.print("Enter Employee Type (fulltime/parttime/contractual): ");
            type = scanner.next();
            if (type.equalsIgnoreCase("fulltime") || type.equalsIgnoreCase("parttime") || type.equalsIgnoreCase("contractual")) {
                return type;
            } else {
                System.out.println("Invalid type. Please enter [fulltime, parttime, or contractual].");
            }
        }
    }
}