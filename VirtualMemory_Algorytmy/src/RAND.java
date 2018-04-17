import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RAND {

    private ArrayList<Integer> appeals;
    int size;

    public RAND(ArrayList<Integer> appeals, int size) {
        this.appeals = appeals;
        this.size = size;
    }

    @SuppressWarnings("Duplicates")
    private int runRAND() {
        int pageErrors = 0;
        boolean lackInFrames = true;
        List<Integer> frames = new ArrayList<Integer>();

        for (int appeal : appeals) {
            if (frames.size() < size) {
                frames.add(appeal);
                pageErrors++;
                lackInFrames = false;
            } else {
                for (int frame : frames) {
                    if (frame == appeal) {
                        lackInFrames = false;
                        break;
                    }
                }
            }

            if (lackInFrames) {
                Random generator = new Random();
                int index = generator.nextInt(size);
                frames.add(index, appeal);
                frames.remove(index + 1);
                pageErrors++;
            }
            lackInFrames = true;
        }
        return pageErrors;
    }

    public void AVG_RAND() {
        int n = 0;
        int result = 0;
        while (n < 1000) {

            result += runRAND();
            n++;
        }
        System.out.println("RAND: " + (int) Math.floor(result / n));

    }


}
