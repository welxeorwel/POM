package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfiguration {
    protected static AppiumDriver<MobileElement> driver;
    protected Logger logger = LoggerFactory.getLogger(AppiumConfiguration.class);

    @BeforeSuite

    public void startUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "bobik");
        logger.info("\"deviceName\",\"bobik\"");
        capabilities.setCapability("platformName", "Android");
        logger.info("\"platformName\",\"Android\"");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("appPackage", "com.h6ah4i.android.example.advrecyclerview");
        capabilities.setCapability("appActivity", ".launcher.MainActivity");
        capabilities.setCapability("automationName", "Appium");

        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //   driver =  EventFiringWebDriverFactory.getEventFiringWebDriver(driver,new MyListner());
    }

    //TODO complete logger every class
    @AfterSuite
    public void quit() {
        driver.quit();
    }
}

