/*
 * Copyright (c) 2019 Nico Kuijpers
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is furnished
 * to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR I
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
 * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package ephemeris;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Ulilities concerning (Gregorian) Calendar.
 * @author Nico Kuijpers
 */
public class CalendarUtil {

    /**
     * Create Gregorian Calendar date/time with time zone UTC.
     *
     * @param dateTime [Calendar]
     * @return dateTime [GC]
     */
    public static GregorianCalendar createGregorianCalendar(Calendar dateTime) {
        GregorianCalendar calendar = new GregorianCalendar();

        // https://www.timeanddate.com/time/aboututc.html
        // Use Coordinated Universal Time (UTC) to avoid
        // sudden changes in ephemeris due to changes from
        // winter time to summer time and vice versa
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

        calendar.set(Calendar.ERA, dateTime.get(Calendar.ERA));
        calendar.set(Calendar.YEAR, dateTime.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, dateTime.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, dateTime.get(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, dateTime.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, dateTime.get(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, dateTime.get(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar;
    }

    /**
     * Convert date/time to string.
     *
     * @param dateTime
     * @return
     */
    public static String calendarToString(Calendar dateTime) {
        int year = dateTime.get(Calendar.YEAR);
        int month = dateTime.get(Calendar.MONTH) + 1;
        int dayOfMonth = dateTime.get(Calendar.DAY_OF_MONTH);
        int hourOfDay = dateTime.get(Calendar.HOUR_OF_DAY);
        int minute = dateTime.get(Calendar.MINUTE);
        StringBuilder result = new StringBuilder();
        result.append(year);
        result.append("-");
        result.append(String.format("%02d",month));
        result.append("-");
        result.append(String.format("%02d",dayOfMonth));
        result.append(" ");
        result.append(String.format("%02d",hourOfDay));
        result.append(":");
        result.append(String.format("%02d",minute));
        return result.toString();
    }
}
