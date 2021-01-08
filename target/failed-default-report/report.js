$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/ProA/Atest_2.feature");
formatter.feature({
  "name": "Just Testing exception",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Atest_2"
    }
  ]
});
formatter.scenario({
  "name": "TestScenario exception",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Atest_2"
    },
    {
      "name": "@Scenario_Atest_2"
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
  "name": "Fail with exception",
  "keyword": "Then "
});
formatter.match({
  "location": "com.company.stepdefinitions.ProA.ProASteps.fail_with_exception()"
});
formatter.result({
  "error_message": "java.lang.RuntimeException: Oh no RuntIme Exception here!!!\r\n\tat com.company.stepdefinitions.ProA.ProASteps.fail_with_exception(ProASteps.java:32)\r\n\tat ✽.Fail with exception(file:///C:/Users/Remzi/IdeaProjects/MyJavaFram/src/test/resources/ProA/Atest_2.feature:6)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Complete the test",
  "keyword": "Then "
});
formatter.match({
  "location": "com.company.stepdefinitions.ProA.ProASteps.complete_the_test()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("file:src/test/resources/ProA/Atest_3.feature");
formatter.feature({
  "name": "Just Testing assertion",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Atest_3"
    }
  ]
});
formatter.scenario({
  "name": "TestScenario assertion",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Atest_3"
    },
    {
      "name": "@Scenario_Atest_3"
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
  "name": "Fail with assertion",
  "keyword": "Then "
});
formatter.match({
  "location": "com.company.stepdefinitions.ProA.ProASteps.fail_with_assertion()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c0\u003e but was:\u003c1\u003e\r\n\tat org.junit.Assert.fail(Assert.java:89)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:835)\r\n\tat org.junit.Assert.assertEquals(Assert.java:647)\r\n\tat org.junit.Assert.assertEquals(Assert.java:633)\r\n\tat com.company.stepdefinitions.ProA.ProASteps.fail_with_assertion(ProASteps.java:37)\r\n\tat ✽.Fail with assertion(file:///C:/Users/Remzi/IdeaProjects/MyJavaFram/src/test/resources/ProA/Atest_3.feature:6)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Complete the test",
  "keyword": "Then "
});
formatter.match({
  "location": "com.company.stepdefinitions.ProA.ProASteps.complete_the_test()"
});
formatter.result({
  "status": "skipped"
});
});