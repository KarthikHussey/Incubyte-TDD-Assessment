package com.karthik.assessment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
	
	@Test
	public void testMultipleNumbers() {
		StringCalculator strCalci = new StringCalculator();
		assertEquals(5, strCalci.add("1,1,1,1,1"));
		assertEquals(10, strCalci.add("1,2,3,4"));
	}
	
	@Test
	public void testNewLineDelimiter() {
		StringCalculator strCalci = new StringCalculator();
		assertEquals(6, strCalci.add("1\n2,3"));
	}
	
	@Test
	public void testCustomerDelimeter() {
		StringCalculator strCalci = new StringCalculator();
		assertEquals(3, strCalci.add("//;\n1;2"));
	}
	
	@Test
	public void testNegativeNumbers() {
		StringCalculator strCalci = new StringCalculator();
		RuntimeException exception = assertThrows(RuntimeException.class, () -> strCalci.add("1,-1,-2,3"));
		assertEquals("negatives not allowed: -1,-2", exception.getMessage());
	}
}
