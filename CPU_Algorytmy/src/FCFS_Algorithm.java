import java.util.ArrayList;
import java.util.Collections;

public class FCFS_Algorithm implements Algorithm {


    @Override
    public void execute(ArrayList<Process> processes) {
        int timeOfCpuUsage = 0;
        ArrayList<Process> processes_in = new ArrayList<>();

        for (Process process : processes) {
            processes_in.add(process);
        }

        Collections.sort(processes_in, (o1, o2) -> o1.getArrivalTime() - o2.getArrivalTime());

        while (!processes_in.isEmpty()) {
            Process process = processes_in.get(0);
            if (timeOfCpuUsage <= process.getArrivalTime()) {
                process.setWaitingTime(0);
                timeOfCpuUsage = process.getArrivalTime() + process.getTimeOfCpuUsage();
            } else {
                process.setWaitingTime(timeOfCpuUsage - process.getArrivalTime());
                timeOfCpuUsage += process.getTimeOfCpuUsage();
            }
            processes_in.remove(0);
        }


    }

    @Override
    public void showResult(ArrayList<Process> processes) {
        double average = 0;
        for (Process process: processes) {
            average += process.getWaitingTime();
        }

        System.out.println("FCFS average: " + average / processes.size());
    }
}
