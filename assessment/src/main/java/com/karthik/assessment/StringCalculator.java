package com.karthik.assessment;

public class StringCalculator {

	public int add(String numbers) {
		int sum = 0;
		if (!numbers.isEmpty()) {
			String[] numsArr = numbers.split(",");
			for (String num : numsArr) {
				sum += Integer.parseInt(num);
			}
		}
		return sum;
	}
	
}
