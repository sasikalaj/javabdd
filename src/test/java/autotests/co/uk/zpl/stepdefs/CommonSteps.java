package autotests.co.uk.zpl.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.apache.commons.io.FileUtils;
// import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import autotests.co.uk.zpl.pages.Config;
import autotests.co.uk.zpl.utils.BrowserFactory;
import autotests.co.uk.zpl.utils.WaitUtils;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

/**
 * Created by sasikala.jayavel on 18/05/2016.
 * This class contains stepdefs common to all pages and hooks
 * --Before Hooks consists of conditional logout since the browser is not closed for every scenario
 * and not necessarily all the scenarios should end with logout
 * --Stepdef for Page URL assertions
 */
public class CommonSteps {

    // private static final Logger LOG = Logger.getLogger(CommonSteps.class);
    public  WebDriver webdriver ;

    @Autowired
    BrowserFactory browserFactory;

    @Autowired
    Config config;


    @Autowired
    public CommonSteps( WebDriver driver) {

        this.webdriver = driver;
        PageFactory.initElements(driver, this);
    }

    @Then("^I should be presented with the (.*?) page$")
    public void assert_Pages( String page) {

        String expected_URL = "";
        WaitUtils.waitForPageLoad(webdriver,20000,10);

        switch (page.toLowerCase()) {
            case "login":
                expected_URL = config.loginPageURL;
                WaitUtils.wait_For_Visibility_Of_Element(webdriver, By.id("j_username"),10);
                WaitUtils.fluent_Wait_For_Partial_URL_Check(webdriver,15,1,expected_URL);
                ((JavascriptExecutor) webdriver).executeScript("$('input').show()");
                break;
            default:
                throw new IllegalArgumentException(page + " not valid argument");
        }

        WaitUtils.fluent_Wait_For_Partial_URL_Check(webdriver,30,1,expected_URL);

        String current_Url = webdriver.getCurrentUrl();

        assertEquals("Current URL not same as Expected URL " ,
                      expected_URL.toLowerCase() ,
                      current_Url.toLowerCase() ) ;
    }
}

