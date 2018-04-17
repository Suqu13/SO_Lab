import java.util.ArrayList;

public class FIFO {


    private boolean lackInFrames = true;

    private ArrayList<Frame> frames;
    private ArrayList<Integer> appeals;

    public FIFO(ArrayList<Frame> frames, ArrayList<Integer> appeals) {
        this.frames = frames;
        this.appeals = appeals;
    }

    private int maxTime() {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < frames.size(); i++) {
            if (frames.get(i).getTime() > max) {
                max = frames.get(i).getTime();
                index = i;
            }
        }
        return index;
    }

    private int runFIFO() {
        int pageErrors = 0;

        for (int i = 0; i < appeals.size(); i++) {
            for (int j = 0; j < frames.size(); j++) {
                if (frames.get(j).getPage() == -1) {
                    frames.get(j).setPage(appeals.get(i));
                    pageErrors++;
                    lackInFrames = false;
                    break;
                } else if (frames.get(j).getPage() == appeals.get(i)) {
                    lackInFrames = false;
                    break;
                }
            }

            if (lackInFrames) {
                int maxIndex = maxTime();
                frames.get(maxIndex).setPage(appeals.get(i));
                frames.get(maxIndex).setTime(0);
                pageErrors++;
            }

            lackInFrames = true;
            for (Frame frame : frames) {
                int time = frame.getTime() + 1;
                frame.setTime(time);
            }
        }
        return pageErrors;
    }

    public void AVG_FIFO() {
        int n = 0;
        int result = 0;
        while (n < 100) {

            result += runFIFO();
            n++;
        }
        System.out.println("FIFO: " + (int) Math.floor(result / n));

    }
}
