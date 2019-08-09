package autotests.co.uk.zpl.stepdefs;

import autotests.co.uk.zpl.pages.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sasikala.jayavel on 25/11/2016.
 */
public abstract class AbstractSteps {
    @Autowired
    public HomePage homePage;

    @Autowired
    public Config config;

}

