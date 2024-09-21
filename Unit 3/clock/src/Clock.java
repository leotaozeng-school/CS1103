// https://www.w3schools.com/java/java_date.asp
// java.time classes are the modern replacement for the troublesome old legacy date-time classes bundled with the earliest versions of Java
import java.time.*;
import java.time.format.DateTimeFormatter;

// Clock class responsible for managing and displaying current time and date
public class Clock {
    private String currentTime;
    private final DateTimeFormatter formatter;

    // Constructor Declaration of Class
    public Clock(String timeFormat) {
        // The formatter is initialized based on the input parameter passed to the constructor.
        this.formatter = DateTimeFormatter.ofPattern(timeFormat);
        this.currentTime = LocalDateTime.now().format(this.formatter);
    }

    public String getCurrentTime() {
        return this.currentTime;
    }

    private void updateTime() {
        this.currentTime = LocalDateTime.now().format(this.formatter);
    }
}
