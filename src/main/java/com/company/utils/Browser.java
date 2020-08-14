package com.company.utils;

import com.company.utils.configuration.PropertiesHolder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 */
public class Browser {
    public static WebDriver driver;
    public static WebDriverWait driverWait20Sec;

    public static WebDriverWait defaultDriverWait;
//    private static final long DEFAULT_WAIT_TIMEOUT_SEC = 60;
//    private static final long DEFAULT_SLEEP_TIMEOUT_MILLIS = 200;

    public static WebDriverWait longDriverWait;
//    private static final long LONG_WAIT_TIMEOUT_SEC = 120;
//    private static final long LONG_SLEEP_TIMEOUT_MILLIS = 200;

    public static WebDriverWait shortDriverWait;
//    private static final long SHORT_WAIT_TIMEOUT_SEC = 10;
//    private static final long SHORT_SLEEP_TIMEOUT_MILLIS = 200;

    private static Logger log = LogManager.getLogger(Browser.class);

    public static void initialise() {
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") :
                PropertiesHolder.configurationProperties.getProperty("browser");
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disabele-infobars","--start-maximized","--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptionsHeadless = new ChromeOptions();
                chromeOptionsHeadless.addArguments("--disabele-infobars","--start-maximized","--disable-gpu", "headless");
                driver = new ChromeDriver(chromeOptionsHeadless);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                throw new Error("Driver Type Not implemented.");
        }
//        defaultDriverWait = new WebDriverWait(driver, DEFAULT_WAIT_TIMEOUT_SEC, DEFAULT_SLEEP_TIMEOUT_MILLIS);
//        longDriverWait = new WebDriverWait(driver, LONG_WAIT_TIMEOUT_SEC, LONG_SLEEP_TIMEOUT_MILLIS);
//        shortDriverWait = new WebDriverWait(driver, SHORT_WAIT_TIMEOUT_SEC, SHORT_SLEEP_TIMEOUT_MILLIS);

        defaultDriverWait = new WebDriverWait(driver, 60, 200);
        longDriverWait = new WebDriverWait(driver, 120, 200);
        shortDriverWait = new WebDriverWait(driver, 10, 200);
        driverWait20Sec = new WebDriverWait(driver, 20, 200);

    }

    public static void goTo(String url){
        driver.get(url);
    }

    public static String getTitle() {
        return driver.getTitle();
    }

    public static String getUrl(){
        return driver.getCurrentUrl();
    }

    


}
