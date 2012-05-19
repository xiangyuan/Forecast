package org.iblogger.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * 
 */
public final class DateFormatUtils {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 
	 * @param d
	 * @return
	 */
	public static final String formatDate(Date d) {
		return sdf.format(d);
	}
}
