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

    @FindBy(id  = "search-tabs-for-sale")
    public WebElement find_for_sale_tab;

    @FindBy(id  = "search-input-location")
    public WebElement search_input_location;

    @FindBy(id  =  "search-submit")
    public WebElement find_search_button;

    @Autowired
    public HomePage (WebDriver driver) {
     
        super(driver);
    }

    public void enter_location(String location) {
        search_input_location.sendKeys(location);
    }

    public void enter_search() { 
        find_search_button.click(); 
    }

}