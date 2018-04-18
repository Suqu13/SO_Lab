import Algorithms.*;
import Objects.Reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TESTER {
    static int givenNumber;
    static int pages;
    static int frames;
    static int number;

    public static void askAndRun() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nHow many references do you want to provide?");
        do {
            System.out.print("Write an integer between 100 and 10000: ");
            try {
                givenNumber = scanner.nextInt();
            } catch (NumberFormatException nfe) {
                givenNumber = -1;
            }
        } while (!(givenNumber <= 10000 && givenNumber >= 100));


        System.out.println("Provide number of pages in the simulation");
        do {
            System.out.print("Write an integer between 1 and 100: ");
            try {
                pages = scanner.nextInt();
            } catch (NumberFormatException nfe) {
                pages = -1;
            }
        } while (!(pages <= 100 && pages >= 1));


        System.out.println("Provide number of frames in the simulation");
        do {
            System.out.print("Write an integer between 1 and 50: ");
            try {
                frames = scanner.nextInt();
            } catch (NumberFormatException nfe) {
                frames = -1;
            }
        } while (!(frames >= 1 && frames <= 50));


        System.out.println("Specify the number of executions of individual algorithms from which you want to calculate the average");
        do {
            System.out.print("Write an integer between 100 and 1000: ");
            try {
                number = scanner.nextInt();
            } catch (NumberFormatException nfe) {
                number = -1;
            }
        } while (!(number >= 100 && number <= 1000));

        scanner.close();



        int n = 0;
        while (n < 10) {
            Reference reference_ = new Reference(givenNumber, pages);
            ArrayList<Integer> reference = reference_.creatingReference();

            List<Algorithm> algorithms = new ArrayList<>();
            algorithms.add(new OPT(reference, frames));
            algorithms.add(new LRU(reference, frames));
            algorithms.add(new SC(reference, frames));
            algorithms.add(new FIFO(reference, frames));
            algorithms.add(new RAND(reference, frames));

            System.out.println(" ");

            for (Algorithm algorithm : algorithms) {
                algorithm.simulate(number);
            }
            n++;
        }
    }

    public static void main(String[] args) {


        askAndRun();


    }

}
