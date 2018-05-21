package com.vml.costCalculator;


public class Greeter {
	
	
	public Greeter() {
		//default constructor
	}
	
	// greets user with welcome message
	public void greetUser() {
		System.out.println("Hello! Welcome to the Cost Calulator");
	}
	// provides instructions for user to use calculator
	public void provideCalculatorInstructions() {
		System.out.println("When using the cost calulator you will enter a price when prompted and hit the return key."
					   + "\nOnce you are finished just hit return again and you will be provided with the totals");
	}
	
	public boolean enterToContinue() {
		System.out.println("\n --Press Enter to continue--");
		try {
			System.in.read(); 
			return true;
		}
		catch (Exception e) {
			System.out.print("Error occurred");
			return false;
		}
	}
	

}
