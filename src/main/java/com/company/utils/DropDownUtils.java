package com.company.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtils {

    public static void selectValue(WebElement drowdown, String value){
        WaitUtils.waitForElementVisible(drowdown);
        Select select = new Select(drowdown);
        select.selectByVisibleText(value);
    }

    public static void selectByIndex(WebElement drowdown, int index){
        WaitUtils.waitForElementVisible(drowdown);
        Select select = new Select(drowdown);
        select.selectByIndex(index);
    }

}
