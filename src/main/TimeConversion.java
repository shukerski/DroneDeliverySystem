package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class TimeConversion {
	private static DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private static long unixtime;

	public static long timeConversion(String time) {
		dfm.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
		try {
			unixtime = dfm.parse(time).getTime();
			unixtime = unixtime / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return unixtime;
	}

}
