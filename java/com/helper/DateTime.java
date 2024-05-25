package com.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

	public static String getDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String dateTime = formatter.format(date);

		return dateTime;
	}

	
}
