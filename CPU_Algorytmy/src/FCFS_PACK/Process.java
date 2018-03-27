package FCFS_PACK;



import java.util.LinkedList;

public class Process {

    private LinkedList<Command> listCommands = new LinkedList<Command>();
    private boolean priority;


    public Process(boolean priority){
        this.priority=priority;
    }

    public void addCommands(Command command) {
        listCommands.add(command);
    }

    public Command getCommand() {
        Command com = listCommands.getFirst();
        listCommands.removeFirst();
        return com;
    }

    public boolean hasNextCommand() {
        return !this.listCommands.isEmpty();
    }

}
