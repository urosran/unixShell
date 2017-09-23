package cs131.pa1.filter.sequential;

import java.util.List;

public class SequentialCommandBuilder {
	
	public static List<SequentialFilter> createFiltersFromCommand(String command){
		//TODO: split by pipe - call constructFilter
		return null;
	}
	
	private static SequentialFilter determineFinalFilter(String command){
		return null; //print to console vs print to file
	}
	
	private static String adjustCommandToRemoveFinalFilter(String command){
		//modify the string to exclude the >
		return null;
	}
	
	private static SequentialFilter constructFilterFromSubCommand(String subCommand){

		return null;
	}

	private static boolean linkFilters(List<SequentialFilter> filters){
		return false;
	}
}
