import java.time.*;
import java.time.format.DateTimeFormatter;

public class Clock {
    private LocalDateTime currentTime;
    private DateTimeFormatter timeFormatter;
    private DateTimeFormatter dateFormatter;

    // Constructor Declaration of Class
    public Clock() {
        this.currentTime = LocalDateTime.now();
        this.timeFormatter = DateTimeFormatter.ofPattern("KK:mma");
        this.dateFormatter = DateTimeFormatter.ofPattern("cccc, MMMM dd, yyyy");
    }

    // Getters
    public String getTime() {
        return this.currentTime.format(this.timeFormatter);
    }

    public String getDate() {
        return this.currentTime.format(this.dateFormatter);
    }

    // Setters
    public void updateTime(String time) {
        this.currentTime = LocalDateTime.now();
    }

    // Other methods
    public void displayTimeAndDate() {
        System.out.println("Current time: " + this.getTime());
        System.out.println("Current date: " + this.getDate());
    }
}
