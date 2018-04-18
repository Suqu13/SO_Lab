package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class SC extends Algorithm {


    private boolean lackInFrames = true;

    private ArrayList<Integer> reference;
    int size;

    public SC(ArrayList<Integer> reference, int size) {
        this.reference = reference;
        this.size = size;

    }

    @SuppressWarnings("Duplicates")
    private int runSC() {
        int pageErrors = 0;
        boolean lackInFrames = true;
        List<Integer> frames = new ArrayList<Integer>();
        ArrayList<Integer> byte_frame = new ArrayList<>();

        for (int reference : reference) {

            if (frames.size() < size) {
                frames.add(reference);
                byte_frame.add(1);
                pageErrors++;
                lackInFrames = false;
            } else {
                for (int i = 0; i < frames.size(); i++) {
                    if (frames.get(i) == reference) {
                        lackInFrames = false;
                        byte_frame.set(i, 1);
                        break;
                    }
                }
            }

            if (lackInFrames) {

                while (byte_frame.get(0) == 1) {
                    byte_frame.remove(0);
                    byte_frame.add(0);
                    frames.add(frames.get(0));
                    frames.remove(0);
                }

                frames.remove(0);
                byte_frame.remove(0);
                frames.add(reference);
                byte_frame.add(1);
                pageErrors++;
            }
            lackInFrames = true;

        }
        return pageErrors;
    }


    private void AVG_SC(int g) {
        int n = 0;
        double result = 0;
        while (n < g) {

            result += runSC();
            n++;
        }

        System.out.printf("%6s %.2f\n","Algorithms.SC: ", (result / n));
    }


    @Override
    public void simulate(int number) {
        AVG_SC(number);
    }
}
