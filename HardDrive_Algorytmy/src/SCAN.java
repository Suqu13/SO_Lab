import java.util.ArrayList;

public class SCAN {

    private ArrayList<Request> inQueue = new ArrayList<Request>(); //lista żądań w kolejce do tysku
    private ArrayList<Request> workingReq = new ArrayList<Request>(); //kopia żądań pobranych z pliku

    public SCAN(ArrayList<Request> allRequests) {
        workingReq = allRequests;
        addToQueue(); //piersze wczytanie do inQueue które musi być wykonane
    }

    public int runSCAN() {
        int headPosition = 0;
        int headMovements = 0;

        while (!inQueue.isEmpty()) {

            headMovements++;

            if (headPosition <= 0) {            //warunek początkowy, który determinyje inkrementacje/ ruch głowicy w prawo
                while (headPosition != 201) {
                    checkPath(headPosition);
                    headPosition++;
                }
            } else if (headPosition >= 200) {  //warunek początkowy, który determinyje dekrementacje/ ruch głowicy w lewo
                while (headPosition != -1) {
                    checkPath(headPosition);
                    headPosition--;
                }
            }

        }
        return headMovements;
    }

    @SuppressWarnings("Duplicates")
    //Metoda która szuka wśród całej listy żądania o określonej ścieżce i go usuwa
    private void checkPath(int pozycjaGłowicy) {
        for (int i = 0; i < inQueue.size(); i++) {
            Request req = inQueue.get(i);
            if (req.getPath() == pozycjaGłowicy) {
                inQueue.remove(req);
                addToQueue();
            }
        }
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
