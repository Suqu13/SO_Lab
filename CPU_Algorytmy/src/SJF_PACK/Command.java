package SJF_PACK;

public class Command {
    private int time;
    private boolean io;

    public Command(int time, boolean io) {
        this.time = time;
        this.io = io;
    }

    public int getTime() {
        return time;
    }

    public boolean isIo() {
        return io;
    }

    public void setIo(boolean io) {
        this.io = io;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
