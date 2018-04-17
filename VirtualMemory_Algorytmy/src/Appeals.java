import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Appeals {
    int pagesNumber = 10;
    int appealsNumber = 1000;


    public ArrayList<Integer> creatingAppeals() {
        ArrayList<Integer> appeals = new ArrayList<>();
        int i = 0;
        while (i< appealsNumber) {
            Random rand = new Random();
            int ap = rand.nextInt(30);
            if (!appeals.isEmpty()) {
                while (ap == appeals.get(appeals.size() - 1)) {
                    ap = rand.nextInt(30);
                }
            }
            appeals.add(ap);
            i++;
        }
        return appeals;
    }

    public static void main(String[] args) {
        Appeals appeals = new Appeals();
        ArrayList<Integer> list = appeals.creatingAppeals();
        for (int i: list) {
            System.out.print(" " + i  );
        }
    }
}
