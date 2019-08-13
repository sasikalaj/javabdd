package autotests.co.uk.zpl.utils;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

/**
 * Created by Sasikala on 9/8/2019
 * utility functions to
 * -- create Webdriver instance for respective browser
 */
@Configuration
public class BrowserFactory
{
    private static final Logger LOG = Logger.getLogger(BrowserFactory.class);
    private WebDriver driver;
    private static final String ENV          = getSystemProperty("environment");
    public static final String BROWSER_NAME  = getSystemProperty("browser");
    public static final String USER_DIR      = getSystemProperty("userdir");
    public static final String PROD_BASE_URL = getSystemProperty("liveurl");
    public static final String BASE_URL      = setBaseURL();
    

    @Bean(destroyMethod = "quit")
//  @Scope("cucumber-glue") Never glue the driver to the cucumber, this will close the browser for every cucumber scenario
    public WebDriver getBrowser()
    {
        if (driver == null)
        {
            setDriver();
        }

        return driver;
    }

    private static String getSystemProperty(final String propertyId)
    {
        String result = System.getProperty(propertyId);
     
        if (result == null)
        {
            // Default values if not set.
            switch (propertyId)
            {
                case "environment":
                    result = "qa";
                    break;
                case "browser":
                    result = "chrome";
                    break;
                case "userdir":
                    result =  "/Users/sasikala.jayavel/Documents/Projects/javabdd/";  
                    break; 
                case "liveurl":
                    result =  "https://www.xxx.co.uk";  
                    break;     
                default:
                    break;
            }
        }

        return result;
    }

    private static String setBaseURL()
    {
        System.out.println("Inside the baseURL on the browsers factory");
        switch (ENV.toLowerCase())
        {
            case "dev":
                return  "https://www.xxx.xxx.co.uk";
            case "qa":
                return "https://www.qa.zoopla.co.uk";
            case "stage":
                return "https://www.xxx.xxx.co.uk";
            case "prod":
                return "https://www.xxx.xxx.co.uk";
            default:
                LOG.info("Could not find a predefined URL for ENV " + ENV + ". Using: " + BASE_URL);
                return "https://www." + ENV + ".xxx.xxx.co.uk";
        }
    }

    private void setDriver()
    {
        System.out.println("Inside the setdriver on the browsers factory");
        switch (BROWSER_NAME.toLowerCase()) {
            case "firefox":
                LOG.info("browser firefox");
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                LOG.info("browser ie");
                InternetExplorerDriverManager.getInstance().setup();
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                driver = new InternetExplorerDriver(caps);
                break;
            case "chrome":
                LOG.info("browser chrome");
                //  ChromeDriverManager.getInstance().setup(); 
                // if we use this maven downloads the latest version of chrome which 77 beta version and caches that into /Users/user.name/.m2/repository/webdriver
                // So use the below commands to pick it up from a specified location 
                System.setProperty("webdriver.chrome.driver", USER_DIR + "chromedriver");
                driver = new ChromeDriver();
                break;
            case "safari":
                LOG.info("browser safari");
                driver = new SafariDriver();
                break;
            case "phantomjs":
                PhantomJsDriverManager.getInstance().setup();
                driver = new PhantomJSDriver();
                break;
            case "firefoxuseragent":
                ProfilesIni profile = new ProfilesIni();
                FirefoxProfile profileFF = profile.getProfile("default");
                profileFF.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16");
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver(profileFF);
                break;
            case "chromeuseragent":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.addArguments("–user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 8_0_2 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Version/8.0 Mobile/12A366 Safari/600.1.4");//iPhone 4
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver(cOptions);
                break;
            // case "IE7FF40"
            //     caps.setCapability("browser", "IE");
            //     caps.setCapability("browser_version", "11.0");
            //     caps.setCapability("os", "Windows");
            //     caps.setCapability("os_version", "10");
            //     caps.setCapability("resolution", "1024x768");
            //     caps.setCapability("browserstack.debug", "true");
            //     caps.setCapability("browserstack.local", "true");
            //     caps.setCapability("browserstack.localIdentifier", "Test123");
            default:
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
        }

        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        if ("ie".equalsIgnoreCase(BROWSER_NAME))
        {
            driver.get("javascript:document.getElementById('overridelink').click()");
        }
    }
}
