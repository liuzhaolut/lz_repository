package com.person.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 刘昭
 * 考工具类 - 日期格式
 * @date 2022/6/25
 */
public class DateUtils {
    /**
     * 日期格式
     */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 字符串转换为util类型
     * @param string
     * @return
     */
    public static Date strToUtil(String string){
        try {
            Date date = simpleDateFormat.parse(string);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * util转换为
     * @param date
     * @return
     */
    public static java.sql.Date utilToSql(Date date){
        return new java.sql.Date(date.getTime());
    }

    /**
     * util转换为string
     * @param date
     * @return
     */
    public static String utilToStr(Date date){
        return simpleDateFormat.format(date);
    }
}
