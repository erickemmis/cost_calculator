package cost_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;


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

	public static String formatToCurrencyString(double cost) {
	
	String formatedCost = "$";
	
	/*move decimal trim end and return decimal*/
	DecimalFormat formatter = new DecimalFormat("#.##");
	formatedCost += formatter.format(cost);
	
	return formatedCost;
	}
	
	public void printTotals() {
		
		// gather totals
		total = getTotal();
		double taxAmount = getTax(total);
		double grandTotal = total + taxAmount;
		
		// print totals in console
		System.out.println(
				"Your sub-total is: " + formatToCurrencyString(total) + 
				", your tax is: " + formatToCurrencyString(taxAmount) + 
				" and your total is: " + formatToCurrencyString(grandTotal)
			);
		
	}
	
	public void retrieveCosts(Calculator calculator) {
		
		//prompt for cost
		calculator.promptForCost();
		
		//retrieve cost
		double cost = calculator.getCostFromConsole();
		
		//add cost
		calculator.addCost(cost);
		
		//check to see if user
		if(!continueCheck(calculator)) {
			return;
		}
		
		// recurse //TODO do I need a this?
		this.retrieveCosts(calculator);	
	}
	
	
	
	public static boolean continueCheck(Calculator calculator) {	
		
		//prompt and get command from user in console
		calculator.promptToContinue();
		String userResponse = calculator.getContinueFromConsole();
		
		
		
		//TODO should I be doing recursion as opposed to a while loop?
		while(!CommandValidator.isValid(userResponse)) {
			System.out.println("Please enter a valid command yes or no: ");
			userResponse = calculator.getContinueFromConsole();
		}
		
		// if user Response equals yes return true
		if(userResponse.equalsIgnoreCase(Command.YES)) {
			return true;
		}
		
		//otherwise return false
		return false;
		
	}
	

	
	
}