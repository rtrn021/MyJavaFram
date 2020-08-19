package com.company.testrunner.testing;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com/company/stepdefinitions"},
        features = "src/test/resources/ProB",
        dryRun = false,
        strict = false,
//        to exclude smoke test scenarios
        tags = "not @smoke_test",
        plugin = {
                "html:target/default-report-for-regression",
                "json:target/cucumber_regression.json",
                "rerun:target/rerun_regression.txt"
        }

)
public class ProB_Runner {
}
