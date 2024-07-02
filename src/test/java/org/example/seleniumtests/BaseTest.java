package org.example.seleniumtests;

import org.example.selenium.enums.Capability;
import org.example.selenium.listeners.ElementActionListener;
import org.example.selenium.listeners.LocalListener;
import org.example.selenium.utils.DriverFactory;
import org.example.selenium.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(LocalListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver(PropertyReader.getConfigProperty(Capability.BROWSER));
//        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator(new ElementActionListener());
//        driver = decorator.decorate(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterMethod
    public void closeSession() {
        driver.quit();
    }
}
