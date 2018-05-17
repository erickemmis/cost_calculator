package cost_calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
	private List<Double> listOfCosts = new ArrayList<Double>();
	private static double TAX = .07; 
	
	public Calculator() {
		// TODO Auto-generated constructor stub
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
		//format to 2 decimal places
		tax = formatCurrency(tax);
		//return new total
		return tax;
	}

	public static double formatCurrency(double cost) {
	
	/*move decimal trim end and return decimal*/
	double number = Math.round(100 * cost) * .01;
	return number;
	}
	
	public void printTotals() {
		
		// gather totals
		double total = this.getTotal();
		double tax = this.getTax(total);
		double grandTotal = total + tax;
		
		// print totals in console
		System.out.println(
				"Your sub-total is: $" + total + 
				", your tax is: $" + tax+ 
				" and your total is: $" + grandTotal
			);
		
	}
	
	
	

		

}