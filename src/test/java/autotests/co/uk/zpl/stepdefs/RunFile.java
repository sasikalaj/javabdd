package autotests.co.uk.zpl.stepdefs;


// import autotests.co.uk.zpl.setup.StandaloneClient;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created by sasikalaj45 07/08/2019.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        strict = false,
        plugin = { "pretty",
                "json:target/cucumber.json",
                "html:target/site/cucumber-pretty"},
        glue = "autotests.co.uk.zpl.stepdefs" ,
        features="src/test/resources/features",
        tags = {"@solo"}
)
public class RunFile { @BeforeClass
    public static  void set_Up_Before_Test() throws Exception
    {
        //  System.out.println("Delete Customer: " + StandaloneClient.callDeleteCustomer(StandaloneClient.userData()));
        //  System.out.println("Setup Customer: " + StandaloneClient.callDataSetup());
    }
}
