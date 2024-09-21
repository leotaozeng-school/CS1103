public class ClockUpdater implements Runnable {
    private final Clock clock;
    private volatile boolean running = true;

    // Constructor Declaration of Class
    public ClockUpdater(Clock clock) {
        this.clock = clock;
    }

    public void run() {
        while (this.running) {
            this.clock.updateTime();
            try {
                Thread.sleep(1000); // Update every second (1s = 1000ms)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop() {
        this.running = false;
    }
}
