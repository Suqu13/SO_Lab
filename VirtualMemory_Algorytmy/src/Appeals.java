import java.security.SecureRandom;
import java.util.ArrayList;

public class Appeals {
    private int appealsNumber;
    private int bound;

    public Appeals(int appealsNumber, int bound) {
        this.appealsNumber = appealsNumber;
        this.bound = bound;

    }

    public ArrayList<Integer> creatingAppeals() {
        ArrayList<Integer> appeals = new ArrayList<>();
        int i = 0;
        while (i < appealsNumber) {
            SecureRandom rand = new SecureRandom();
            int ap = rand.nextInt(bound);
            if (!appeals.isEmpty()) {
                boolean t = true;
                while (t) {
                    int k = rand.nextInt(5);
                    ap = appeals.get(appeals.size() - 1) - 2 + k;
                    if (!(ap == appeals.get(appeals.size() - 1) || ap < 0 || ap > bound)) t = false;
                }
            }
            appeals.add(ap);
            i++;
        }
        return appeals;
    }

}
