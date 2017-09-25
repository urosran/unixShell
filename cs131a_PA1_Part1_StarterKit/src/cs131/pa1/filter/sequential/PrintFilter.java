package cs131.pa1.filter.sequential;

/**
 * Created by Uros Randelovic on 9/24/2017.
 */
public class PrintFilter extends SequentialFilter {

    public PrintFilter(){

    }
    public void process(){
        while (!this.isDone()){
            //get the process from the input list and remove it while sending it to process line to print it on the console
            this.processLine(this.input.poll());//todo: this is == to remove just doesn't throw exception && deleted the casting to string
        }
    }
    public String processLine(String line){
        System.out.println(line);
        return null;
    }
}
