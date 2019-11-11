$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("hompage.feature");
formatter.feature({
  "line": 1,
  "name": "Homepage search filters",
  "description": "\n As an user \n I should be able to search for properties in the Homepage with advanced filters \n So that I can find a properties easily \n\nBackground\n  Given I am already in Homepage",
  "id": "homepage-search-filters",
  "keyword": "Feature"
});
formatter.before({
  "duration": 101852700,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Basic channels in the Homepage",
  "description": "",
  "id": "homepage-search-filters;basic-channels-in-the-homepage",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@solo"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "I see search text field on the homepage",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I enter science museum london imax price tickets in the search field",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I hit the search button",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Url should contain science",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageStepDef.i_see_for_sale_channel_tab_on_the_homepage()"
});
formatter.result({
  "duration": 241540300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "science museum london imax price tickets",
      "offset": 8
    }
  ],
  "location": "HomePageStepDef.i_enter_value_in_the_search_field(String)"
});
formatter.result({
  "duration": 261734600,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepDef.i_hit_the_search_button()"
});
formatter.result({
  "duration": 70084893800,
  "error_message": "org.openqa.selenium.ElementNotVisibleException: element not interactable\n  (Session info: chrome\u003d76.0.3809.100)\n  (Driver info: chromedriver\u003d76.0.3809.68 (420c9498db8ce8fcd190a954d51297672c1515d5-refs/branch-heads/3809@{#864}),platform\u003dWindows NT 10.0.17763 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 60.02 seconds\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027Sasikalaj45\u0027, ip: \u0027192.168.0.50\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002712.0.2\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, timeouts\u003d{implicit\u003d0, pageLoad\u003d300000, script\u003d30000}, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:60767}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003dignore, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d76.0.3809.68 (420c9498db8ce8fcd190a954d51297672c1515d5-refs/branch-heads/3809@{#864}), userDataDir\u003dC:\\Users\\Sasikala\\AppData\\Local\\Temp\\scoped_dir14660_791220464}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, strictFileInteractability\u003dfalse, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d76.0.3809.100, browserConnectionEnabled\u003dfalse, proxy\u003d{}, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 4981519869c6c753f4bbdda0d89ab22a\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:500)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:327)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:85)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:567)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)\r\n\tat com.sun.proxy.$Proxy28.click(Unknown Source)\r\n\tat autotests.co.uk.zpl.pages.HomePage.enter_search(HomePage.java:39)\r\n\tat autotests.co.uk.zpl.stepdefs.HomePageStepDef.i_hit_the_search_button(HomePageStepDef.java:52)\r\n\tat ✽.And I hit the search button(hompage.feature:14)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "science",
      "offset": 19
    }
  ],
  "location": "CommonStepDef.assert_URL_Content(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 47604200,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1459809100,
  "status": "passed"
});
});