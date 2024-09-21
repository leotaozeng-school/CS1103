import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Clock clock = new Clock("HH:mm:ss dd-MM-yyyy");

        ClockUpdater updater = new ClockUpdater(clock);
        ClockDisplay display = new ClockDisplay(clock);

        Thread updaterThread = new Thread(updater);
        Thread displayThread = new Thread(display);

        // Set thread priorities
        updaterThread.setPriority(Thread.NORM_PRIORITY);
        displayThread.setPriority(Thread.MAX_PRIORITY);

        updaterThread.start();
        displayThread.start();

        try {
            Thread.sleep(120000);  // Run for 2 minutes
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Main thread interrupted", e);
            Thread.currentThread().interrupt();
        } finally {
            updater.stop();
            display.stop();

            updaterThread.interrupt();
            displayThread.interrupt();

            try {
                updaterThread.join(1000);
                displayThread.join(1000);
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, "Interrupted while waiting for threads to finish", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}