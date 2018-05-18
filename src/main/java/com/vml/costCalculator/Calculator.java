package com.vml.costCalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
	
	private double taxRate = .07;
	private double total = 0;
	private List<Double> listOfCosts = new ArrayList<Double>();
	private Scanner scanner = new Scanner(System.in);
	
	
	//Default constructor
	public Calculator() {
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
	
	public double getCostFromConsole() {
		double cost = Double.parseDouble(scanner.nextLine());
		return cost;
	}
	
	public String getContinueFromConsole() {
		String prompt = scanner.nextLine();
		return prompt;
	}
	
	
	public void addCost(double cost) {
		
		listOfCosts.add(cost);
	}
	
	public double getTotal() {
		//TODO is this a good idea to recalculate every time get Total is called
		for(double cost : listOfCosts) {
			total += cost;
		}
		// return total		
		return total;
	}
	
	public double getTax(double cost) {
		//calculate the total tax
		double tax = cost * taxRate;
		
		//return new total
		return tax;
	}
	
	public void printTotals() {
		
		// gather totals
		total = getTotal();
		double taxAmount = getTax(total);
		double grandTotal = total + taxAmount;
		
		// print totals in console
		System.out.println(
				"Your sub-total is: " + CurrencyFormatter.formatDoubleToUSD(total) + 
				", your tax is: " + CurrencyFormatter.formatDoubleToUSD(taxAmount) + 
				" and your total is: " + CurrencyFormatter.formatDoubleToUSD(grandTotal)
			);
		
	}
	
	public void retrieveCosts() {
		
		//prompt for cost
		promptForCost();
		
		//retrieve cost
		double cost = getCostFromConsole();
		
		//add cost
		addCost(cost);
		
		//check to see if user
		if(!continueCheck()) {
			return;
		}
		
		// recurse //TODO do I need a this?
		this.retrieveCosts();	
	}
	
	public boolean continueCheck() {	
		
		//prompt and get command from user in console
		promptToContinue();
		String userResponse = getContinueFromConsole();
		
		//TODO should I be doing recursion as opposed to a while loop?
		while(!CommandValidator.isValid(userResponse)) {
			System.out.println("Please enter a valid command yes or no: ");
			userResponse = getContinueFromConsole();
		}
		
		// if user Response equals yes return true
		if(userResponse.equalsIgnoreCase(Command.YES)) {
			return true;
		}
		
		//otherwise return false
		return false;
		
	}
	
}
