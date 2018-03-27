import java.util.ArrayList;

public class FCFS {

    private ArrayList<Request> inQueue = new ArrayList<Request>(); //lista żądań w kolejce do tysku
    private ArrayList<Request> workingReq; //kopia żądań pobranych z pliku


    public FCFS(ArrayList<Request> list) {
        workingReq = list;
        addToQueue(); //piersze wczytanie do inQueue które musi być wykonane
    }

    // Metodoa wykonująca algorymt fcfs
    public int runFCFS() {

        int directionOfMovement = 1; //dla ruchu w prawo 1, w lewo -1
        int headMovements = 0;
        int headPosition = 0;

        while (inQueue.size() != 0) {

            addToQueue();

            //sprawdza w jakim kierunku obecnie porusza się głowica
            if (inQueue.get(0).getPath() > headPosition && directionOfMovement == -1) {
                directionOfMovement = 1;
                headMovements++;
            } else if (inQueue.get(0).getPath() < headPosition && directionOfMovement == 1) {
                directionOfMovement = -1;
                headMovements++;
            }
            headPosition = inQueue.get(0).getPath();
            inQueue.remove(0);

        }
        return headMovements;
    }

    @SuppressWarnings("Duplicates")
    // Metoda dodająca z workingReq to inQueue
    private void addToQueue() {

        int p = 0;

        if (inQueue.size() <= 5 || inQueue.isEmpty()) {
            while (p < 15) {
                if (workingReq.size() != 0) {
                    inQueue.add(workingReq.get(0));
                    workingReq.remove(0);
                    p++;
                } else {
                    return;
                }

            }
        }
    }
}
