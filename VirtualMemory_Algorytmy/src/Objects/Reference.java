package Objects;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Reference {
    private int referenceNumber;
    private int bound;

    public Reference(int referenceNumber, int bound) {
        this.referenceNumber = referenceNumber;
        this.bound = bound;

    }

    public ArrayList<Integer> creatingReference() {
        ArrayList<Integer> reference = new ArrayList<>();
        int i = 0;
        while (i < referenceNumber) {
            SecureRandom rand = new SecureRandom();
            int ap = rand.nextInt(bound);
            if (!reference.isEmpty()) {
                boolean t = true;
                while (t) {
                    int k = rand.nextInt(5);
                    ap = reference.get(reference.size() - 1) - 2 + k;
                    if (!(ap == reference.get(reference.size() - 1) || ap < 0 || ap > bound)) t = false;
                }
            }
            reference.add(ap);
            i++;
        }
        return reference;
    }

}
