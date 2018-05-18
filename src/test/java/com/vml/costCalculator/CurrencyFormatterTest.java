package com.vml.costCalculator;

import static org.junit.Assert.*;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class CurrencyFormatterTest {

	@Test
	public void formatDoubleToUSDTest_zero_shouldReturnFormattedStringWithTwoDecimals() {
		String expectedFormattedValue = "$0.00";
		String actualFormattedValue = CurrencyFormatter.formatDoubleToUSD(0);
		
		System.out.println(actualFormattedValue);
		
		assertTrue(StringUtils.equals(expectedFormattedValue, actualFormattedValue));
	}

}
