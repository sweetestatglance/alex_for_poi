package com.alex.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlexExcelUtils {

    public static String getTableName(Date date) {
        String tableName = "ST_AllDetails_Factor";
        if (date != null) {
            tableName = tableName + "_" + dateToString(date, "yyyyMM");
        }

        return tableName;
    }

    public static String dateToString(Date date, String pattern) {
        String dateStr = null;

        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            dateStr = df.format(date);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return dateStr;
    }

    public static String getyearandmonth(){
        Integer y = getyear();
        Integer m = getmonth();
        return y + "年" + m + "月";
    }

    public static Integer getyear(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    public static Integer getmonth(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    public static Integer getday(){
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        return day;
    }

    public static Integer monthhaveday(int year,int month){
        Calendar c = Calendar.getInstance();
        c.set(year,month,0);
        Integer havedays = c.get(Calendar.DAY_OF_MONTH);
        return havedays;
    }

    public static void main(String[] args) {
        Integer m = monthhaveday(2019, 2);
        System.out.println(m);
    }

}
