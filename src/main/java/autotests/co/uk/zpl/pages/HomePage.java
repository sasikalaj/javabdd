package autotests.co.uk.zpl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Sasikala on 18/05/2016.
 * This class includes
 * --Homepage functions
 */
public class HomePage extends Pages {

    @FindBy(partialLinkText  =  "")
    public WebElement find_Logintext;

    @FindBy(partialLinkText  =  "Log Out")
    public WebElement find_LogOuttext;

    @Autowired
    public HomePage (WebDriver driver) {
     
        super(driver);
    }

    @Autowired
    Config config;

}