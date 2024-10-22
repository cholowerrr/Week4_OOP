public class FullTimeEmployee extends Employee {
    private double overtimeHours;
    private static final double BENEFIT_RATE = 0.1; // 10% benefits

    public FullTimeEmployee(String name, int hoursWorked, double hourlyRate, double overtimeHours) {
        super(name, hoursWorked, hourlyRate);
        this.overtimeHours = overtimeHours;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculatePay() {
        double regularPay = hoursWorked * hourlyRate;
        double overtimePay = overtimeHours * hourlyRate * 1.5; // Overtime is 1.5 times regular rate
        double benefit = (regularPay + overtimePay) * BENEFIT_RATE;
        return regularPay + overtimePay + benefit; // Full-time employees get benefits
    }
}