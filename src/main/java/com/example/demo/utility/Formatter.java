package com.example.demo.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formatter {

	public static String yearMonthFormat(String dateStr, String sourcePattern, String targetPattern) {
		if (dateStr == null) {
			return null;
		}

		LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(sourcePattern));

		String yearMonth = date.format(DateTimeFormatter.ofPattern(targetPattern));

		return yearMonth;
	}

}