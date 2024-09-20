import java.time.*;
import java.time.format.DateTimeFormatter;

public class Clock {
    private LocalDateTime currentTime;
    private DateTimeFormatter timeFormatter;
    private DateTimeFormatter dateFormatter;

    // Constructor Declaration of Class
    public Clock() {
        this.currentTime = LocalDateTime.now();
        this.timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    // Getters
    public LocalDateTime displayCurrentTime() {
        return this.currentTime;
    }
}
