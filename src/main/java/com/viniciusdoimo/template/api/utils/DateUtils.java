/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viniciusdoimo.template.api.utils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * Vinicius Doimo
 * E-mail: vinicius.rodrigues.doimo@gmail.com
 *
 */
public class DateUtils implements Serializable {

    public static final String FORMAT_YEAR_AND_MONTH = "yyyyMM";
    public static final String FORMAT_DATE = "dd/MM/yyyy";
    public static final String FORMAT_DATE_AND_TIME = "dd/MM/yyyy HH:mm";
    public static final String FORMAT_MONTH_AND_YEAR = "MM/yyyy";

    public static String formatDate(String pattern, Date data) {
        return data == null ? "" : dateForLocalDate((data)).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatDateToString(String pattern, Date data) {
        if (data != null) {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.format(data);
        } else {
            return "";
        }
    }

    public static LocalDate dateForLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date stringToDate(String pattern, String stringData) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(stringData);
        return date;
    }

    public static Integer getYear(Date data) {
        LocalDate dataLocalDate = dateForLocalDate(data);
        return dataLocalDate.getYear();
    }

    public static Integer getMonth(Date data) {
        LocalDate dataLocalDate = dateForLocalDate(data);
        return dataLocalDate.getMonthValue();
    }

    public static Long differenceBetweenDays(Date startDate, Date endDate) {
        if (Objects.isNull(endDate)) {
            LocalDate day = LocalDate.now();
            LocalDate anotherDay = dateForLocalDate(startDate);
            return anotherDay.until(day, ChronoUnit.DAYS);
        }

        LocalDate startLocalDate = dateForLocalDate(startDate);
        LocalDate endLocalDate = dateForLocalDate(endDate);
        return startLocalDate.until(endLocalDate, ChronoUnit.DAYS);
    }

    public static boolean isBusinessDay(Date data){
        GregorianCalendar dataGregorian = new GregorianCalendar();
        dataGregorian.setTime(data);
        Calendar calendar = dataGregorian;
        int Weekday = calendar.get(Calendar.DAY_OF_WEEK);

        if (Weekday != Calendar.SUNDAY && Weekday != Calendar.SATURDAY) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static Date addDaysOnDate(Date date, Integer numberOfDays){
        if(date != null) {
            Calendar calendar = Calendar. getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, numberOfDays);
            Date newDate = calendar.getTime();
            return newDate;
        }
        return null;
    }

    public static Date addDaysOnDate(String dateString, Integer numberOfDays) {
        return addDaysOnDate(dateString, numberOfDays);
    }

    public static Date subtractDaysOnDate(Date date, Integer numberOfDays) {
        return addDaysOnDate(date, Math.multiplyExact(numberOfDays,-1));
    }

    public static Date subtractDaysOnDate(String dataString, Integer numberOfDays) {
        return addDaysOnDate(dataString, Math.multiplyExact(numberOfDays,-1));
    }

    /**
     * checks whether the 'startDate' is greater than or equal to the 'endDate'
     * @return Boolean
     */
    public static boolean IsDateLargerOrEqual(Date startDate, Date endDate){
        return startDate.compareTo(endDate) >= 0;
    }

    /**
     * Compare if 'compareData' is between 'startDate' and 'endDate'
     * @return Boolean
     */
    public static boolean dateIsBetweenPeriods(Date startDate , Date endDate, Date comparisonData){
        return IsDateLargerOrEqual(comparisonData, startDate) &&
                IsDateLargerOrEqual(endDate, comparisonData);
    }

    public static Date changeTimeDate(Date date,int hours, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }
}
