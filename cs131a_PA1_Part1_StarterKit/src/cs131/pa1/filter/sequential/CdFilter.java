package cs131.pa1.filter.sequential;

import cs131.pa1.filter.Filter;
import cs131.pa1.filter.Message;

import java.io.File;

/**
 * Created by Uros Randelovic on 9/23/2017.
 */
public class CdFilter extends SequentialFilter {
    private String setDirectoryTo = "";
    //TODO: throws Exception
    public CdFilter(String input){
        //get the current directory from the Sequential REPL
        this.setDirectoryTo = SequentialREPL.currentWorkingDirectory;
        //take the command sent from the God COmmand builder and split them
        String [] commandsSplitted = input.trim().split(" ");
        //check if there is only one command aka if a user just inputted CD without actually telling us where to go
        if (commandsSplitted.length == 1){
            System.out.printf(Message.REQUIRES_PARAMETER.toString(),(input.trim()));
//            TODO: throw new Exception();
        }else {
            String currentDirectory;
            //changing directory one step up
            if (commandsSplitted[1].equals("..")){
                //take the current directory
                currentDirectory = SequentialREPL.currentWorkingDirectory;
                //and add the separator plus the dots to go one file up
                currentDirectory = currentDirectory + Filter.FILE_SEPARATOR + commandsSplitted[1];
                //change the current working directory to the newly created one
                this.setDirectoryTo = currentDirectory;
            }else if (!commandsSplitted[1].equals(".")){
                currentDirectory = SequentialREPL.currentWorkingDirectory;
                currentDirectory = currentDirectory + Filter.FILE_SEPARATOR + commandsSplitted [1];
                //new file to go to
                File goToFile = new File(currentDirectory);
                //check if the file is there
                if (!goToFile.isDirectory()){
                    System.out.printf(Message.DIRECTORY_NOT_FOUND.toString(), input);
                    throw new IllegalArgumentException();
                //if the file is tehre set the directory to to go to newly formed directory
                }else {
                    this.setDirectoryTo = currentDirectory;
                }
            }
        }
    }
    //implementation of process method
    public void process(){this.processLine("");}
    //implementation of process line method required by the interface - used to change the static directory file
    //to the one that user wants to be in
    public String processLine(String userInput){
        SequentialREPL.currentWorkingDirectory = this.setDirectoryTo;
        return null;
    }
}
