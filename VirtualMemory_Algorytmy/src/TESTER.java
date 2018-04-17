import java.util.ArrayList;

public class TESTER {

    public static void main(String[] args) {

        Appeals appeal = new Appeals(10000, 20);


        ArrayList<Integer> appeals = appeal.creatingAppeals();

        TESTER tester = new TESTER();

        OPT opt = new OPT(appeals, 8);
        LRU lru = new LRU(appeals, 8);
        FIFO fifo = new FIFO(appeals, 8);

        RAND rand = new RAND(appeals, 8);
        //   SC sc = new SC((ArrayList<Frame>) tester.cloneArray(frames), appeals);

        System.out.println(" ");

        opt.AVG_OPT();
        lru.AVG_LRU();
        rand.AVG_RAND();
        fifo.AVG_FIFO();
        // sc.AVG_SC();


    }

}
