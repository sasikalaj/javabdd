package autotests.co.uk.zpl.pages;

import autotests.co.uk.zpl.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import static java.lang.Thread.sleep;

/**
 * * Created by sasikalaj45 07/08/2019.
 * This class includes
 * --Homepage functions
 */
public class HomePage extends BasePage {

    @FindBy(className  = "gLFyf")
    public WebElement homepage_search_field;

    @FindBy(name  =  "btnK")
    public WebElement homepage_search_button;

    @Autowired
    public HomePage (WebDriver webDriver) {
        super(webDriver);
        System.out.println("Driver hash in Homepage: " + webDriver);
        System.out.println("Inside homepage driver");
    }

    public void enter_search_text(String search_text) {
        homepage_search_field.sendKeys(search_text);
    }

    public void enter_search() {
        WaitUtils.pause(10);
        System.out.println("Text of search field" + webDriver.findElement(By.id("search-input-location")).getText());
        homepage_search_button.click();
        System.out.println("Config base urk inside Homepage" + config.base_URL);
        config.base_URL = "www.google.co.uk";
    }

}