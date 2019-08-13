package autotests.co.uk.zpl.stepdefs;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;
import autotests.co.uk.zpl.utils.WaitUtils;
// import static org.junit.Assert.assertTrue;


/**
 * Created by sasikala.jayavel on 07/08/2019.
 * This class contains stepdefs related to HomePage
 */
public class HomePageStepDef extends AbstractSteps {

    // @When("^I click the (.*?) link in the (footer|header)")
    // public void click_Footer_Link(String linkType, String linksection) {
    //     switch (linkType.toLowerCase()) {
    //         case "facebook social media":
    //             System.out.println("Test case");
    //             break; 
    //         default: 
    //             System.out.println("Test case");
    //     }
    // } 

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

        homePage.driver.get(config.homePageURL);
        WaitUtils.waitForPageLoad(homePage.driver, 10, 1);
}

@Then("^I see for sale channel tab on the homepage$")
public void i_see_for_sale_channel_tab_on_the_homepage() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // throw new PendingException();
}

@When("^I enter London in the location field$")
public void i_enter_London_in_the_location_field() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // throw new PendingException();
}

@When("^I hit the search button$")
public void i_hit_the_search_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // throw new PendingException();
}

@Then("^I should be taken to the search results page$")
public void i_should_be_taken_to_the_search_results_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // throw new PendingException();
}

@Then("^Url should contain /for-sale/property/london$")
public void url_should_contain_for_sale_property_london() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // throw new PendingException();
}

}
