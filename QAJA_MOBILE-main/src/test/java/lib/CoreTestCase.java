package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import lib.ui.PlatformSelector;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class CoreTestCase {

    protected AppiumDriver<WebElement> driver;
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    @Before
    public void setUp() throws Exception {
        URL URL = new URL(APPIUM_URL);


            this.driver = new IOSDriver<WebElement>(URL, this.getIOSDesiredCapabilities());

            throw new Exception("Cannot run Appium session with the platform equals " + PlatformSelector.PLATFORM);
        }


    @After
    public void tearDown() {
        this.driver.quit();
    }




    private DesiredCapabilities getIOSDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 12 Pro");
        capabilities.setCapability("platformVersion", "14.2");
        capabilities.setCapability("app", "\\Users\\Alexey\\Desktop\\Учеба IT\\QAJA_MOBILE\\apps\\Wikipedia.app");
        return capabilities;
    }

}
