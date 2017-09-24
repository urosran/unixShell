package cs131.pa1.filter.sequential;

import java.util.LinkedList;

/**
 * Created by Uros Randelovic on 9/21/2017.
 */
public class PwdFilter extends SequentialFilter{
    public PwdFilter() {
        input = new LinkedList<>();
        output = new LinkedList<>();
    }
    public void process(){
        this.output.add((this.processLine("")));
    }
    public String  processLine(String string){
        return SequentialREPL.currentWorkingDirectory;
    }
}
