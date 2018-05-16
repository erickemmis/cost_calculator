package cost_calculator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CostCalculator {
	/* constants */
	public static final String YES = "yes";
	
	
	/*type "main" ctrl space*/
	
	public static void main(String[] args) {
		
		CostCalculator calculator = new CostCalculator();
		Scanner scanner = new Scanner(System.in);
		List<Double> listOfCosts = new ArrayList<Double>();
		
		/* add all costs */
		addCosts(calculator, listOfCosts, scanner);
		/* total list of costs */
		double subTotal = calculator.getCostTotal(listOfCosts);
		/*get the calculated tax from total*/
		double calculatedTax = calculator.addTaxToTotal(subTotal);
		/*get the grand total with tax*/
		double total = subTotal + calculatedTax;
		
		/* print response with totals and calculated tax*/
		System.out.println("Your sub-total is: $" + calculator.formatToCurrency(subTotal) + 
						   ", your tax is: $" + calculator.formatToCurrency(calculatedTax) + 
						   " and your total is: $" + calculator.formatToCurrency(total));
		scanner.close();
	}
	
	public double addTaxToTotal(double total) {
		double taxAmount = .07;
		
		/*return the calculated total*/
		return taxAmount * total;
	}
	
	public double getCostTotal(List<Double> listOfCosts) {
		double total = 0.0;
		
		/*add list of costs together*/
		for( double cost : listOfCosts) {
			total += cost;
		}
		/*return  the total*/
		return total;
	}
	
	public static void addCosts(
			CostCalculator calculator, 
			List<Double> listOfCosts,
			Scanner scanner) {
		
		/* prompt the user for the cost */
		calculator.promptForCost();
		
		/* add the cost to our cost list */
		double cost = calculator.getCostFromConsole(scanner);
		listOfCosts.add(cost);
		
		/* see if the user has another cost to add */
		calculator.promptToContinue();
		String userResponse = calculator.getContinueFromConsole(scanner);
		
		/* if the user says anything other than 'yes', we return */
		if (!userResponse.equalsIgnoreCase(YES)) {
			return;
		}
		
		/* recurse */
		addCosts(calculator, listOfCosts, scanner);
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
	
	public double formatToCurrency(double number) {
		/*move decimal trim end and return decimal*/
		number = Math.round(100 * number) * .01;
		return number;
	}
	
	




}
