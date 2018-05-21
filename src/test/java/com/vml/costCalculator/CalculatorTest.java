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
	public void addCost_positiveNumber_shouldSubtractFromNetTotal() {
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

}
