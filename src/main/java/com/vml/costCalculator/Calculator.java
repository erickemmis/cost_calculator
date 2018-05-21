package com.vml.costCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

/**
 * A Calculator class that will behave as follows
 * 1. Greet the user and explain how to use the calculator
 * 2. The user then enters a. valid number, b. empty string, c. something else
 * 
 * If the user entered a valid number (add it to our list of costs)
 * If the user entered an empty string (they are done, display the details)
 * If the user entered something else (prompt for valid input) 
 *
 *	Wouldn't it be awesome if we had a total printer!?
 */

public class Calculator {
	
	private double taxRate = .07;
	private double total = 0;
	private List<Double> listOfCosts = new ArrayList<Double>();
	private Scanner scanner = new Scanner(System.in);
	
	
	
	public Calculator() {
		//Default constructor
	}
	
	public Calculator(double tax) {
		// initialize calculator with Tax if passed in
		taxRate = tax;
	}
	
	public void promptForCost() {
		System.out.println("Enter Charge");
	}
	
	public void promptToContinue() {
		System.out.println("Add another charge?");
	}
	
	public String getResponseFromConsole() {
		String response = scanner.nextLine();
		return response;
	}
	
	public void addCost(double cost) {
		//add cost to total
		total += cost;
		//add cost to list
		listOfCosts.add(cost);
	}
	
	public double getNetTotal() {
		//return total for 
		return total;
	}

	public double getTax(double cost) {
		//calculate the total tax
		double tax = cost * taxRate;
		
		//return new total
		return tax;
	}
	
	public double getTotalCost() {
		//calculate the total cost with tax
		double totalCost = total + getTax(total);
		
		//return new total
		return totalCost;
	}
	

	
	public void retrieveCosts() {
		
		//prompt for cost
		promptForCost();
		
		//retrieve response
		String response = getResponseFromConsole();
		
		//validate response as a valid input
		boolean valid = CommandValidator.isValidResponse(response);
		
		//if invalid entry prompt to try again
		if (!valid) {
			System.out.println("Invalid number... Please try again");
		}
		
		//if blank entry exit
		if (StringUtils.isBlank(response)) {
			return;
		}
		
		//add cost
		if(valid) {
			addCost(Double.parseDouble(response));
		}
		
		retrieveCosts();	
	}
	

	
}
