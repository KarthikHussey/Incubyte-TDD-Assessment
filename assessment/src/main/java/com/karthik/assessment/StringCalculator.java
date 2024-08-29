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
		StringBuilder negatives = new StringBuilder();
		String[] numsArr = numbers.split("[,\n" + delimiter + "]");
		for (String num : numsArr) {
			if (num.isEmpty()) {
				continue;
			}
			int numToAdd = Integer.parseInt(num);
			if (numToAdd < 0) {
				negatives.append(numToAdd);
				negatives.append(",");
			} else {
				sum += numToAdd;
			}
		}
		if (negatives.length() > 0) {
			negatives.deleteCharAt(negatives.length() - 1);
			throw new RuntimeException("negatives not allowed: " + negatives.toString());
		}
		return sum;
	}
}
