package cs131.pa1.filter.sequential;

import cs131.pa1.filter.Message;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Uros Randelovic on 9/22/2017.
 */


public class ImakeCommandsIamTheGod {
    public ImakeCommandsIamTheGod(){

    }



    public static List<SequentialFilter> makeFilterFromInput(String userInput){
        LinkedList filters = new LinkedList();
        String firstCommand = removeSecondFilter(userInput);
        if (firstCommand == null){
            return null;
        }else {
            String[] commands = firstCommand.split("\\|");

            for (int i = 0; i<=commands.length-1; i++){
                SequentialFilter filter = constructFilterFromCommand(commands[i].trim());
            }
        }
    }

    //creates a filter for each command instructed by the user
    private static SequentialFilter constructFilterFromCommand(String command){
        //create and object - filter to later cast it and return the sequential filter
        Object filter;
        //chopping up the string into separate commands and taking the first one to create a filter out of it
        String [] singleCommands = command.split(" ");
        if (singleCommands[0].equals("cd")){
            filter = new CdFilter();
            return (SequentialFilter) filter;
        }else if (singleCommands[0].equals("ls")){
            filter = new LsFilter();
            return (SequentialFilter) filter;
        }else if (singleCommands[0].equals("wc")){
            filter = new WcFilter();
            return (SequentialFilter) filter;
        }else if (singleCommands[0].equals("pwd")){
            filter = new PwdFilter();
            return (SequentialFilter) filter;
        }else if (singleCommands[0].equals("grep")){
            filter = new GrepFilter();
            return (SequentialFilter) filter;
        }else if (singleCommands[0].equals("head")){
            filter = new HeadFilter();
            return (SequentialFilter) filter;
        }else { System.out.printf(Message.COMMAND_NOT_FOUND.toString(), command); return null;}
    }
    //removes the pointers from the command to make it readable and also returns the first filter
    private static String removeSecondFilter(String userInput){
        //removing the ">" from the input to read the command
        String [] removeFilePointer = userInput.split(">");
        if (removeFilePointer.length > 1){

            if (removeFilePointer[0].trim().equals("")){
                //removed objects
                System.out.printf(Message.REQUIRES_INPUT.toString(), (">"+removeFilePointer[1].trim()));
                return null;
            }
            if (removeFilePointer[1].contains("|")){
                System.out.printf(Message.CANNOT_HAVE_OUTPUT.toString(),
                        ">" + removeFilePointer[1].substring(0, removeFilePointer[1].indexOf("|")));
                return null;
            }
            if (removeFilePointer.length >2 ){
                System.out.printf(Message.CANNOT_HAVE_OUTPUT.toString(), removeFilePointer[1].trim());
            }
        }
        return removeFilePointer[0];
    }
}
