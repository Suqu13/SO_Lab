import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TESTER {

    private ArrayList<Request> allRequests;

    public TESTER() {
        allRequests = new ArrayList<Request>();
    }

    public void load() {

        try {
            Scanner sc;
            sc = new Scanner(new File("dane.txt"));
            while (sc.hasNext()) {
                allRequests.add(new Request(sc.nextInt(), sc.nextInt()));
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\nDługość kolejki wszyskich żądań: " + allRequests.size());
    }

    public Object cloneList(ArrayList<Request> list) {
        ArrayList<Request> newList = new ArrayList<Request>();

        for (Request req : list) {
            try {
                newList.add((Request)req.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return newList;
    }

    public  ArrayList<Request> getAllRequests() {
        return allRequests;
    }

    public static void main(String[] args) {

        TESTER tester = new TESTER();
        tester.load();

        FCFS fcfs = new FCFS((ArrayList<Request>) tester.cloneList(tester.allRequests));
        System.out.println("Algorytm FCFS: " + fcfs.runFCFS());

        SSTF sstf = new SSTF((ArrayList<Request>) tester.cloneList(tester.allRequests));
        System.out.println("Algorytm SSTF: " + sstf.runSSTF());

        SCAN scan = new SCAN((ArrayList<Request>) tester.cloneList(tester.allRequests));
        System.out.println("Algorytm SCAN: " + scan.runSCAN());

        C_SCAN c_scan = new C_SCAN((ArrayList<Request>) tester.cloneList(tester.allRequests));
        System.out.println("Algorytm C-SCAN: " + c_scan.runC_SCAN());

        FD_SCAN FD_scan = new FD_SCAN((ArrayList<Request>) tester.cloneList(tester.allRequests));
        System.out.println("Algorytm FD-SCAN: " + FD_scan.runFD_SCAN());

        EDF edf = new EDF((ArrayList<Request>) tester.cloneList(tester.allRequests));
        System.out.println("Algorytm EDF: " + edf.runEDF());






    }
}

