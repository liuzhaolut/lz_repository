package com.dy.util;


import org.apache.log4j.Logger;

/**
 * @author DELL
 */
public class Log {
    public static Logger mylog;
    static {
        mylog = Logger.getLogger(Log.class);
    }
}
