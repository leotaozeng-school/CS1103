// https://www.w3schools.com/java/java_date.asp
// java.time classes are the modern replacement for the troublesome old legacy date-time classes bundled with the earliest versions of Java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Clock {
    private String currentTime;
    private final DateTimeFormatter formatter;
    private volatile boolean updated = false;

    // Constructor Declaration of Class
    public Clock(String timeFormat) {
        // The formatter is initialized based on the input parameter passed to the constructor
        this.formatter = DateTimeFormatter.ofPattern(timeFormat);
        this.currentTime = LocalDateTime.now().format(this.formatter);
    }

    // The display thread only shows the time after it has been updated
    public synchronized String getCurrentTime() throws InterruptedException {
        while (!this.updated) {
            wait(); // Wait until the time has been updated
        }
        this.updated = false;
        return this.currentTime;
    }

    public synchronized void updateTime() {
        this.currentTime = LocalDateTime.now().format(this.formatter);
        this.updated = true;
        notifyAll(); // Notify waiting threads that the time has been updated
    }
}
