package com.company.utils;

import jdk.internal.vm.compiler.collections.EconomicMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class CheckBoxUtils {
    private static Logger log = LogManager.getLogger(CheckBoxUtils.class);
    private static final int TIME_IN_SECONDS = 2;

    /**
     * Ensure that the given checkbox is checked regardsless of its inital state.
     */
    public static void setCheckBox(WebElement checkBox) {
        WaitUtils.waitForElementToBeClickable(checkBox,TIME_IN_SECONDS);
        if( !checkBox.isSelected() ) {
            try{
                checkBox.click();
            }catch (Exception e){
                log.info("Issue clicking checkBox - retrying using Javascript click " + e);
                WebElementUtils.jexClick(checkBox);
            }
        }
    }

    public static void clearCheckBox(WebElement checkBox) {
        WaitUtils.waitForElementToBeClickable(checkBox,TIME_IN_SECONDS);
        if( checkBox.isSelected() ) {
            try{
                checkBox.click();
            }catch (Exception e){
                log.info("Issue clicking checkBox - retrying using Javascript click " + e);
                WebElementUtils.jexClick(checkBox);
            }
        }
    }

    public static void toggleCheckBox(WebElement checkBox) {
        WaitUtils.waitForElementToBeClickable(checkBox,TIME_IN_SECONDS);
        if( checkBox.isSelected() ) {
            try{
                checkBox.click();
            }catch (Exception e){
                log.info("Issue clicking checkBox - retrying using Javascript click " + e);
                WebElementUtils.jexClick(checkBox);
            }
        }
    }



}
