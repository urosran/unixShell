package cs131.pa1.filter.sequential;

import java.util.LinkedList;

/**
 * Created by Uros Randelovic on 9/21/2017.
 */
public class Pwd extends SequentialFilter{
    public Pwd() {
        input = new LinkedList<>();
        output = new LinkedList<>();
    }
    public void process(){
        SequentialREPL.currentWorkingDirectory

    }
    public String  processLine(String string){
        return "uros";
    }

}
