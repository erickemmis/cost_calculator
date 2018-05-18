package com.vml.costCalculator;

import org.apache.commons.lang.StringUtils;

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
	
	/**
	 * Checks if a response is "yes" or "no". Case insensitive test.
	 * @param response - String containing the response text
	 * @return boolean indicating if the response is valid.
	 */
	public static boolean isValidYesNoResponse(String response) {
		
		/* catches if the string is null or empty */
		if (StringUtils.isBlank(response)) {
			return false;
		}
		
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
