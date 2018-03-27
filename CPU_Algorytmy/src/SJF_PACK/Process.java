package SJF_PACK;

        import java.util.ArrayList;

public class Process {

    private ArrayList<Command> listOfCommands = new ArrayList<Command>();
    private int arrivalTime;
    private boolean priority;

    public Process(int arrivalTime, boolean priority) {
        this.arrivalTime = arrivalTime;
        this.priority = priority;
    }

    public void addCommand(Command command) {
        listOfCommands.add(command);
    }

    public int getWholeTimeOfExecutingProcess(){
        int n=0;
        for(Command command: listOfCommands){
            n+=command.getTime();
        }
        return n;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }
}
