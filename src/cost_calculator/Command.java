package cost_calculator;

import java.util.ArrayList;
import java.util.List;

public class Command {
	/*constants*/
	
	public static final String YES = "yes";
	public static final String NO = "no";
	
	// list of commands
	public static List<String> commandList = new ArrayList<String>();

//	commandList.add(YES);
//	commandList.add(NO);
	
	
	
	//checks if user enters yes or no
	public static boolean isValid(String input) {
		
//		for(String command : commandList) {
//			if(input.equalsIgnoreCase(command)) {
//				return true;
//			}
//		}
		
		if(input.equalsIgnoreCase(YES) || input.equalsIgnoreCase(YES)) {
			return true;
		}
		
		

		
		return false;
	}

}
