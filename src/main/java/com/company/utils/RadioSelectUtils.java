package com.company.utils;

import org.openqa.selenium.WebElement;

public class RadioSelectUtils {

    public static void selectRadio(WebElement radio) {
        WaitUtils.waitForElementVisible(radio);
        WaitUtils.waitForElementToBeClickable(radio,5);
        radio.click();
    }

}
