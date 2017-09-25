package cs131.pa1.filter.sequential;

import cs131.pa1.filter.Filter;
import cs131.pa1.filter.Message;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Uros Randelovic on 9/24/2017.
 */
public class RedirectFilter extends SequentialFilter {
    private FileWriter writer;
    //TODO: remake this - don't think it works as well

    public RedirectFilter(String userInput) throws Exception {

        String[] param = userInput.split(">");
        if (param.length > 1) {
            if (param[1].trim().equals("")) {
                System.out.printf(Message.REQUIRES_PARAMETER.toString(), userInput.trim());
                throw new Exception();
            } else {
                try {
                    this.writer = new FileWriter(new File(SequentialREPL.currentWorkingDirectory
                            + Filter.FILE_SEPARATOR + param[1].trim()));
                } catch (IOException FileNotFound) {
                    System.out.printf(Message.FILE_NOT_FOUND.toString(), userInput);
                    throw new Exception();
                }
            }
        } else {
            System.out.printf(Message.REQUIRES_INPUT.toString(), userInput);
            throw new Exception();
        }
    }
    public void process() {
        while(!this.isDone()) {
            this.processLine((String)this.input.poll());
        }

    }

    public String processLine(String userInput) {
        try {
            this.writer.append(userInput + "\n");
            if(this.isDone()) {
                this.writer.flush();
                this.writer.close();
            }
        } catch (IOException FileNotFound) {
            System.out.printf(Message.FILE_NOT_FOUND.toString(), userInput);
        }

        return null;
    }
}

