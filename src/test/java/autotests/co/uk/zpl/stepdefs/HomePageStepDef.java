package autotests.co.uk.zpl.stepdefs;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;
import autotests.co.uk.zpl.utils.WaitUtils;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;


/**
 * Created by sasikala.jayavel on 07/08/2019.
 * This class contains stepdefs related to HomePage
 */
public class HomePageStepDef extends AbstractSteps {

    
@Given("^I am already in Homepage$")
public void i_am_already_in_Homepage() throws Throwable {
    try
        {
            Thread.sleep(2);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException( "Exception during wait in the add_Item_to_Basket" + e );
        }
        WaitUtils.waitForPageLoad(homePage.driver, 1, 1);
        assertEquals("Actual url does not match expected URL", 
                     config.homePageURL,
                     homePage.driver.getCurrentUrl().toLowerCase().trim()) ; 
}

@Then("^I see for sale channel tab on the homepage$")
public void i_see_for_sale_channel_tab_on_the_homepage() throws Throwable {
    WebElement element = homePage.find_for_sale_tab;
    WaitUtils.fluent_Wait_For_Element_Displayed(element, 15, 1);
    assertTrue("Actual url does not match expected URL", 
                element.isDisplayed());
                    
}

@When("^I enter (.*?) in the location field$")
public void i_enter_London_in_the_location_field(String location) throws Throwable {
    homePage.enter_location(location); 
}

@When("^I hit the search button$")
public void i_hit_the_search_button() throws Throwable {
    homePage.enter_search(); 
}
}
