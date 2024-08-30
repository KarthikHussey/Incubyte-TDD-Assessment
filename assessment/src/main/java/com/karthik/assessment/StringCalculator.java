package com.karthik.assessment;

public class StringCalculator {
	
	private int calledCount = 0;
	
	public int add(String numbers) {
		calledCount++;
		if (numbers.isEmpty()) {
			return 0;
		}
		String delimiter = ",";
		if (numbers.startsWith("//")) {
			int delimiterEndIndex = numbers.indexOf("\n");
			String delimiterPart = numbers.substring(2, delimiterEndIndex);
			numbers = numbers.substring(delimiterEndIndex + 1);
			if (delimiterPart.startsWith("[")) {
				delimiterPart = delimiterPart.substring(1, delimiterPart.length() - 1);
				String[] delimiters = delimiterPart.split("\\]\\[");
				delimiter = String.join("|", delimiters);
			} else {
				delimiter = delimiterPart;
			}
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
			} else if (numToAdd <= 1000){
				sum += numToAdd;
			}
		}
		if (negatives.length() > 0) {
			negatives.deleteCharAt(negatives.length() - 1);
			throw new RuntimeException("negatives not allowed: " + negatives.toString());
		}
		return sum;
	}

	public int getCalledCount() {
		return calledCount;
	}
}
