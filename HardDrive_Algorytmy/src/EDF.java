import java.util.ArrayList;

public class EDF {
    private ArrayList<Request> inQueue = new ArrayList<Request>(); //lista żądań w kolejce do tysku
    private ArrayList<Request> workingReq; //kopia żądań pobranych z pliku

    public EDF(ArrayList<Request> allRequests) {
        workingReq = allRequests;
        addToQueue();
    }

    @SuppressWarnings("Duplicates")
    public int runEDF() {
        int directionOfMovement = 1;
        int headPosition = 0;
        int headMovements = 0;
        Request req;

        while (!inQueue.isEmpty()) {

            inQueue.sort((s1, s2) -> s1.getDeadline() - s2.getDeadline());

            req = inQueue.get(0);

            if (req.getPath() > headPosition && directionOfMovement == -1) {
                directionOfMovement = 1;
                headMovements++;
            } else if (req.getPath() < headPosition && directionOfMovement == 1) {
                directionOfMovement = -1;
                headMovements++;
            }

            while (headPosition != req.getPath()) {

                changeDeadlines();

                if (headPosition > req.getPath()) {
                    headPosition--;
                } else if (headPosition < req.getPath()) {
                    headPosition++;
                }
            }

            headPosition = req.getPath();
            inQueue.remove(req);
            addToQueue();

        }
        return headMovements;
    }

    @SuppressWarnings("Duplicates")
    //Metoda zmienia deadline o 1 i usuwa żądania o ujemnym deadline
    private void changeDeadlines() {
        int firstDeadline;
        for (int i = 0; i < inQueue.size(); i++) {
            firstDeadline = inQueue.get(i).getDeadline();
            inQueue.get(i).setDeadline(firstDeadline - 1);
            if (inQueue.get(i).getDeadline() < 0) {
                inQueue.remove(i);
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
