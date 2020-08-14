package com.company;

import com.company.pages.LoginPage;
import com.company.utils.Browser;

public class Pages {

    public static LoginPage loginPage;

    public static void initialise() {

        if(Browser.driver==null)
            return;

        loginPage = new LoginPage();

    }
}
