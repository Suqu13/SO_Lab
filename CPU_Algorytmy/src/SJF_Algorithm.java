import java.util.ArrayList;
import java.util.Collections;

public class SJF_Algorithm implements Algorithm {


    @Override
    public void execute(ArrayList<Process> processes) {
        int timeOfCpuUsage = 0;
        boolean t = true;
        ArrayList<Process> processes_inQueue = new ArrayList<>();
        ArrayList<Process> processes_inCPU = new ArrayList<>();

        for (Process process : processes) {
            processes_inQueue.add(process);
        }

        Collections.sort(processes_inCPU, (o1, o2) -> o1.getArrivalTime() - o2.getArrivalTime());


        while (t) {
            t = false;
            if (!processes_inQueue.isEmpty()) {
                if (processes_inQueue.get(0).getArrivalTime() == timeOfCpuUsage) {
                    processes_inCPU.add(processes_inQueue.get(0));
                    processes_inQueue.remove(0);
                    Collections.sort(processes_inCPU, (o1, o2) -> o1.getTimeOfCpuUsage() - o2.getTimeOfCpuUsage());
                }
            }
            if (!processes_inCPU.isEmpty()) {
                if (processes_inCPU.get(0).getTimeOfCpuUsage() == 0) {
                    processes_inCPU.get(1).setWaitingTime();
                    processes_inCPU.remove(0);
                }
                processes_inCPU.get(0).setTimeOfCpuUsage(processes_inCPU.get(0).getTimeOfCpuUsage() - 1);
                t = true;
            }
            timeOfCpuUsage++;
        }
    }

    @Override
    public void showResult(ArrayList<Process> processes) {

    }
}
