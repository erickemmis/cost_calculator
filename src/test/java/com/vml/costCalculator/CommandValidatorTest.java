package com.vml.costCalculator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommandValidatorTest {

	@Test
	public void isValidYesNoResponseTest_nullString_shouldReturnFalse() {
		boolean isValid = CommandValidator.isValidYesNoResponse(null);
		
		assertFalse(isValid);
	}
	
	@Test
	public void isValidYesNoResponseTest_emptyString_shouldReturnFalse() {
		boolean isValid = CommandValidator.isValidYesNoResponse(null);
		
		assertFalse(isValid);
	}
	
	@Test
	public void isValidYesNoResponseTest_yesWithLeadingAndTrailingSpaces_shouldReturnTrue() {
		boolean isValid = CommandValidator.isValidYesNoResponse("   yes   ");
		
		assertTrue(isValid);
	}
	
	@Test
	public void isValidYesNoResponseTest_yesInAnyCasing_shouldReturnTrue() {
		boolean isValid = CommandValidator.isValidYesNoResponse("yEs");
		
		assertTrue(isValid);
	}
	
	@Test
	public void isValidYesNoResponseTest_noWithLeadingAndTrailingSpaces_shouldReturnTrue() {
		boolean isValid = CommandValidator.isValidYesNoResponse("   no   ");
		
		assertTrue(isValid);
	}
	
	@Test
	public void isValidYesNoResponseTest_noInAnyCasing_shouldReturnTrue() {
		boolean isValid = CommandValidator.isValidYesNoResponse("No");
		
		assertTrue(isValid);
	}
	
	@Test
	public void isValidYesNoResponseTest_notYesOrNow_shouldReturnFalse() {
		boolean isValid = CommandValidator.isValidYesNoResponse("Nope");
		
		assertFalse(isValid);
	}


}
