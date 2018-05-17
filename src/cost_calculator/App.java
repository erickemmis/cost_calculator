package cost_calculator;

import java.util.Scanner;

public class App {
	
	/*constants*/
	public static final String YES = "yes";
	
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		Scanner scanner = new Scanner(System.in);
		
		// collect costs through addCosts
		addCosts(calculator, scanner);

		
		// calculate total and tax given total
		double total = calculator.getTotal();
		double tax = calculator.getTax(total);
		
		// print totals
		//TODO
		calculator.printTotals();
		
	}
	
	public static void addCosts(Calculator calculator, Scanner scanner) {
		
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
		addCosts(calculator, scanner);	
	}
}
