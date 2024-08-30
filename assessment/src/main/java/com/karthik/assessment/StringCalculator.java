package com.karthik.assessment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
	
	private static final String DEFAULT_DELIMITER = ",";
    private static final String NEW_LINE = "\n";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String SPLIT_SEQUENCE = "\\]\\[";
    private static final String OR = "|";
    private static final int MAX_NUMBER = 1000;
	
	private int calledCount = 0;
	
	public int add(String numbers) {
		calledCount++;
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}
		String delimiter = buildDelimiterRegex(extractDelimiter(numbers));
		String nums = extractNumbers(numbers);
		List<Integer> parsedNumbers = parseNumbers(nums, delimiter);
		validate(parsedNumbers);
		return calculateSum(parsedNumbers);
	}

	private String extractDelimiter(String numbers) {
		if (!numbers.startsWith(CUSTOM_DELIMITER_PREFIX)) return DEFAULT_DELIMITER;
		int delimiterEndIndex = numbers.indexOf(NEW_LINE);
		String delimiter = numbers.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIndex);
		return convertToRegex(delimiter);
	}
	
	private String convertToRegex(String delimiter) {
		if (!delimiter.startsWith("[")) return delimiter;
		String[] delimiters = delimiter.substring(1, delimiter.length() - 1).split(SPLIT_SEQUENCE);
		return String.join(OR, delimiters);
	}
	
	private String buildDelimiterRegex(String delimiter) {
		StringBuilder regex = new StringBuilder();
		regex.append("[").append(DEFAULT_DELIMITER).append(NEW_LINE).append(delimiter).append("]");
		return regex.toString();
	}
	
	private String extractNumbers(String numbers) {
		if (!numbers.startsWith(CUSTOM_DELIMITER_PREFIX)) return numbers;
		int delimiterEndIndex = numbers.indexOf(NEW_LINE);
		return numbers.substring(delimiterEndIndex + 1);
	}
	
	private List<Integer> parseNumbers(String numbers, String delimiter) {
		return Arrays.stream(numbers.split(delimiter)).filter(num -> !num.isEmpty()).map(Integer :: parseInt).toList();
	}
	
	private void validate(List<Integer> numbers) {
		String negatives = numbers.stream().filter(number -> number < 0).map(String::valueOf).collect(Collectors.joining(","));
		if (negatives.length() > 0) {
			throw new RuntimeException("negatives not allowed: " + negatives);
		}
	}
	
	private int calculateSum(List<Integer> numbers) {
		return numbers.stream().filter(number -> number <= MAX_NUMBER).mapToInt(Integer :: intValue).sum();
	}
	
	public int getCalledCount() {
		return calledCount;
	}
}
