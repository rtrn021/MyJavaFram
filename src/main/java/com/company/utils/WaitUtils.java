package com.company.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WaitUtils {
    private static Logger log = LogManager.getLogger(WaitUtils.class);

    /**
     * (Visibility means) The element is not only displayed
     * but also has a height and width that is greater than 0.
     * @param element
     */
    public static void waitForElementVisible(WebElement element){
        Browser.defaultDriverWait.until(visibilityOf(element));
    }

    public static void waitForElementInvisible(WebElement element){
        Browser.defaultDriverWait.until(invisibilityOf(element));
    }

    /**
     * (Visibility means) The element is not only displayed
     * but also has a height and width that is greater than 0.
     * @param locator
     */
    public static void waitForElementVisibleLocated(By locator){
        Browser.defaultDriverWait.until(visibilityOfElementLocated(locator));
    }

    /**
     * Does not neccessarily mean that element visible, means element present on the DOM of the page.
     * @param locator
     */
    public static void waitForElementPresentLocated(By locator){
        Browser.defaultDriverWait.until(presenceOfElementLocated(locator));
    }

    public static void waitForElementToBeClickable(WebElement element, int waitTimeInSeconds){
        Wait<WebDriver> localWait = new WebDriverWait(Browser.driver,waitTimeInSeconds,250);
        localWait.until(elementToBeClickable(element));
    }

    public static void waitForElementToBeClickableSafe(WebElement element, int waitTimeSeconds){
        waitForElementWithSleep(element,waitTimeSeconds);
        int count = 0;
        boolean clickable = false;
        while(!clickable){
            try{
                waitForElementToBeClickable(element,waitTimeSeconds);
                clickable = true;
            }catch (StaleElementReferenceException e){
                log.info("StaleElementReferenceException caught, will try again!");
                count++;
                if(count==16)
                    throw new RuntimeException("StaleElementReferenceException occurs while waiting for " +
                            "element to be clickable!!!");
                sleepMillis(250);
            }
        }
    }

    public static void waitForWebElementToBeClickable(By locator, int waitTimeSeconds){

        try{
            waitForElementVisibleLocated(locator);
            WebElement theElement = Browser.driver.findElement(locator);
            waitForElementToBeClickable(theElement,waitTimeSeconds);
        }catch (Exception e){
            log.warn(e.getClass() + " Exception caught!! Waiting for element to be clickable failed!! >> " + locator);
        }
    }

    public static void sleepMillis(long timeMillis){
        try {
            Thread.sleep(timeMillis);
        }catch(InterruptedException ie){
            log.warn("InterruptedException thrown during sleep",ie);
        }
    }

    public static void waitForElementWithSleep(WebElement element, int waitLimitSeconds){
        int seconds = 0;
        while(seconds < waitLimitSeconds){
            if(WebElementUtils.doesElementExist(element))
                return;
            sleepMillis(1000);
            seconds++;
        }
        throw new RuntimeException("Element -> " + element + " is still not exist after waiting " +
                waitLimitSeconds + " second(s)!!!");
    }

    public static void waitForElementInvisible(By locator){
        Browser.defaultDriverWait.until(invisibilityOfElementLocated(locator));
    }

    public static void waitForPageTitle(String title){
        Browser.defaultDriverWait.until(titleContains(title));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        try {
            WebDriverWait localWait = new WebDriverWait(Browser.driver, timeOutInSeconds);
            localWait.until(pageLoadCondition);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void waitForPageToLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        Browser.defaultDriverWait.until(pageLoadCondition);
    }


    public static void waitForTextToAppear(String textToAppear) throws Exception {

        if(WebElementUtils.doesElementExist(By.cssSelector("body"),2000))
            throw new Exception("Cannot find 'body' region on the page");
        boolean textFound = false;
        for(int count = 0; count < 10 ; count++){
            textFound = Browser.driver.findElement(By.cssSelector("body")).getText().contains(textToAppear);
            if(textFound)
                break;
            sleepMillis(300);
        }
        if(!textFound)
            throw new Exception("Couldnt found -> " + textToAppear + " on the page!!!");
    }

    public static void waitForElementToBeEnabled(WebElement element, int timeInMillis){
        int timeElapsedInMillis = 0;
        boolean elementFound = false;
        while(timeElapsedInMillis < timeInMillis){
            try{
                if(element.isEnabled())
                    break;
            }catch (NoSuchElementException e){
                log.warn(e.getClass()+" -> Exception caught!!!");
            }
            WaitUtils.sleepMillis(250);
            timeElapsedInMillis+=250;
        }

    }



}
