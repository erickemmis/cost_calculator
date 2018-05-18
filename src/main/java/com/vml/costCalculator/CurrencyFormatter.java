package com.vml.costCalculator;

import java.text.DecimalFormat;

public class CurrencyFormatter {
	
	/**
	 * Formats a double into a standard US currency format
	 * Example: 122.00 becomes $122.00
	 * @param cost - amount as a double
	 * @return formatted currency string
	 */
	public static String formatDoubleToUSD(double cost) {
		String formatedCost = "$";
		
		/*move decimal trim end and return decimal*/
		DecimalFormat formatter = new DecimalFormat("#.##");
		formatedCost += formatter.format(cost);
		
		return formatedCost;
	}
	
}
