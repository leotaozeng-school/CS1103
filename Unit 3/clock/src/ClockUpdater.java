import java.util.logging.Level;
import java.util.logging.Logger;

public class ClockUpdater implements Runnable {
    private final Clock clock;
    private volatile boolean running = true;
    private static final Logger logger = Logger.getLogger(ClockUpdater.class.getName());

    // Constructor Declaration of Class
    public ClockUpdater(Clock clock) {
        this.clock = clock;
    }

    public void run() {
        while (this.running) {
            try {
                this.clock.updateTime();
                Thread.sleep(1000); // Update every second (1s = 1000ms)
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "ClockUpdater thread interrupted", e);
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public void stop() {
        this.running = false;
    }
}
