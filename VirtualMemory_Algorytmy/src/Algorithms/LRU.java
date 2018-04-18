package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class LRU extends Algorithm {
    private ArrayList<Integer> reference;
    int size;

    public LRU(ArrayList<Integer> reference, int size) {
        this.reference = reference;
        this.size = size;

    }

    private int findMaxTime(ArrayList<Integer> time) {
        int index = -1;
        int max = Integer.MIN_VALUE;


        for (int i = 0; i < time.size(); i++) {
            if (time.get(i) > max) {
                max = time.get(i);
                index = i;
            }
        }

        return index;
    }


    @SuppressWarnings("Duplicates")
    private int runLRU() {
        int pageErrors = 0;
        boolean lackInFrames = true;
        List<Integer> frames = new ArrayList<Integer>();
        ArrayList<Integer> time = new ArrayList<>();


        for (int j = 0; j < reference.size(); j++) {

            if (frames.size() < size) {
                frames.add(reference.get(j));

                for (int i = 0; i < time.size(); i++) {
                    time.set(i, time.get(i) + 1);
                }

                time.add(0);
                pageErrors++;
                lackInFrames = false;
            } else {
                for (int i = 0; i < frames.size(); i++) {
                    if (frames.get(i) == reference.get(j)) {

                        for (int l = 0; l < time.size(); l++) {
                            time.set(l, time.get(l) + 1);
                        }

                        time.set(i, 0);
                        lackInFrames = false;
                        break;
                    }
                }
            }

            if (lackInFrames) {
                int index = findMaxTime(time);

                for (int i = 0; i < time.size(); i++) {
                    time.set(i, time.get(i) + 1);
                }

                time.set(index, 0);
                frames.add(index, reference.get(j));
                frames.remove(index + 1);
                pageErrors++;
            }
            lackInFrames = true;
        }
        return pageErrors;
    }

    private void AVG_LRU(int g) {
        int n = 0;
        double result = 0;
        while (n < g) {

            result += runLRU();
            n++;
        }
        System.out.printf("%6s %.2f\n","Algorithms.LRU: ",  (result / n));    }

    @Override
    public void simulate(int number) {
        AVG_LRU(number);
    }
}

