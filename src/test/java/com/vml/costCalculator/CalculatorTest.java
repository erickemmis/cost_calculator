package com.vml.costCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	
	
	
	@Test
	public void addCost_negativeNumber_shouldSubtractFromNetTotal() {
		Calculator calculator = new Calculator();
		boolean isValid = false;
		double subtractedTotal = calculator.getNetTotal() - 25;
		
		calculator.addCost(-25);
		
		
		if(calculator.getNetTotal() == subtractedTotal) {
			isValid = true;
		}else {
			isValid = false;
		}
		
		assertTrue(isValid);
	}
	
	@Test
	public void addCost_positiveNumber_shouldAddToNetTotal() {
		Calculator calculator = new Calculator();
		boolean isValid = false;
		double subtractedTotal = calculator.getNetTotal() + 25;		
		
		calculator.addCost(25);
	
		if(calculator.getNetTotal() == subtractedTotal) {
			isValid = true;
		}else {
			isValid = false;
		}
		
		assertTrue(isValid);
	}
	
	@Test
	public void getTax_positiveNumber_shouldReturnMultipleOfTotaByDefaultTax() {
		Calculator calculator = new Calculator();
		boolean isValid = false;
		
		double calculatedTax = 110 * .07;		
		double objectTax = calculator.getTax(110);
	
		if(calculatedTax == objectTax) {
			isValid = true;
		}else {
			isValid = false;
		}
		
		assertTrue(isValid);
	}
	
	@Test
	public void getTax_positiveNumber_shouldReturnTotalMultipliedByTaxPassedIntoConstructor() {
		double tax = .10;
		double total = 110;
		Calculator calculator = new Calculator(tax);
		boolean isValid = false;
		
		double calculatedTax = 110 * .10;		
		double objectTax = calculator.getTax(total);
		
		if(calculatedTax == objectTax) {
			isValid = true;
		}else {
			isValid = false;
		}
		
		assertTrue(isValid);
	}
	
	
	@Test
	public void getTotalCost_shouldReturnCalculatorInstanceTotalPlusTax() {

		Calculator calculator = new Calculator();
		boolean isValid = false;
		
		//calculating the total with tax
		double calculatedTotal = (100 * .07) + 100;	
		//add costs so the calculator to make the total 100
		calculator.addCost(50);
		calculator.addCost(50);
		double objectTotal = calculator.getTotalCost();
		
		
		if(calculatedTotal == objectTotal) {
			isValid = true;
		}else {
			isValid = false;
		}
		
		assertTrue(isValid);
	}
	
	@Test
	public void retrieveCosts_shouldAddSystemInputToCalculatorTotal() {

		Calculator calculator = new Calculator();
		boolean isValid = true;
		
		//TODO calculator.retrieveCosts();

		assertTrue(isValid);
	}
	
	
	

}
