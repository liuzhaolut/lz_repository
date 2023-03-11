package com.etc.plant.util;


import org.apache.log4j.Logger;

/**
 * 异常信息
 * @author lz
 */
public class Log {
    public static Logger mylog;
    static {
        mylog = Logger.getLogger(Log.class);
    }
}
