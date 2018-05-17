package cost_calculator;

public class CommandValidator {
	
	
	//focus on what is valid // keep it concise
	
	public static boolean isValid(String response) {
		
		//TODO validate commands return true if a commands is in list of commands
		
		//check if yes or no is the response
		if(response.equalsIgnoreCase(Command.YES) || response.equalsIgnoreCase(Command.NO)) {
		return true;
		}
		
		//otherwise not valid
		return false;
	}
		
}
