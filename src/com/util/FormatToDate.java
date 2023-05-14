package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatToDate {
	public static java.sql.Date getDate(String birth) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d;
		try {
			if (!"".equals(birth)) {
				d = format.parse(birth);
				System.out.println(d);
				java.sql.Date sbirth = new java.sql.Date(d.getTime());
				return sbirth;
			}
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
