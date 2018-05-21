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
				"\nNet Total: " + CurrencyFormatter.formatDoubleToUSD(netTotal) + 
				"\nTax: " + CurrencyFormatter.formatDoubleToUSD(taxAmount) + 
				"\nTotal: " + CurrencyFormatter.formatDoubleToUSD(grandTotal)
			);		
		
	}
}
