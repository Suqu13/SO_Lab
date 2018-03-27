package FCFS_PACK;

import FCFS_PACK.ProcesorFCFS;
import FCFS_PACK.Process;

import java.util.ArrayList;

public class FCFS {

    private int n = 0;
    private ArrayList<Process> listProces = new ArrayList<Process>();
    private ProcesorFCFS procesor;

    public FCFS(ProcesorFCFS procesor) {
        this.procesor = procesor;
    }

    public void addProces(Process process) {
        listProces.add(process);
    }

    public double doAllProcesses() {
        System.out.println("\nTime of arrival a process to the processor: ");
        for (Process process : listProces) {
            procesor.doProces(process);
            n++;
        }
        return procesor.avgTime() / n;
    }


}
