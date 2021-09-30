public class Robot {
    private String name;
    private int processingTime;
    private int startedTheTaskInSeconds;

    public String getName() {
        return name;
    }

    public void beginWork(int startedTheTaskInSeconds) {
        this.startedTheTaskInSeconds = startedTheTaskInSeconds;
    }

    public boolean isBusy( int currentSeconds ) {
        if (startedTheTaskInSeconds == 0) {
            return false;
        }
        if (startedTheTaskInSeconds + processingTime > currentSeconds) {
            return true;
        } else {
            startedTheTaskInSeconds = 0;
            return false;
        }
    }

    public Robot(String name, int processingTime) {
        this.name = name;
        this.processingTime = processingTime;
        this.startedTheTaskInSeconds = 0;
    }
}
