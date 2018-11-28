public class Process {
    private boolean priority;
    private boolean io;
    private int timeOfCpuUsage;
    private int arrivalTime;
    private int waitingTime;

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public boolean isIo() {
        return io;
    }

    public void setIo(boolean io) {
        this.io = io;
    }

    public int getTimeOfCpuUsage() {
        return timeOfCpuUsage;
    }

    public void setTimeOfCpuUsage(int timeOfCpuUsage) {
        this.timeOfCpuUsage = timeOfCpuUsage;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
}
