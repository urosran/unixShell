package cs131.pa1.filter.sequential;

import cs131.pa1.filter.Message;

/**
 * Created by Uros Randelovic on 9/24/2017.
 */
public class GrepFilter extends SequentialFilter {
    private String findThis = "";
//TODO: got rid of exception
    public GrepFilter(String line) {
        String[] parameters = line.split(" ");
        if (parameters.length>1){
            this.findThis = parameters [1];
        }else {
            System.out.printf(Message.REQUIRES_PARAMETER.toString(), line);
        }
    }
//TODO: THIS HAS BEEN CHANGED TO THE IF STATEMENT
    public String processLine(String line){
        if (line.contains(findThis)){
            return line;
        }else{
            return null;
        }

    }




}
