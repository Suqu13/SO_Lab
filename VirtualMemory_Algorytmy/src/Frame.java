import java.util.ArrayList;

public class Frame implements Cloneable {
    private int page;
    private int time;
    private int timeOfUse;
    private int framesNumber;
    private int marker = 1;

    public int getMarker() {
        return marker;
    }

    public void setMarker(int marker) {
        this.marker = marker;
    }

    public int getTimeOfUse() {
        return timeOfUse;
    }

    public void setTimeOfUse(int timeOfUse) {
        this.timeOfUse = timeOfUse;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Frame(int framesNumber) {
        this.framesNumber = framesNumber;
        timeOfUse = 0;
        page = -1;
        time = 0;

    }

    public Frame() {
        page = -1;
        time = 0;
        timeOfUse = 0;
    }

    public ArrayList<Frame> creatingFrames() {
        int i = 0;
        ArrayList<Frame> frames = new ArrayList<>();
        while(i < framesNumber ) {
            frames.add(new Frame());
            i++;
        }
        return frames;
    }

    @Override
    public Frame clone() throws CloneNotSupportedException {
        Frame frame = new Frame();
        return frame;
    }
}

