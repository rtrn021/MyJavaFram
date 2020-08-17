package com.company.utils;

import org.openqa.selenium.WebElement;

public class TextBoxUtils {

    public static void enterTextIntoTextBoxTab(WebElement textBox, String text){
        WaitUtils.waitForElementVisible(textBox);
        WaitUtils.waitForElementToBeClickable(textBox,10);
        WebElementUtils.sendKeysSafe(textBox,text);
    }

    public static void enterTextIntoTextBoxNoTab(WebElement textBox, String text){
        WaitUtils.waitForElementVisible(textBox);
        WaitUtils.waitForElementToBeClickable(textBox,10);
        textBox.sendKeys(text);
    }

    public static void enterTextIntoTextBoxCharByChar(WebElement textBox,String text){
        WaitUtils.waitForElementVisible(textBox);
        WaitUtils.waitForElementToBeClickable(textBox,10);
        for( int i = 0; i< text.length(); i++){
            WaitUtils.sleepMillis(100);
            textBox.sendKeys(Character.toString(text.charAt(i)));
        }
    }
}
