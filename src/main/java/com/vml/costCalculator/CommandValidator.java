package com.vml.costCalculator;

import org.apache.commons.lang.StringUtils;


public class CommandValidator {
	
	/**
	 * enter a 
	 * @param response
	 * @return
	 */
	public static boolean isValidResponse(String response) {
		
		/* catches if the string is null or empty */
		if (StringUtils.isBlank(response)) {
			return true;
		}
		
		/* return true if input is a number*/
		if(isNumeric(response)) {
			return true;
		}
		
		//otherwise not valid
		return false;
	}
	
	//check if the number value is able to be parsed to double
	public static boolean isNumeric(String input) {
		  
		try  
		  {  
		    double number = Double.parseDouble(input);  
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    return false;  
		  }  
		
		  return true;  
	}

	
	
	
	/**
	 * Checks if a response is "yes" or "no". Case insensitive test.
	 * @param response - String containing the response text
	 * @return boolean indicating if the response is valid.
	 */
	public static boolean isValidYesNoResponse(String response) {
		
		/* we know the string isn't null or empty */
		/* trim leading and following spaces */
		String trimmedResponse = response.trim();
		
		/* true if case-insensitive 'yes' */
		if (StringUtils.equalsIgnoreCase(Command.YES, trimmedResponse)) {
			return true;
		}
		
		/* true if case-insensitive 'no' */
		if (StringUtils.equalsIgnoreCase(Command.NO, trimmedResponse)) {
			return true;
		}
		
		/* any set of chars that aren't yes or no is invalid */
		return false;
	}
	
		
}
