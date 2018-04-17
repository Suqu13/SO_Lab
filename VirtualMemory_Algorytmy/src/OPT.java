import java.util.ArrayList;

public class OPT {
    private ArrayList<Frame> frames;
    private ArrayList<Integer> appeals;

    public OPT(ArrayList<Frame> frames, ArrayList<Integer> appeals) {
        this.frames = frames;
        this.appeals = appeals;
    }


    @SuppressWarnings("Duplicates")
    private int runOPT() {
        int pageErrors = 0;
        boolean lackInFrames = true;
        int index = -1;
        int[] copy = new int[frames.size()];

        for (int appeal : appeals) {
            for (Frame frame : frames) {
                if (frame.getPage() == -1) {
                    frame.setPage(appeal);
                    pageErrors++;
                    lackInFrames = false;
                    break;
                } else if (frame.getPage() == appeal) {
                    lackInFrames = false;
                    break;
                } else {
                    int m = 0;
                    int done = 0;

                    for (Frame fr : frames) {
                        copy[m] = fr.getPage();
                        m++;
                    }

                    for (int appeal_1 : appeals) {
                        for (int c = 0; c < copy.length; c++) {
                            if (copy[c] == appeal_1) {
                                copy[c] = -1;
                            }
                        }
                        for (int c = 0; c < copy.length; c++) {
                            if (copy[c] == -1) {
                                done++;
                            } else {
                                index = c;
                            }
                        }
                        if (done == copy.length - 1) break;
                        done = 0;
                    }
                }
            }
            if (lackInFrames) {
                frames.get(index).setPage(appeal);
                pageErrors++;
            }
            lackInFrames = true;

        }
        return pageErrors;
    }

    public void AVG_OPT() {
        int n = 0;
        int result = 0;
        while (n < 100) {

            result += runOPT();
            n++;
        }
        System.out.println("OPT: " + (int) Math.floor(result / n));

    }

}

