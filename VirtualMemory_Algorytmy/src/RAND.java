import java.util.ArrayList;
import java.util.Random;

public class RAND {
    private ArrayList<Frame> frames;
    private ArrayList<Integer> appeals;

    public RAND(ArrayList<Frame> frames, ArrayList<Integer> appeals) {
        this.frames = frames;
        this.appeals = appeals;
    }

    @SuppressWarnings("Duplicates")
    private int runRAND() {
        int pageErrors = 0;
        boolean lackInFrames = true;

        for (int i = 0; i < appeals.size(); i++) {
            for (int j = 0; j < frames.size(); j++) {
                if (frames.get(j).getPage() == -1) {
                    frames.get(j).setPage(appeals.get(i));
                    lackInFrames = false;
                    pageErrors++;
                    break;
                } else if (frames.get(j).getPage() == appeals.get(i)) {
                    lackInFrames = false;

                    break;
                }
            }
            if (lackInFrames) {
                Random random = new Random();
                int rand = random.nextInt(frames.size() - 1);
                frames.get(rand).setPage(appeals.get(i));
                pageErrors++;
            }
            lackInFrames = true;
        }
        return pageErrors;
    }

    public void AVG_RAND() {
        int n = 0;
        int result = 0;
        while (n < 100) {

            result += runRAND();
            n++;
        }
        System.out.println("RAND: " + (int) Math.floor(result / n));

    }


}
