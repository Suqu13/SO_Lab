import java.util.ArrayList;

//TODO OGARNIJ TO GÓWNO
public class FD_SCAN {
    private ArrayList<Request> inQueue = new ArrayList<Request>(); //lista żądań w kolejce do dysku
    private ArrayList<Request> workingReq; //kopia żądań pobranych z pliku

    public FD_SCAN(ArrayList<Request> list) {
        workingReq = list;
        addToQueue();
    }

    @SuppressWarnings("Duplicates")
    public int runFD_SCAN() {
        int directionOfMovement = 1;
        int headPosition = 0;
        int headMovements = 0;
        Request req;

        while (!inQueue.isEmpty()) {

            inQueue.sort((s1, s2) -> s1.getDeadline() - s2.getDeadline());
            req = inQueue.get(0);   //szuka i zwraca obiekt o najniższym deadline, req przyjmuje jego postać

            if (req.getPath() > headPosition && directionOfMovement == -1) {
                directionOfMovement = 1;
                headMovements++;
            } else if (req.getPath() < headPosition && directionOfMovement == 1) {
                directionOfMovement = -1;
                headMovements++;
            }

            doBetween(headPosition, req.getPath());  // wykonuje wszsykie żądania między ścieżką początkową, a ścieżką na której znajduje się żądanie z najkrótszym deadline
            headPosition = req.getPath();
            inQueue.remove(req);
            addToQueue();   //dodaje do inQueue
        }
        return headMovements;
    }

    //Metoda, która wykonuje żądania pomiędzy pewnymi ścieżkami, uwzględna przesunięcie ścieżki początkowej przy ruchu w lewo lub w prawo
    private void doBetween(int startingPath, int requestPath) {
        while (startingPath != requestPath) { //motywuje wykonywanie instrukcji powyżej do chwili całkowitego przesunięcia
            for (int i = 0; i < inQueue.size(); i++) {
                int b = inQueue.get(i).getPath();
                if ((startingPath > b && requestPath < b) || (startingPath < b && requestPath > b)) { //sprawdza czy żądanie z listy znajduje się w przedziale
                    inQueue.remove(i);
                }
            }

            changeDeadlines();

            //uwzględnienie kierunku ruchu
            if (startingPath > requestPath) {
                startingPath--;
            } else if (startingPath < requestPath) {
                startingPath++;
            }
        }
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
