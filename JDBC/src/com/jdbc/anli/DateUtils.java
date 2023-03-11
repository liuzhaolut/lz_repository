package com.jdbc.anli;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具类
 */
public class DateUtils {
    private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy--MM-dd");
    /**
     * 1、字符串转换为util.date
     */
    public static Date strToUtil(String str){
        try {
            Date date = SIMPLE_DATE_FORMAT.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * util.date转换为sql.date
     * @param date
     * @return
     */
    public static java.sql.Date utilToSql(Date date){
        return new java.sql.Date(date.getTime());
    }

    /**
     * 3、util.date转换为字符串
     * @param date
     * @return
     */
    public static String utilToStr(Date date){
        return SIMPLE_DATE_FORMAT.format(date);
    }
}
