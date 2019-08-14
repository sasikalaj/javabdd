package autotests.co.uk.zpl.stepdefs;

import autotests.co.uk.zpl.pages.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * * Created by sasikalaj45 07/08/2019.
 */

public abstract class AbstractSteps {

    public static final Logger LOG = Logger.getLogger(AbstractSteps.class);

    @Autowired
    WebDriver driver;

    @Autowired
    public Config config;

    @Autowired
    public HomePage homePage;

    @Autowired
    public LoginPage loginPage;

}

