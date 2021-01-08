package com.company.pages;

import com.company.BasePage;
import com.company.utils.Browser;
import com.company.utils.configuration.PropertiesHolder;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

@Data
public class LoginPage extends BasePage {

    private static Logger log = LogManager.getLogger(LoginPage.class);

    private String environment;
    private String user;




    public void goTo(){

        Properties selectedEnvironmentProperties = PropertiesHolder.environmentProperties;
        if(selectedEnvironmentProperties==null)
            throw new RuntimeException("Environment Properties not found!");

        environment = System.getProperty("env") != null ? System.getProperty("env") :
                selectedEnvironmentProperties.getProperty("environment");

        log.info("Environment: " + environment);

        if(environment==null)
            throw new RuntimeException("Environment is not specified");

        String url = selectedEnvironmentProperties.getProperty("url");
        log.info("Login to url: " + url);

        if(url==null)
            throw new RuntimeException("Url is not specified in " + environment + "_properties file");
        Browser.goTo(url);

    }

    public void getReady(){

    }


}
