package FCFS_PACK;

public class ProcesorFCFS {
    private int time = 0;
    private int arrivalTime = 0;


    public void doProces(Process process) {
        arrivalTime += time;
        System.out.println(time);
        time += 1;
        while (process.hasNextCommand()) {
            time += process.getCommand().getTime();
        }
        time += 1;

    }

    public int getTime() {
        return time;
    }


    public double avgTime() {
        return arrivalTime;
    }
}
