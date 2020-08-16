package com.company.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class WebElementUtils {
    private static Logger log = LogManager.getLogger(WebElementUtils.class);

    /**
     * That method can be used when normal click fails.
     * @param element
     */
    public static void jexClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)(Browser.driver);
        executor.executeScript("arguments[0].click();", element);
    }

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

    /**
     * Clicks and open the link in new tab
     * and Then Switch to the new tab.
     * @param link
     */
    public static void openLinkInNewTabAndSwitchToTab(WebElement link){
        WaitUtils.waitForElementVisible(link);
        WaitUtils.waitForElementToBeClickable(link,5);
        link.sendKeys(Keys.CONTROL + Keys.SHIFT.toString() + Keys.ENTER.toString());
        ArrayList<String> tabs = new ArrayList<String>(Browser.driver.getWindowHandles());
        Browser.driver.switchTo().window(tabs.get(tabs.size()-1));
    }



}
