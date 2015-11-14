package com.birght.comm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalTest {

	/**
	 * @param args
	 * @throws ParseException
	 */

	public static void main(String[] args) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM");
		Date start = format.parse("2010-01");
		Date end = format.parse("2011-06");
		Calendar calendar = Calendar.getInstance();
		long start_time = start.getTime();
		long end_time = end.getTime();

		long ret = end_time - start_time;

		
		int l = (int) (ret / ( 60 * 60 * 1000 * 30));
		
        l = l/24;
		System.out.println("ret --->" + l);
	}

}
