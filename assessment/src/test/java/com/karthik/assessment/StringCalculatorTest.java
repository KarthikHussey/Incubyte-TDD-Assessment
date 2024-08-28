package com.karthik.assessment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testEmptyString() {
		StringCalculator strCalci = new StringCalculator();
		assertEquals(0, strCalci.add(""));
	}
	
	@Test
	public void testSingleNumber() {
		StringCalculator strCalci = new StringCalculator();
		assertEquals(1, strCalci.add("1"));
	}
	
	@Test
	public void testTwoNumbers() {
		StringCalculator strCalci = new StringCalculator();
		assertEquals(3, strCalci.add("1,2"));
	}
}
