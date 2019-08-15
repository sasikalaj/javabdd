package autotests.co.uk.zpl.stepdefs;


import cucumber.api.java.en.Then;
import autotests.co.uk.zpl.utils.WaitUtils;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sasikalaj45 07/08/2019.
 * This class contains stepdefs common to all pages and hooks
 * --Before Hooks consists of conditional logout since the browser is not closed for every scenario
 * and not necessarily all the scenarios should end with logout
 * --Stepdef for Page URL assertions
 */
public class CommonStepDef extends BaseSteps{


    @Then("^I should be presented with the (.*?) page$")
    public void assert_Pages( String page) {

        WaitUtils.waitForPageLoad(webDriver,20000,10);

        // switch (page.toLowerCase()) {
        //     case "login":
        //         expected_URL = config.loginPageURL;
        //         WaitUtils.wait_For_Visibility_Of_Element(webdriver, By.id("j_username"),10);
        //         WaitUtils.fluent_Wait_For_Partial_URL_Check(webdriver,15,1,expected_URL);
        //         ((JavascriptExecutor) webdriver).executeScript("$('input').show()");
        //         break;
        //     default:
        //         // throw new IllegalArgumentException(page + " not valid argument");
        // }


        WaitUtils.fluent_Wait_For_Partial_URL_Check(webDriver,30,1,page);

        String current_Url = webDriver.getCurrentUrl();

        assertEquals("Current URL not same as Expected URL " ,
                      page.toLowerCase() ,
                      current_Url.toLowerCase() ) ;
    }

    @Then("^Url should contain (.*?)$")
    public void assert_URL_Content( String expected_URL) {

        LOG.info("This is to prove that Log files can be used from super class");
        WaitUtils.waitForPageLoad(webDriver,20000,10);

        WaitUtils.fluent_Wait_For_Partial_URL_Check(webDriver,30,1, expected_URL);

        String current_Url = webDriver.getCurrentUrl();

        assertTrue("Current URL does not contain expected url " ,
                      current_Url.toLowerCase().contains(expected_URL)) ;
    }
}

