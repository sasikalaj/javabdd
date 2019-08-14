package autotests.co.uk.zpl.pages;

import autotests.co.uk.zpl.utils.WaitUtils;
import org.apache.commons.io.FileUtils;
// import org.apache.log4j.Logger;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import static junit.framework.TestCase.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * * Created by sasikalaj45 07/08/2019.
 * This is a general page which has fucntionalities for
 * Page factory
 * Windows handle
 * Disable overlay
 */

@Component
public abstract class Pages {

    private static final Logger LOG = Logger.getLogger(Pages.class);
    public WebDriver driver;

    @Autowired
    Config config;

    public Pages( WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        System.out.println("Inside pages contrcutor");
    }


    public WebElement findById(String element_locator) {
        return driver.findElement(By.id(element_locator));
    }

    public WebElement findByXpath(String element_locator) {
        return driver.findElement(By.xpath(element_locator));
    }

    public WebElement findByCSS(String element_locator) {
        return driver.findElement(By.cssSelector(element_locator));
    }

    public WebElement findByName(String element_locator) {
        return driver.findElement(By.name(element_locator));
    }

    public WebElement findByLinkText(String element_locator) {
        return driver.findElement(By.linkText(element_locator));
    }

    public WebElement findByPartialLinkText(String element_locator) {
        return driver.findElement(By.partialLinkText(element_locator));
    }

    public WebElement findByClassName(String element_locator) {
        return driver.findElement(By.className(element_locator));
    }

    public WebElement findByTagName(String element_locator) {
        return driver.findElement(By.tagName(element_locator));
    }

    public List<WebElement> findsById(String element_locator) {
        return driver.findElements(By.id(element_locator));
    }

    public List<WebElement> findsByXpath(String element_locator) {
        return driver.findElements(By.xpath(element_locator));
    }

    public List<WebElement> findsByCSS(String element_locator) {
        return driver.findElements(By.cssSelector(element_locator));
    }

    public List<WebElement> findsByName(String element_locator) {
        return driver.findElements(By.name(element_locator));
    }

    public List<WebElement> findsByLinkText(String element_locator) {
        return driver.findElements(By.linkText(element_locator));
    }

    public List<WebElement> findsByPartialLinkText(String element_locator) {
        return driver.findElements(By.partialLinkText(element_locator));
    }

    public List<WebElement> findsByClassName(String element_locator) {
        return driver.findElements(By.className(element_locator));
    }

    public List<WebElement> findsByTagName(String element_locator) {
        return driver.findElements(By.tagName(element_locator));
    }

    public WebElement findHeader_h1() {
        return driver.findElement(By.tagName("h1"));
    }

    public void disable_TopNav_Overlay() {

        /** This method is to disable the top navigation overlay menu, since when the resolution of the screen is low
         * some of the elements down the line are hiddden by this overlay menu.
         * Selenium cannot interact with the elements because of this.
         * Selenium is able to find the element which are hidden by the overlay, but complains that the elemenst are not clickable
         * Selenium also provides information that "other element would receive teh click" along with locator of the other element which happens to be in the overlay"
         * Tried other hacks of changing the overall resolution, again it is a gamble that it may affect footer or elements which are way down at the bottom of the screen
         */

        try {

            Thread.sleep(100);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            for (int i = 1; i < 11; i++) {
                jsExecutor.executeScript("return document.getElementsByClassName('Lb')[0].remove()");
            }
        } catch (InterruptedException e) {
        }

    }

    public boolean get_Windows_Handle_If_Any(String ScreenName) {

        String current_Window_Name = driver.getWindowHandle();

        WaitUtils.fluent_wait_for_NewWindow_To_Load(driver,10,1,2);

        Set<String> windows_List = driver.getWindowHandles();

        for (String a : windows_List) {
            if (!a.toLowerCase().contains(current_Window_Name.toLowerCase())) {
                driver.switchTo().window(a);
                // LOG.info("new Window " + driver.getCurrentUrl().toLowerCase().trim());
                WaitUtils.fluent_Wait_For_Partial_URL_Check(driver, 15, 1, ScreenName);
                boolean current_Url_Matches = driver.getCurrentUrl().toLowerCase().trim().contains(ScreenName.toLowerCase().trim());
                driver.close();
                driver.switchTo().window(current_Window_Name);
                return current_Url_Matches;
            }

        }
        return false;
    }

    public void assert_New_Page(String ScreenName) {

        assertTrue("Name of the new opened screen does not match the expected Screen name: " + ScreenName,
                get_Windows_Handle_If_Any(ScreenName));
    }

    public String ascii_Value(String text) {
        for (int i = 0; i < text.length(); i++) {   // while counting characters if less than the length add one 
            char character = text.charAt(i); // start on the first character 
            int ascii = (int) character; //convert the first character 
            System.out.print(ascii);
            // LOG.info(character + " = " + ascii); // print the character and it's value in ascii }

        }
        return text;
    }

    public void take_Screenshot(String filename)  {

        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File( filename + ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException("ScreenShot Error" + e);
        }
    }

    public void browser_Refresh () {
        driver.navigate().refresh();
    }

    public void get_URL(String Url)
    {
        driver.get(Url);
    }

    public void switch_To_Iframe_Id(String frame_Id)
    {
        driver.switchTo().frame(frame_Id);
    }

}

