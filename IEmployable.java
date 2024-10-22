public interface IEmployable {
    double calculatePay(); // Calculate pay based on employee type
    String getName(); // Get employee name
    int getHoursWorked(); // Get hours worked
    double getHourlyRate(); // Get hourly rate
    void setName(String name); // Set employee name
    void setHoursWorked(int hoursWorked); // Set hours worked
    void setHourlyRate(double hourlyRate); // Set hourly rate
}