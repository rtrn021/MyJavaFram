package com.company.stepdefinitions.ProA;

import com.company.Pages;
import com.company.utils.Browser;
import com.company.utils.configuration.PropertiesHolder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ProASteps {

    @Given("Go to url")
    public void go_to_url() {
        System.out.println("Go to Url Step");
////        PropertiesHolder.populateConfigurationProperties();
////        PropertiesHolder.populateEnvironmentProperties();
//        Browser.initialise();
//        Pages.initialise();
//        Pages.loginPage.goTo();
//        Browser.driver.navigate().to("https://en.wikipedia.org/");
    }

    @Then("Complete the test")
    public void complete_the_test() {
        System.out.println("Complete the test");
    }

    @Then("Fail with exception")
    public void fail_with_exception() {
        throw new RuntimeException("Oh no RuntIme Exception here!!!");
    }

    @Then("Fail with assertion")
    public void fail_with_assertion() {
        Assert.assertEquals(0,1);
    }
}
