package com.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {

	private SimpleDateFormat formatter;
	private String datePattern;
	
	public DateFormatter(String datePattern) {
		this.datePattern = datePattern;
		formatter = new SimpleDateFormat(datePattern);
	}
	
	@Override
	public String print(Date date, Locale locale) {
		return formatter.format(date);
	}

	@Override
	public Date parse(String s, Locale locale) throws ParseException {
		try {
			return formatter.parse(s);
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException(
					"Invalid date format, Please use this pattern\""
					+ datePattern + "\"");
		}
	}
	
}
