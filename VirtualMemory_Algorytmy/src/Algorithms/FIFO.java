package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class FIFO extends Algorithm {


    private boolean lackInFrames = true;

    private List<Integer> frames;
    private ArrayList<Integer> reference;
    int size;

    public FIFO(ArrayList<Integer> reference, int size) {
        this.reference = reference;
        this.size = size;
        frames = new ArrayList<Integer>();

    }

    @SuppressWarnings("Duplicates")
    private int runFIFO() {
        int pageErrors = 0;
        boolean lackInFrames = true;


        for (int reference : reference) {

            if (frames.size() < size) {
                frames.add(reference);
                pageErrors++;
                lackInFrames = false;
            } else {
                for (int i = 0; i < frames.size(); i++) {
                    if (frames.get(i) == reference) {
                        lackInFrames = false;
                        break;
                    }
                }
            }

            if (lackInFrames) {
                frames.remove(0);
                frames.add(reference);
                pageErrors++;
            }
            lackInFrames = true;
        }

        return pageErrors;
    }

    private void AVG_FIFO(int g) {
        int n = 0;
        double result = 0;
        while (n < g) {

            result += runFIFO();
            n++;
        }
        System.out.printf("%6s %.2f\n","Algorithms.FIFO: ", (result / n));
    }

    @Override
    public void simulate(int number) {
        AVG_FIFO(number);
    }
}
