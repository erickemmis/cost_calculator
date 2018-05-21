package com.vml.costCalculator;

public class App {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		TotalPrinter totalPrinter = new TotalPrinter(calculator);
		Greeter greeter = new Greeter();
		
		//greet the user
		greeter.greetUser();
		
		//provide instructions to use the calculator
		greeter.provideCalculatorInstructions();
		
		if(greeter.enterToContinue()) {
		// collect costs through addCosts
		calculator.retrieveCosts();
		}

		// print net Total, Tax and Total
		totalPrinter.printNetTotalTaxAndTotal();
		
		
	}
}
