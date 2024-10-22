public class ContractualEmployee extends Employee {

    public ContractualEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name, hoursWorked, hourlyRate);
    }

    @Override
    public double calculatePay() {
        return hoursWorked * hourlyRate; // No benefits, no tax, no overtime for contractual employees
    }
}