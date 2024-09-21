import java.util.Date;

public class Main {
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
            e.printStackTrace();
        }

        // Stop the threads
        updater.stop();
        display.stop();
    }
}