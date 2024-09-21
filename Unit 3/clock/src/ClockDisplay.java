import java.util.logging.Level;
import java.util.logging.Logger;

public class ClockDisplay implements Runnable {
    private final Clock clock;
    private volatile boolean running = true;
    private static final Logger logger = Logger.getLogger(ClockDisplay.class.getName());

    // Constructor Declaration of Class
    public ClockDisplay(Clock clock) {
        this.clock = clock;
    }

    public void run() {
        while (this.running) {
            try {
                System.out.println(this.clock.getCurrentTime());
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "ClockDisplay thread interrupted", e);
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public void stop() {
        this.running = false;
    }
}
