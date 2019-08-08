
package co.uk.sainsburys.tuclothing.stepdefs;


import co.uk.sainsburys.tuclothing.setup.StandaloneClient;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created by sasikala 18/02/2016
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        strict = false,
        format = { "pretty",
                "json:target/cucumber.json",
                "html:target/site/cucumber-pretty"},
        glue = "co.uk.sainsburys.tuclothing.stepdefs" ,
        features="src/test/resources/features",
        tags = {"@solo"}
)
public class RunFile { @BeforeClass
    public static  void set_Up_Before_Test() throws Exception
    {
         System.out.println("Delete Customer: " + StandaloneClient.callDeleteCustomer(StandaloneClient.userData()));
         System.out.println("Setup Customer: " + StandaloneClient.callDataSetup());
    }
}
