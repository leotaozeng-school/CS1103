public class ClockDisplay implements Runnable {
    private final Clock clock;
    private volatile boolean running = true;

    // Constructor Declaration of Class
    public ClockDisplay(Clock clock) {
        this.clock = clock;
    }

    public void run() {
        while (this.running) {
            try {
                System.out.println(this.clock.getCurrentTime());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop() {
        this.running = false;
    }
}
