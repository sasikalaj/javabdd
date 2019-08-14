package autotests.co.uk.zpl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * * Created by sasikalaj45 07/08/2019.
 * This class includes
 * --Homepage functions
 */
public class LoginPage extends Pages{

    @FindBy(id  = "search-input-location")
    public WebElement name;

    @FindBy(id  = "search-input-location")
    public WebElement password;

    @FindBy(id  =  "search-submit")
    public WebElement submit_button;

    @Autowired
    public LoginPage (WebDriver driver) {

        super(driver);
        System.out.println("Inside Login driver");
    }


    public void input_name(String input_name) {
//        name.clear();
//        name.sendKeys(input_name);
        System.out.println("Config base urk inside LoginPage" + config.base_URL);
        System.out.println(input_name);

    }

    public void input_password(String input_pwd) {
//        password.clear();
//        password.sendKeys(input_pwd);
        System.out.println(input_pwd);
    }

}