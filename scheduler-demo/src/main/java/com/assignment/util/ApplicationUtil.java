package com.assignment.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public interface ApplicationUtil {

	static Date daysAgo(int days) {
	    GregorianCalendar gc = new GregorianCalendar();
	    gc.add(Calendar.DATE, -days);
	    return gc.getTime();
	}
}
