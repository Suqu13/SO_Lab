package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RAND extends Algorithm {

    private ArrayList<Integer> reference;
    int size;

    public RAND(ArrayList<Integer> reference, int size) {
        this.reference = reference;
        this.size = size;
    }

    @SuppressWarnings("Duplicates")
    private int runRAND() {
        int pageErrors = 0;
        boolean lackInFrames = true;
        List<Integer> frames = new ArrayList<Integer>();

        for (int reference : reference) {
            if (frames.size() < size) {
                frames.add(reference);
                pageErrors++;
                lackInFrames = false;
            } else {
                for (int frame : frames) {
                    if (frame == reference) {
                        lackInFrames = false;
                        break;
                    }
                }
            }

            if (lackInFrames) {
                Random generator = new Random();
                int index = generator.nextInt(size);
                frames.set(index, reference);
                pageErrors++;
            }
            lackInFrames = true;
        }
        return pageErrors;
    }

    private void AVG_RAND(int g) {
        int n = 0;
        double result = 0;
        while (n < g) {

            result += runRAND();
            n++;
        }
        System.out.printf("%6s %.2f\n","Algorithms.RAND: ", (result / n));

    }


    @Override
    public void simulate(int number) {
        AVG_RAND(number);
    }
}
