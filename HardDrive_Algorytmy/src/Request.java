import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Request implements Cloneable {


    private int path;
    private int deadline;

    public Request(int path, int deadline) {
        this.path = path;
        this.deadline = deadline;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Request req = new Request(this.getPath(), this.getDeadline());
        return req;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }
}
