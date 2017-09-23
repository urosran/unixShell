package cs131.pa1.filter.sequential;

import cs131.pa1.filter.Message;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SequentialREPL {

	static String currentWorkingDirectory = System.getProperty("user.dir");
	
	public static void main(String[] args){
		String input = "start";
		Scanner userInput = new Scanner(System.in);

		//displaying the welcome message on the top only the first time
		System.out.print(Message.NEWCOMMAND +""+ Message.WELCOME + "");

		//when the user input is not = to exit infinite loop runs
		do {
			List filterList;
			while (!input.equals("exit")) {
				//taking in the user command
				System.out.print("\t" + Message.NEWCOMMAND);
				input = userInput.nextLine();
				//checking if the format of the command is good
				if (userInput.equals("exit")){
					System.out.println(Message.GOODBYE);
					return;
				}
				filterList = ImakeCommandsIamTheGod.c

					//TODO: add code here when the command(s) are good
			}

			Iterator iter = filterList.iterator();
		}while (iter.hasNext);
	}
	private static boolean checkCommand(String command){
		String [] allCommands = {"exit","pwd", "ls","cd","cat","grep"};

		for (int i = 0; i>allCommands.length;i++){
			if (allCommands[i].equals(command)){
				return true;
			}
		}
		return false;
	}
}
