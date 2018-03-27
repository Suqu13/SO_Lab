import java.util.ArrayList;
import java.util.Iterator;

public class SSTF {
    private ArrayList<Request> inQueue = new ArrayList<Request>(); //lista żądań w kolejce do tysku
    private ArrayList<Request> workingReq; //kopia żądań pobranych z pliku

    public SSTF(ArrayList<Request> allRequests) {
        workingReq = allRequests;
        addToQueue(); //piersze wczytanie do inQueue które musi być wykonane
    }

    // Metodoa wykonująca algorymt fcfs
    public int runSSTF() {

        int directionOfMovement = 1; //dla ruchu w prawo 1, w lewo -1
        int m;
        int headMovements = 0;
        int headPosition = 0;
        Request req;

        while (!inQueue.isEmpty()) {

            addToQueue();
            req = findTheClocest(headPosition);
            m = directionOfMovement;

            if (req.getPath() > headPosition) {
                directionOfMovement = 1;
            } else if (req.getPath() < headPosition) {
                directionOfMovement = -1;
            }
            if ((m * directionOfMovement) != 1) {
                headMovements++;
            }
            headPosition = req.getPath();
            inQueue.remove(req);

        }
        return headMovements;
    }


    // szuka i zwraca z listy inQueue obiekt położony najbliżej ścieżki
    private Request findTheClocest(int ścieżka) {
        Request req = null;
        Request theClosest = null;
        int max = Integer.MAX_VALUE;

        Iterator<Request> iterator = inQueue.iterator();

        while (iterator.hasNext()) {
            req = iterator.next();

          //bierzę pod uwagę wartość bezwzględną różnicy ścieżki początkowej i żądania
            if (Math.abs(ścieżka - req.getPath()) < max) {
                max = Math.abs(ścieżka - req.getPath());
                theClosest = req;
            }
        }
        return theClosest;
    }

    @SuppressWarnings("Duplicates")
    // Metoda dodająca z workingReq to inQueue
    private void addToQueue() {
        if (inQueue.size() <= 5 || inQueue.isEmpty()) {
            int p = 0;
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
