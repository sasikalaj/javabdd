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
public class HomePage extends Pages{

    @FindBy(id  = "search-tabs-for-sale")
    public WebElement find_for_sale_tab;

    @FindBy(id  = "search-input-location")
    public WebElement search_input_location;

    @FindBy(id  =  "search-submit")
    public WebElement find_search_button;

    @Autowired
    public HomePage (WebDriver driver) {

        super(driver);
        System.out.println("Inside homepage driver");
    }

    public void enter_location(String location) {
        search_input_location.sendKeys(location);
    }

    public void enter_search() {
        WaitUtils.pause(10);
        System.out.println("Text of search field" + driver.findElement(By.id("search-input-location")).getText());
        find_search_button.click();
        System.out.println("Config base urk inside Homepage" + config.base_URL);
        config.base_URL = "www.google.co.uk";
    }

}