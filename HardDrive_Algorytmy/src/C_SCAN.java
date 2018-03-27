import java.util.ArrayList;

public class C_SCAN {

    private ArrayList<Request> inQueue = new ArrayList<Request>(); //lista żądań w kolejce do tysku
    private ArrayList<Request> workingReq; //kopia żądań pobranych z pliku

    public C_SCAN(ArrayList<Request> allRequests) {
        workingReq = allRequests;
        addToQueue(); //piersze wczytanie do inQueue które musi być wykonane
    }

    public int runC_SCAN() {
        int headPosition = 0;
        int headMovements = 0;


        while (!inQueue.isEmpty()) {

            headMovements++;

            while (headPosition != 201) {
                checkPath(headPosition);
                headPosition++;
            }

            headPosition = 0;

            if (!inQueue.isEmpty())
                headMovements++;

        }
        return headMovements;
    }

    @SuppressWarnings("Duplicates")
    //Metoda która szuka wśród całej listy żądania o określonej ścieżce
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

