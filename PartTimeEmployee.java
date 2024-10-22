public class PartTimeEmployee extends Employee {
    private static final double TAX_RATE = 0.12; // 12% tax for part-time employees

    public PartTimeEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name, hoursWorked, hourlyRate);
    }

    @Override
    public double calculatePay() {
        double grossPay = hoursWorked * hourlyRate;
        double tax = grossPay * TAX_RATE;
        return grossPay - tax; // Part-time employees pay tax but no benefits
    }
}