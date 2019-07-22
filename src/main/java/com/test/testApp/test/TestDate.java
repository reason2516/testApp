package com.test.testApp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class TestDate {
    public static void main(String[] args) {
//        Date date = new Date();
//        date.setTime(0);
//        long time = date.getTime();
//        System.out.println(date);
        test1970();
    }

    public static void test1970() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date d = null;
        try {
            d = sdf.parse("1970-01-01");
            System.out.println(d.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date = new Date(0L);
        String format = sdf.format(date);
        System.out.println(format);
    }
}
