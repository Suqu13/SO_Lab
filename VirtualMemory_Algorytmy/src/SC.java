import java.util.ArrayList;

public class SC {


    private boolean lackInFrames = true;

    private ArrayList<Frame> frames = new ArrayList<>();
    private int[] appeals;

    public SC(Frame[] frames, int[] appeals) {
        for (Frame fr : frames) {
            this.frames.add(fr);
        }
        this.appeals = appeals;
    }

    private int maxTime() {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < frames.size(); i++) {
            if (frames.get(i).getTime() > max) {
                index = i;
                max = frames.get(i).getTime();
            }
        }
        return index;
    }

    private int runSC() {
        int pageErrors = 0;

        for (int i = 0; i < appeals.length; i++) {
            for (int j = 0; j < frames.size(); j++) {
                if (frames.get(j).getPage() == -1) {
                    frames.get(j).setPage(appeals[i]);
                    pageErrors++;
                    lackInFrames = false;
                    break;
                } else if (frames.get(j).getPage() == appeals[i]) {
                    lackInFrames = false;
                    break;
                }
            }

            if (lackInFrames) {
                int j = maxTime();
                while (frames.get(j).getMarker() == 1) {
                    frames.get(j).setTime(0);
                    frames.get(j).setMarker(0);
                    frames.add(0, frames.get(j));
                    frames.remove(j + 1);
                    j = maxTime();
                }
                frames.get(j).setPage(appeals[j]);
                frames.get(j).setTime(0);
                frames.get(j).setMarker(1);
                pageErrors++;
            }

            lackInFrames = true;
            for (int k = 1; k < frames.size(); k++) {
                frames.get(k).setTime(frames.get(k).getTime() + 1);
            }
        }
        return pageErrors;
    }


    public void AVG_SC() {
        int n = 0;
        int result = 0;
        while (n < 10000) {

            result += runSC();
            n++;
        }
        System.out.println("SC: " + (int) Math.floor(result / n));

    }


}
