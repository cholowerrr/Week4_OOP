import java.util.List;
import java.util.Scanner;

public class PayrollTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();

        while (true) {
            System.out.println("\n*******************************");
            System.out.println("Heyts Hey You Payroll System Menu");
            System.out.println("*******************************");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Search Employee by Name");
            System.out.println("6. Filter Employees by Type");
            System.out.println("7. Exit");

            int choice = InputValidator.getValidIntInput(scanner, "Enter your choice (1-7): ");
            scanner.nextLine();  // Clear the newline character from the input buffer

            switch (choice) {
                case 1: // Add Employee
                    System.out.println("\n*******************************");
                    String type = InputValidator.getValidEmployeeType(scanner);
                    String name = InputValidator.getValidStringInput(scanner, "Enter Employee Name: ");
                    int hoursWorked = InputValidator.getValidIntInput(scanner, "Enter Hours Worked: ");
                    double hourlyRate = InputValidator.getValidDoubleInput(scanner, "Enter Hourly Rate: ");
                    Employee newEmployee;

                    if (type.equalsIgnoreCase("fulltime")) {
                        double overtimeHours = InputValidator.getValidDoubleInput(scanner, "Enter Overtime Hours: ");
                        newEmployee = new FullTimeEmployee(name, hoursWorked, hourlyRate, overtimeHours);
                    } else if (type.equalsIgnoreCase("parttime")) {
                        newEmployee = new PartTimeEmployee(name, hoursWorked, hourlyRate);
                    } else {
                        newEmployee = new ContractualEmployee(name, hoursWorked, hourlyRate);
                    }

                    payrollSystem.addEmployee(newEmployee);
                    System.out.println("Employee added successfully.");
                    break;

                case 2: // Display Employees
                    payrollSystem.displayEmployees();
                    break;

                case 3: // Update Employee
                    System.out.println("\n*******************************");
                    int updateIndex = InputValidator.getValidIntInput(scanner, "Enter Employee Index to Update (starting from 1): ");
                    // Convert to 0-based index for internal processing
                    int internalUpdateIndex = updateIndex - 1; 
                    
                    if (internalUpdateIndex < 0 || internalUpdateIndex >= payrollSystem.getEmployees().size()) {
                        System.out.println("Invalid index. Please try again.");
                        break;
                    }
                    name = InputValidator.getValidStringInput(scanner, "Enter Employee Name: ");
                    hoursWorked = InputValidator.getValidIntInput(scanner, "Enter Hours Worked: ");
                    hourlyRate = InputValidator.getValidDoubleInput(scanner, "Enter Hourly Rate: ");
                    double overtimeHours = 0;

                    if (payrollSystem.getEmployees().get(internalUpdateIndex) instanceof FullTimeEmployee) {
                        overtimeHours = InputValidator.getValidDoubleInput(scanner, "Enter Overtime Hours: ");
                    }

                    payrollSystem.updateEmployee(internalUpdateIndex, name, hoursWorked, hourlyRate, overtimeHours);
                    System.out.println("Employee updated successfully.");
                    System.out.println("*******************************");
                    break;

                case 4: // Remove Employee
                    System.out.println("\n*******************************");
                    int removeIndex = InputValidator.getValidIntInput(scanner, "Enter Employee Index to Remove (starting from 1): ");
                    // Convert to 0-based index for internal processing
                    int internalRemoveIndex = removeIndex - 1; 

                    if (internalRemoveIndex < 0 || internalRemoveIndex >= payrollSystem.getEmployees().size()) {
                        System.out.println("Invalid index. Please try again.");
                        break;
                    }

                    payrollSystem.removeEmployee(internalRemoveIndex);
                    System.out.println("Employee removed successfully.");
                    System.out.println("*******************************");
                    break;

                case 5: // Search Employee by Name
                    System.out.println("\n*******************************");
                    String searchName = InputValidator.getValidStringInput(scanner, "Enter Employee Name to Search: ");
                    Employee foundEmployee = payrollSystem.searchEmployeeByName(searchName);
                    if (foundEmployee != null) {
                        System.out.println(foundEmployee.getName() + ": " + foundEmployee.calculatePay());
                    } else {
                        System.out.println("Employee not found.");
                    }
                    System.out.println("*******************************");
                    break;

                case 6: // Filter Employees by Type
                    System.out.println("\n*******************************");
                    type = InputValidator.getValidEmployeeType(scanner);
                    List<Employee> filteredEmployees = payrollSystem.filterEmployeesByType(type);
                    System.out.println("Filtered Employees:");
                    for (Employee employee : filteredEmployees) {
                        System.out.println(employee.getName() + ": " + employee.calculatePay());
                    }
                    System.out.println("*******************************");
                    break;

                case 7: // Exit
                    System.out.println("\nExiting system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 7.");
                    break;
            }
        }
    }
}