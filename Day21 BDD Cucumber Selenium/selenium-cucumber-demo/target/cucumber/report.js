$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('com\sapient\selenium_cucumber_demo\datatable\dataTable.feature');
formatter.feature({
  "line": 1,
  "name": "Data table",
  "description": "Verify that the new user registration is successful after passing correct inputs.",
  "id": "data-table",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "",
  "description": "",
  "id": "data-table;",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the user on the user registration page.",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user enter valid data on the page",
  "rows": [
    {
      "cells": [
        "Fields",
        "Values"
      ],
      "line": 6
    },
    {
      "cells": [
        "FirstName",
        "Siva"
      ],
      "line": 7
    },
    {
      "cells": [
        "LastName",
        "OS"
      ],
      "line": 8
    },
    {
      "cells": [
        "Email",
        "syskantechnosoft@gmail.com"
      ],
      "line": 9
    },
    {
      "cells": [
        "Company",
        "syskantechnosoft"
      ],
      "line": 10
    },
    {
      "cells": [
        "Functional Role",
        "IT"
      ],
      "line": 11
    },
    {
      "cells": [
        "Job Level",
        "Faculty"
      ],
      "line": 12
    },
    {
      "cells": [
        "Company Size",
        "0-350"
      ],
      "line": 13
    },
    {
      "cells": [
        "Country",
        "India"
      ],
      "line": 14
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "the user registration should be successful.",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.the_user_on_the_user_registration_page()"
});
formatter.result({
  "duration": 5024573100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_enter_valid_data_on_the_page(DataTable)"
});
formatter.result({
  "duration": 45618000,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"id\",\"selector\":\"FirstName\"}\n  (Session info: chrome\u003d119.0.6045.107)\n  (Driver info: chromedriver\u003d119.0.6045.105 (38c72552c5e15ba9b3117c0967a0fd105072d7c6-refs/branch-heads/6045@{#1103}),platform\u003dWindows NT 10.0.22621 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 36 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.47.1\u0027, revision: \u0027unknown\u0027, time: \u00272015-07-30 11:02:44\u0027\nSystem info: host: \u0027Siva-HPi5\u0027, ip: \u002710.150.176.172\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_281\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, timeouts\u003d{implicit\u003d0, pageLoad\u003d300000, script\u003d30000}, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:49795}, webauthn:extension:credBlob\u003dtrue, acceptInsecureCerts\u003dfalse, fedcm:accounts\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, webauthn:extension:largeBlob\u003dtrue, unexpectedAlertBehaviour\u003dignore, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d119.0.6045.105 (38c72552c5e15ba9b3117c0967a0fd105072d7c6-refs/branch-heads/6045@{#1103}), userDataDir\u003dC:\\Users\\Siva\\AppData\\Local\\Temp\\scoped_dir22316_834811630}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, strictFileInteractability\u003dfalse, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d119.0.6045.107, browserConnectionEnabled\u003dfalse, proxy\u003d{}, nativeEvents\u003dtrue, webauthn:extension:minPinLength\u003dtrue, webauthn:extension:prf\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue, webauthn:virtualAuthenticators\u003dtrue}]\nSession ID: f54b358295315d104cda81ac00193fc4\n*** Element info: {Using\u003did, value\u003dFirstName}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:595)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:348)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:389)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:215)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:340)\r\n\tat com.sapient.selenium_cucumber_demo.datatable.StepDefinition.user_enter_valid_data_on_the_page(StepDefinition.java:35)\r\n\tat ✽.When user enter valid data on the page(com\\sapient\\selenium_cucumber_demo\\datatable\\dataTable.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "StepDefinition.the_user_registration_should_be_successful()"
});
formatter.result({
  "status": "skipped"
});
});