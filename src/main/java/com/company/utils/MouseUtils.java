package com.company.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseUtils {
    private static Logger log = LogManager.getLogger(MouseUtils.class);

    public static void hoverAndClick(WebElement elementToHover, WebElement elementToClick){
        Actions action = new Actions(Browser.driver);
        action.moveToElement(elementToHover).click(elementToClick).build().perform();
    }

    public static void hover(WebElement elementToHover){
        Actions action = new Actions(Browser.driver);
        action.moveToElement(elementToHover).build().perform();
    }

    public static void hoverAndSafeClick(WebElement elementToHover, WebElement elementToClick){
        Actions action = new Actions(Browser.driver);
        action.moveToElement(elementToHover).build().perform();
        WaitUtils.waitForElementVisible(elementToClick);
        WaitUtils.waitForElementToBeClickable(elementToClick,5);
        action.click(elementToClick).build().perform();
    }

    public static void rightClickThenClick(WebElement rightClickTo, WebElement clickTo){
        Actions action = new Actions(Browser.driver);
        action.contextClick(rightClickTo).build().perform();
        WaitUtils.waitForElementVisible(clickTo);
        WaitUtils.waitForElementToBeClickable(clickTo,5);
        WebElementUtils.jexClick(clickTo);
    }

    public static void rightClickThenClick(WebElement rightClickTo, String clickTo){
        String clickToXpath = "//span[text()='" + clickTo + "']";
        Actions action = new Actions(Browser.driver);
        action.contextClick(rightClickTo).build().perform();
        WaitUtils.waitForElementVisibleLocated(By.xpath(clickToXpath));
        WebElement elementClickTo = Browser.driver.findElement(By.xpath(clickToXpath));
        WaitUtils.waitForElementToBeClickable(elementClickTo,5);
        WebElementUtils.jexClick(elementClickTo);
    }

    public static void doubleClick(WebElement element){
        Actions action = new Actions(Browser.driver);
        action.moveToElement(element).doubleClick().build().perform();
    }

    public static void navigateToFromTab(By fromTab, By to){
        int count = 0;
//        boolean found = false;
        while(count<7){
            try {
                WaitUtils.waitForElementVisibleLocated(fromTab);
                hover(WebElementUtils.webElementFromLocator(fromTab));
                WaitUtils.waitForElementVisibleLocated(to);
                WebElementUtils.webElementFromLocator(to).click();
                return;
            }catch (Exception e){
                log.warn(e.getClass() + " Exception caught!!! Refresh and try again!!!");
                Browser.refreshPage();
                count++;
            }
        }
        throw new RuntimeException("Couldnt navigate to " + to + " from "+ fromTab);
    }

    public static void navigateToFromTab(String xpathFromTab, String xpathTo){
        navigateToFromTab(By.xpath(xpathFromTab),By.xpath(xpathTo));
    }


}
