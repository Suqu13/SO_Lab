import java.util.ArrayList;
import java.util.Arrays;

public class TESTER {

    public ArrayList<Frame> cloneArray(ArrayList<Frame> frames) {

        ArrayList<Frame> frames_1 = new ArrayList<>();

        for (Frame frame : frames) {
            try {
                frames_1.add(frame.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return frames_1;
    }

    public static void main(String[] args) {

        Frame frame = new Frame(8);
        Appeals appeal = new Appeals();

        ArrayList<Frame> frames = frame.creatingFrames();
        ArrayList<Integer> appeals = appeal.creatingAppeals();

        TESTER tester = new TESTER();

        OPT opt = new OPT(frames, appeals);
        LRU lru = new LRU(tester.cloneArray(frames), appeals);
        FIFO fifo = new FIFO(tester.cloneArray(frames), appeals);

        RAND rand = new RAND((ArrayList<Frame>) tester.cloneArray(frames), appeals);
        //   SC sc = new SC((ArrayList<Frame>) tester.cloneArray(frames), appeals);

        System.out.println(" ");

        opt.AVG_OPT();
        lru.AVG_LRU();
        fifo.AVG_FIFO();
        rand.AVG_RAND();
        // sc.AVG_SC();



    }

}
