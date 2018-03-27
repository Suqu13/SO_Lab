package FCFS_PACK;

import FCFS_PACK.Command;

public class FCFSBest {
    public static void main(String[] args) {

        Command com1 = new Command(3, false);
        Command com2 = new Command(2, false);
        Command com3 = new Command(5, false);
        Command com4 = new Command(1, false);
        Command com5 = new Command(2, true);
        Command com6 = new Command(1, true);
        Command com7 = new Command(4, false);
        Command com8 = new Command(5, true);
        Command com9 = new Command(12, false);
        Command com10 = new Command(11, false);
        Command com11 = new Command(18, false);
        Command com12 = new Command(3, true);

        Process pro1 = new Process(false);
        Process pro2 = new Process(false);
        Process pro3 = new Process(false);
        Process pro4 = new Process(false);
        Process pro5 = new Process(false);
        Process pro6 = new Process(false);
        Process pro7 = new Process(false);
        Process pro8 = new Process(false);
        Process pro9 = new Process(false);
        Process pro10 = new Process(false);
        Process pro11 = new Process(true);
        Process pro12 = new Process(true);
        Process pro13 = new Process(true);
        Process pro14 = new Process(true);
        Process pro15 = new Process(true);
        Process pro16 = new Process(true);
        Process pro17 = new Process(true);
        Process pro18 = new Process(true);

        pro1.addCommands(com1);
        pro1.addCommands(com2);
        pro1.addCommands(com3);

        pro2.addCommands(com4);
        pro2.addCommands(com5);
        pro2.addCommands(com4);

        pro3.addCommands(com4);
        pro3.addCommands(com6);
        pro3.addCommands(com5);
        pro3.addCommands(com4);

        pro4.addCommands(com2);
        pro4.addCommands(com7);
        pro4.addCommands(com8);
        pro4.addCommands(com1);

        pro5.addCommands(com2);
        pro5.addCommands(com2);
        pro5.addCommands(com1);
        pro5.addCommands(com2);

        pro6.addCommands(com5);
        pro6.addCommands(com2);
        pro6.addCommands(com1);

        pro7.addCommands(com1);
        pro7.addCommands(com1);

        pro8.addCommands(com6);
        pro8.addCommands(com4);

        pro9.addCommands(com9);
        pro9.addCommands(com10);

        pro10.addCommands(com1);
        pro10.addCommands(com1);
        pro10.addCommands(com2);
        pro10.addCommands(com7);
        pro10.addCommands(com7);
        pro10.addCommands(com4);

        pro11.addCommands(com7);
        pro11.addCommands(com7);

        pro12.addCommands(com12);
        pro12.addCommands(com7);

        pro13.addCommands(com4);
        pro13.addCommands(com2);

        pro14.addCommands(com6);
        pro14.addCommands(com2);

        pro15.addCommands(com1);
        pro15.addCommands(com1);
        pro15.addCommands(com7);

        pro16.addCommands(com8);
        pro16.addCommands(com5);
        pro16.addCommands(com2);

        pro17.addCommands(com4);
        pro17.addCommands(com4);
        pro17.addCommands(com4);

        pro18.addCommands(com11);


        ProcesorFCFS procesorFCFSB = new ProcesorFCFS();
        FCFS fcfsB = new FCFS(procesorFCFSB);

        fcfsB.addProces(pro8);
        fcfsB.addProces(pro13);
        fcfsB.addProces(pro14);
        fcfsB.addProces(pro17);
        fcfsB.addProces(pro2);
        fcfsB.addProces(pro3);
        fcfsB.addProces(pro7);
        fcfsB.addProces(pro6);
        fcfsB.addProces(pro12);
        fcfsB.addProces(pro11);
        fcfsB.addProces(pro5);
        fcfsB.addProces(pro16);
        fcfsB.addProces(pro1);
        fcfsB.addProces(pro15);
        fcfsB.addProces(pro4);
        fcfsB.addProces(pro10);
        fcfsB.addProces(pro18);
        fcfsB.addProces(pro9);



        System.out.printf("\n%1s %.2f", "The best situation for FCFS_PACK.FCFS algorithm: ", fcfsB.doAllProcesses());


    }
}
