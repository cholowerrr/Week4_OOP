public abstract class Employee implements IEmployable {
    protected String name;
    protected int hoursWorked;
    protected double hourlyRate;

    // Constructor to initialize attributes
    public Employee(String name, int hoursWorked, double hourlyRate) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Getter and Setter methods for Employee attributes
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    // Abstract method to be overridden in subclasses
    @Override
    public abstract double calculatePay();
}