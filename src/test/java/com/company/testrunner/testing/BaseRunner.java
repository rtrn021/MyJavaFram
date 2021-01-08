package com.company.testrunner.testing;

import com.company.utils.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseRunner {
    private static Logger log = LogManager.getLogger(BaseRunner.class);

    @BeforeClass
    public static void setup(){
    log.info("BaseRunner start to run!!!");
    }

    /**
     * That method can be used to populate reports and to close driver.
     */
    @AfterClass
    public static void after(){
//        Browser.close();

    }
}
