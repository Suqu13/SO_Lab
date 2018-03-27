package SJF_PACK;

import java.util.*;

public class Processor {

    private List<Process> listOutProcessor = new ArrayList<Process>();
    private List<Process> listInProcessor = new LinkedList<Process>();
    private int wholeTime = 0;



    public void addListOutProcessor(Process process) {
        listOutProcessor.add(process);
    }


    public void addListInProcessor(){
        Process process=listOutProcessor.get(0);
        listOutProcessor.remove(process);
        if(process.getArrivalTime()==wholeTime){
            listInProcessor.add(process);
        }
    }


    public void isSorted() throws IndexOutOfBoundsException{
        for (int i=0; i<listInProcessor.size(); i++){
           int j=i+1;

        }
    }








    public void doProcess(){

        wholeTime+=1; //Entering of the process




    }
}



