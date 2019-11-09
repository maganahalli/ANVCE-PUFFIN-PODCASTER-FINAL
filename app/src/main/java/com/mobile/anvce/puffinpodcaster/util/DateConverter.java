package com.mobile.anvce.puffinpodcaster.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import android.text.TextUtils;

import androidx.room.TypeConverter;

public class DateConverter {

	private static Calendar getReleaseDateAsCalendar(String dateStr) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-mm", Locale.US);
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(Objects.requireNonNull(dateFormat.parse(dateStr)));
		} catch (ParseException e) {
			// do nothing
		}
		return calendar;
	}

	private static String getReleaseDateLongFormat(String dateStr) {
		if (TextUtils.isEmpty(dateStr)) {
			return "Data not available";
		}
		Calendar calendar = getReleaseDateAsCalendar(dateStr);
		SimpleDateFormat format = new SimpleDateFormat("MMMM D, yyyy", Locale.US);
		return format.format(calendar.getTime());
	}

	private static String getReleaseDateLongFormat(Long dateInSec) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(dateInSec);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
		return format.format(calendar.getTime());
	}

	@TypeConverter
	public static Date toDate(String dateStr) {
		return dateStr == null ? null : getReleaseDateAsCalendar(dateStr).getTime();
	}

	@TypeConverter
	public static String toDate(Date date) {
		return getReleaseDateLongFormat(String.valueOf(date.getTime()));
	}

	public static String toDate(Long dateInSec) {
		return getReleaseDateLongFormat(dateInSec);
	}
}
