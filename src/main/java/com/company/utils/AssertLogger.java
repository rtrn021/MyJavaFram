package com.company.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AssertLogger {
    private static Logger log = LogManager.getLogger(AssertLogger.class);

    public static final boolean RETHROW = true;

//    public static void assertEquals(String message, Object expected, Object actual){
//        try{
//            //        org.junit.assertEquals(message,expected,actual);
//            log.info(message + " ...passed! Value = " + expected);
//        }catch(Throwable t){
//            logThrowable()
//        }
//
//    }

}
