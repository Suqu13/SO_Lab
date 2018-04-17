import java.util.ArrayList;
import java.util.List;

public class FIFO {


    private boolean lackInFrames = true;

    private List<Integer> frames;
    private ArrayList<Integer> appeals;
    int size;

    public FIFO(ArrayList<Integer> appeals, int size) {
        this.appeals = appeals;
        this.size = size;
        frames = new ArrayList<Integer>();

    }

    @SuppressWarnings("Duplicates")
    private int runFIFO() {
        int pageErrors = 0;
        boolean lackInFrames = true;


        for (int appeal : appeals) {

            if (frames.size() < size) {
                frames.add(appeal);
                pageErrors++;
                lackInFrames = false;
            } else {
                for (int i = 0; i < frames.size(); i++) {
                    if (frames.get(i) == appeal) {
                        lackInFrames = false;
                        break;
                    }
                }
            }

            if (lackInFrames) {
                frames.remove(0);
                frames.add(appeal);
                pageErrors++;
            }
            lackInFrames = true;
        }

        return pageErrors;
    }

    public void AVG_FIFO() {
        int n = 0;
        int result = 0;
        while (n < 1000) {

            result += runFIFO();
            n++;
        }
        System.out.println("FIFO: " + (int) Math.floor(result / n));

    }
}
