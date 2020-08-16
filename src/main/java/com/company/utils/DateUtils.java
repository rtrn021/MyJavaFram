package com.company.utils;

import jdk.vm.ci.meta.Local;
import net.bytebuddy.asm.Advice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateUtils {

    public static String adjustDateByYear(String initialDate, int yearsToBeAdded, String dateFormat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat((dateFormat));
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(initialDate));
        c.add(Calendar.YEAR,yearsToBeAdded);
        String newDate = sdf.format(c.getTime());
        return newDate;
    }

    public static LocalDate addDaysToToday(int daysToBeAdded ){
        return LocalDate.now().plusDays(daysToBeAdded);
    }

    public static String formatLocalDate(LocalDate date, String formatPattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
        return date.format(formatter);
    }

    public static LocalDate parseDateFromString(String dateString, String formatPattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
        return LocalDate.parse(dateString, formatter);
    }

    public static String formatLocalDateTime(LocalDateTime dateTime, String formatPattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
        return dateTime.format(formatter);
    }

    public static LocalDateTime parseDateTimeFromString(String dateTimeString, String formatPattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
        return  LocalDateTime.parse(dateTimeString, formatter);
    }

    public static String reformatDate(String dateString, String fromPattern, String toPattern){
        return formatLocalDate(parseDateFromString(dateString,fromPattern),toPattern);
    }

    public static LocalDate getNextDateWithSpecificDay(LocalDate beginDate, int nextDayOfMonth) {
        LocalDate nextDate = beginDate.withDayOfMonth(nextDayOfMonth);
        if ( nextDate.isAfter(beginDate))
            return nextDate;
        return nextDate.plusDays(1);
    }

    public static String uniqueStringNumberFromDate(String formatPattern){
        return LocalDateTime.now().format( DateTimeFormatter.ofPattern(formatPattern) );
    }

    public static Long uniqueLongNumberFromDate(String formatPattern){
        return Long.parseLong(
                LocalDateTime.now().format( DateTimeFormatter.ofPattern(formatPattern) ) );
    }


}
