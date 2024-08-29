package com.karthik.assessment;

public class StringCalculator {
	public int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		String delimiter = ",";
		if (numbers.startsWith("//")) {
			int delimiterEndIndex = numbers.indexOf("\n");
			delimiter = numbers.substring(2, delimiterEndIndex);
			numbers = numbers.substring(delimiterEndIndex + 1);
		}
		int sum = 0;
		String[] numsArr = numbers.split("[,\n" + delimiter + "]");
		for (String num : numsArr) {
			if (!num.isEmpty()) {
				sum += Integer.parseInt(num);
			}
		}
		return sum;
	}
}
