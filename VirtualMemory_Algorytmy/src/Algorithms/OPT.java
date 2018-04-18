package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class OPT extends Algorithm {

    private ArrayList<Integer> reference;
    int size;

    public OPT(ArrayList<Integer> reference, int size) {
        this.reference = reference;
        this.size = size;

    }

    @SuppressWarnings("Duplicates")
    private int runOPT() {
        int pageErrors = 0;
        boolean lackInFrames = true;
        List<Integer> frames = new ArrayList<Integer>();

        for (int j = 0; j < reference.size(); j++) {
            if (frames.size() < size) {
                frames.add(reference.get(j));
                lackInFrames = false;
                pageErrors++;
            } else {
                for (int frame : frames) {
                    if (frame == reference.get(j)) {
                        lackInFrames = false;
                        break;
                    }
                }
            }

            if (lackInFrames) {
                ArrayList<Integer> copy_frame = new ArrayList<>();
                int number = 0;
                int index = -1;
                int k = j;

                for (int frame : frames) {
                    copy_frame.add(frame);
                }

                while (k < reference.size()) {
                    if (number < frames.size() - 1) {
                        for (int l = 0; l < copy_frame.size(); l++) {
                            if (copy_frame.get(l) == reference.get(k)) {
                                copy_frame.set(l, -1);
                                number++;
                                break;
                            }
                        }
                    }
                    k++;
                }

                for (int i = 0; i < copy_frame.size(); i++) {
                    if (copy_frame.get(i) != -1) {
                        index = i;
                        // break;
                    }
                }
                frames.set(index, reference.get(j));
                pageErrors++;
            }
            lackInFrames = true;
        }
        return pageErrors;
    }

    private void AVG_OPT( int g) {
        int n = 0;
        double result = 0;
        while (n < g) {

            result += runOPT();
            n++;
        }

        System.out.printf("%6s %.2f\n", "Algorithms.OPT: ", (double) (result / n));
    }

    @Override
    public void simulate(int number) {
        AVG_OPT(number);
    }
}

