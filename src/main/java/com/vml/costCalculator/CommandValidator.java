package com.vml.costCalculator;

import org.apache.commons.lang.StringUtils;


public class CommandValidator {
	
	/**
	 * Checks if a response is able to be pares as a double or blank.
	 * @param response - String containing the response text
	 * @return boolean indicating if the response is valid.
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
	
	
	/**
	 * Checks if the input is a a double.
	 * @param input - String containing input text
	 * @return boolean indicating if the string is a double or not
	 */
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
		
}
