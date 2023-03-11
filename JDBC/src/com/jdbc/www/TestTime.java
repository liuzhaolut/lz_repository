package com.jdbc.www;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据库时间与Java时间
 */
public class TestTime {
    public static void main(String[] args) throws ParseException {
        System.out.println(new Date());

//        字符串与util.date转换
        Date date = new Date();
        String time = "1999-09-24";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = dateFormat.parse(time);
        System.out.println(date);
        String dates = dateFormat.format(date);
        System.out.println("转换后：" + dates);
//        sql.date只支持毫秒值---字符串转换为util再转换为sql
        System.out.println(new java.sql.Date(date.getTime()));

    }
}
