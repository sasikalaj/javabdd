package autotests.co.uk.zpl.stepdefs;

import autotests.co.uk.zpl.pages.Config;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;
import autotests.co.uk.zpl.utils.BrowserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by sasikalaj45 07/08/2019.
 * This class contains stepdefs common to all pages and hooks
 * --Before Hooks consists of conditional logout since the browser is not closed for every scenario
 * and not necessarily all the scenarios should end with logout
 * --Stepdef for Page URL assertions
 */
public class Hooks {

    private static final Logger LOG = Logger.getLogger(Hooks.class);

    @Autowired
    BrowserFactory browserFactory;

    @Autowired
    Config config;

    @Autowired
    WebDriver driver;


    @Before
    public  void set_Up()
    {
        driver.manage().deleteAllCookies();
        System.out.println("Inside hooks set_up");
    }

    @After("~@nologout")
    public void logout_Step()
    {
        System.out.println("Inside hooks logout_step config homepage URL : " + config.homePageURL);
        driver.manage().deleteAllCookies();

    }

    @After()
    public void tearDown(  Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            System.out.println("Inside hooks logout_step");
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("TearDownScreenShot.jpg"));

        }
    }

    @AfterClass
    public void clearSession() {
        LOG.info("Inside the browser quit session");
        browserFactory.getBrowser().quit();
    }
}

