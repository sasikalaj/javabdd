package autotests.co.uk.zpl.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import autotests.co.uk.zpl.pages.Config;
import autotests.co.uk.zpl.utils.BrowserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by sasikala.jayavel on 18/05/2016.
 * This class contains stepdefs common to all pages and hooks
 * --Before Hooks consists of conditional logout since the browser is not closed for every scenario
 * and not necessarily all the scenarios should end with logout
 * --Stepdef for Page URL assertions
 */
public class Hooks {

    // private static final Logger LOG = Logger.getLogger(CommonSteps.class);
    public  WebDriver webdriver ;

    @Autowired
    BrowserFactory browserFactory;

    @Autowired
    Config config;


    @Autowired
    public Hooks( WebDriver driver) {

        this.webdriver = driver;
        PageFactory.initElements(driver, this);
    }

    @Before
    public  void set_Up()
    {
        webdriver.manage().deleteAllCookies();
        webdriver.get(config.homePageURL);
    }

    @After("~@nologout")
    public void logout_Step()
    {
        webdriver.get(config.homePageURL);
          if (webdriver.findElement(By.cssSelector(".logged_in")).getText().toLowerCase().contains("hello "))
          {
              webdriver.findElement(By.linkText("Log Out")).click();
          }
    }

    @After()
    public void tearDown(  Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) webdriver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
            File scrFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("TearDownScreenShot.jpg"));

        }
    }

    @AfterClass
    public void clearSession() {
        // LOG.info("Inside the browser quit session");
        browserFactory.getBrowser().quit();
    }
}

