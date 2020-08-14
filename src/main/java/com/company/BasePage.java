package com.company;

import com.company.pages.LoginPage;
import com.company.utils.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    private static Logger log = LogManager.getLogger(BasePage.class);

    protected static final String TEXT_VALUE_BEGIN = "";
    protected static final String TEXT_VALUE_END = "";

    public BasePage(){

        PageFactory.initElements(Browser.driver,this);
    }

    public abstract void getReady();


    public void storeDetails(){
        log.warn("*** This method should be overridden in your current page class ***" + this.getClass());
    }



}
