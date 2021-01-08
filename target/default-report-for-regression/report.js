$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/ProA/Atest_1.feature");
formatter.feature({
  "name": "Just Testing",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Atest_1"
    }
  ]
});
formatter.scenario({
  "name": "TestScenario",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Atest_1"
    },
    {
      "name": "@Scenario_Atest_1"
    }
  ]
});
formatter.step({
  "name": "Go to url",
  "keyword": "Given "
});
formatter.match({
  "location": "com.company.stepdefinitions.ProA.ProASteps.go_to_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Complete the test",
  "keyword": "Then "
});
formatter.match({
  "location": "com.company.stepdefinitions.ProA.ProASteps.complete_the_test()"
});
formatter.result({
  "status": "passed"
});
});