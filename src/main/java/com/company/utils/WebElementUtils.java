package com.company.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebElementUtils {
    private static Logger log = LogManager.getLogger(WebElementUtils.class);
    public static boolean doesElementExist(WebElement element){

        boolean elementFound = false;
        try{
            element.getText();
            elementFound = true;
        }catch (NoSuchElementException | StaleElementReferenceException e){
            log.info("Not exist element -> " + element);
        }
        return elementFound;
    }

    public static boolean doesElementExist(By locator){
        List<WebElement> elements = Browser.driver.findElements(locator);
        return elements.size() > 0;
    }

    public static boolean doesElementExist(String xpath){
        By locator = By.xpath(xpath);
        return doesElementExist(locator);
    }

    public static boolean doesElementExist(By locator, int timeInMillis){

        int timeElapsedInMillis = 0;
        boolean elementFound = false;
        while(timeElapsedInMillis < timeInMillis){
            try{
                elementFound = doesElementExist(locator);
                break;
            }catch (NoSuchElementException e){
                WaitUtils.sleepMillis(250);
            }
            timeElapsedInMillis+=250;
        }

        return elementFound;
    }



}
