package cost_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;


public class Calculator {

	/*constants*/
	public static final String YES = "yes";
	
	private static double TAX = .07; 
	private List<Double> listOfCosts = new ArrayList<Double>();
	
	//Default constructor
	public Calculator() {
	}
	
	public Calculator(double tax) {
		// initialize calculator with Tax if passed in
		TAX = tax;
	}
	
	public void promptForCost() {
		System.out.println("Enter Charge");
	}
	
	public void promptToContinue() {
		System.out.println("Add another charge?");
	}
	
	public double getCostFromConsole(Scanner scanner) {
		double cost = Double.parseDouble(scanner.nextLine());
		return cost;
	}
	
	public String getContinueFromConsole(Scanner scanner) {
		String prompt = scanner.nextLine();
		return prompt;
	}
	
	
	public void addCost(double cost) {
		listOfCosts.add(cost);
	}
	
	public double getTotal() {
		double total = 0;
		//add up total from collected costs
		for(double costs : listOfCosts) {
			total += costs;
		}
		//be sure formated to 2 decimals
		
		return total;
	}
	
	public double getTax(double cost) {
		//calculate the total tax
		double tax = cost * TAX;
		
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
		double total = this.getTotal();
		double tax = this.getTax(total);
		double grandTotal = total + tax;
		
		// print totals in console
		System.out.println(
				"Your sub-total is: " + formatToCurrencyString(total) + 
				", your tax is: " + formatToCurrencyString(tax) + 
				" and your total is: " + formatToCurrencyString(grandTotal)
			);
		
	}
	
	public void retrieveCosts(Calculator calculator, Scanner scanner) {
		
		//prompt for cost
		calculator.promptForCost();
		
		//retrieve cost
		double cost = calculator.getCostFromConsole(scanner);
		
		//add cost
		calculator.addCost(cost);
		
		//prompt for continue
		calculator.promptToContinue();
		
		//retrieve continue response
		String userResponse = calculator.getContinueFromConsole(scanner);
		
		if(!userResponse.equalsIgnoreCase(YES)) {
			return;
		}
		
		// recurse
		this.retrieveCosts(calculator, scanner);	
	}
	
	
}