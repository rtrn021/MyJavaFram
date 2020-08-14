package com.company.utils.configuration;

import com.company.utils.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class TestConfiguration {
    private static Logger log = LogManager.getLogger(TestConfiguration.class);
    /**
     * The Current project directory
     */
    public static final String USER_DIR = System.getProperty("user.dir");

    public static final String USER_NAME = System.getProperty("user.name");

    public static String SCENARIO_DATA_STORE_DIRECTORY;

    public static void initialise(boolean initialiseBrowser) {
        try{
            PropertiesHolder.populateConfigurationProperties();
        }catch (IOException e){
            log.error("Issue populating properties"+e);
            throw new Error("Suite abandoned as properties could not be loaded."+e);
        }
        String environment = PropertiesHolder.environmentProperties.getProperty("environment");
        SCENARIO_DATA_STORE_DIRECTORY = USER_DIR +   File.separator + "serialised" + File.separator + environment;

        File directory = new File(SCENARIO_DATA_STORE_DIRECTORY);

        if(!directory.exists())
            directory.mkdirs();

        if(initialiseBrowser)
            Browser.initialise();
    }

}
