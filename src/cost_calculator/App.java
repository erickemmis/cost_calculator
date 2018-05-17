package cost_calculator;

import java.util.Scanner;

public class App {
	

	
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		Scanner scanner = new Scanner(System.in);
		
		// collect costs through addCosts
		calculator.retrieveCosts(calculator, scanner);

		// print totals
		calculator.printTotals();
		
	}
	

}
