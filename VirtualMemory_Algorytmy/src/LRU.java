import java.util.ArrayList;

public class LRU {
    private ArrayList<Frame> frames;
    private ArrayList<Integer> appeals;

    public LRU(ArrayList<Frame> frames, ArrayList<Integer> appeals) {
        this.frames = frames;
        this.appeals = appeals;
    }

    private int runLRU() {
        int index = -1;
        int pageErrors = 0;
        boolean lackInFrames = true;

        for (Integer appeal : appeals) {
            for (Frame frame : frames) {
                if (frame.getPage() == -1) {
                    frame.setPage(appeal);
                    frame.setTimeOfUse(0);
                    lackInFrames = false;
                    pageErrors++;
                    break;
                } else if (appeal.equals(frame.getPage())) {
                    lackInFrames = false;
                    frame.setTimeOfUse(0);
                    break;
                } else {
                    int time = frame.getTimeOfUse() + 1;
                    frame.setTimeOfUse(time);
                }
            }
            if (lackInFrames) {
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < frames.size(); k++) {
                    if (max < frames.get(k).getTimeOfUse()) {
                        max = frames.get(k).getTimeOfUse();
                        index = k;
                    }
                }
                frames.get(index).setPage(appeal);
                frames.get(index).setTimeOfUse(0);
                index = -1;
                pageErrors++;
            }
            lackInFrames = true;
        }
        return pageErrors;
    }

    public void AVG_LRU() {
        int n = 0;
        int result = 0;
        while (n < 100) {

            result += runLRU();
            n++;
        }
        System.out.println("LRU: " + (int) Math.floor(result / n));
    }
}

