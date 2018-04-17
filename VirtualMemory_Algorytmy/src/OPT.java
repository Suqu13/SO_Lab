import java.util.ArrayList;
import java.util.List;

public class OPT {

    private ArrayList<Integer> appeals;
    int size;

    public OPT(ArrayList<Integer> appeals, int size) {
        this.appeals = appeals;
        this.size = size;

    }

    @SuppressWarnings("Duplicates")
    private int runOPT() {
        int pageErrors = 0;
        boolean lackInFrames = true;
        List<Integer> frames = new ArrayList<Integer>();

        for (int j = 0; j < appeals.size(); j++) {
            if (frames.size() < size) {
                frames.add(appeals.get(j));
                pageErrors++;
                lackInFrames = false;
            } else {
                for (int frame : frames) {
                    if (frame == appeals.get(j)) {
                        lackInFrames = false;
                        break;
                    }
                }
            }

            if (lackInFrames) {
                ArrayList<Integer> tab = new ArrayList<>();
                int number = 0;
                int index = -1;
                int k = j;

                for (int frame : frames) {
                    tab.add(frame);
                }

                while (k < appeals.size()) {
                    if (number < frames.size() - 1) {
                        for (int l = 0; l < frames.size(); l++) {
                            if (frames.get(l) == appeals.get(k)) {
                                tab.set(l, -1);
                                number++;
                                break;
                            }
                        }
                    }
                    k++;
                }


                for (int i = 0; i < tab.size(); i++) {
                    if (tab.get(i) != -1) {
                        index = i;
                    }
                }
                frames.add(index, appeals.get(j));
                frames.remove(index + 1);
                pageErrors++;
            }
            lackInFrames = true;
        }
        return pageErrors;
    }

    public void AVG_OPT() {
        int n = 0;
        int result = 0;
        while (n < 1000) {

            result += runOPT();
            n++;
        }
        System.out.println("OPT: " + (int) Math.floor(result / n));
    }
}

