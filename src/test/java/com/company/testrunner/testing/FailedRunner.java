package com.company.testrunner.testing;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com/company/stepdefinitions"},
        features = "@target/rerun.txt",
        plugin = {
                "html:target/failed-default-report",
                "json:target/failed_report.json",
        }

)
public class FailedRunner {
}

