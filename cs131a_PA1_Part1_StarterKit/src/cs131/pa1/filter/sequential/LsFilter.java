package cs131.pa1.filter.sequential;

import java.io.File;


/**
 * Created by Uros Randelovic on 9/23/2017.
 */
public class LsFilter extends SequentialFilter{
    private int i = 0;
    //TODO: make access private
    //folder that we are looking into
    private File folder;
    //list of files that reside within the given folder
    private File [] listOfFiles;

    public LsFilter(){
        //set the folder equal to the current working directory
        this.folder = new File(SequentialREPL.currentWorkingDirectory);
        //load the names of the files into the array
        this.listOfFiles = folder.listFiles();
    }

    public void process(){
        //TODO: change to for loop if i not used as a call somewhere else
        while (this.i < this.listOfFiles.length){
            //add the name of each folder to the output to be displayed in folder or else
            this.output.add(this.processLine(""));
        }
    }
    //TODO: change this method into something more understandable - why so odd? Do i need this method at all?
    public String processLine(String line){
        return this.listOfFiles[this.i++].getName();
    }
}
