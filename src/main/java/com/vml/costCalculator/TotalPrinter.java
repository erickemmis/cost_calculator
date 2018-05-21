package com.vml.costCalculator;

public class TotalPrinter {
	
	private Calculator calculator;
	
	TotalPrinter(Calculator calculator) {
		//constructor accepts calculator 
		this.calculator = calculator;
	}
	
	public void printNetTotalTaxAndTotal() {
		
		// retrieve totals from calculator
		double netTotal = calculator.getNetTotal();
		double taxAmount = calculator.getTax(netTotal);
		double grandTotal = calculator.getTotalCost()
;
		System.out.println(
				"Sub-total is: " + CurrencyFormatter.formatDoubleToUSD(netTotal) + 
				"/n Tax is: " + CurrencyFormatter.formatDoubleToUSD(taxAmount) + 
				"/n Total is: " + CurrencyFormatter.formatDoubleToUSD(grandTotal)
			);		
		
	}
}
