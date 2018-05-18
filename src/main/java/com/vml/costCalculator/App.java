package com.vml.costCalculator;

public class App {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		// collect costs through addCosts
		calculator.retrieveCosts();

		// print totals
		calculator.printTotals();
		
	}
}
