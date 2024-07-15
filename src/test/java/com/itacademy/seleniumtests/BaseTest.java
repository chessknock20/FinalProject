package com.itacademy.seleniumtests;

import com.itacademy.selenium.listeners.ElementActionListener;
import com.itacademy.selenium.listeners.LocalListener;
import com.itacademy.selenium.utils.DriverFactory;
import com.itacademy.selenium.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(LocalListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator(new ElementActionListener());
        driver = decorator.decorate(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    }

    @AfterMethod
    public void closeSession(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()){
            ScreenshotUtils.takeScreenshot(driver);
        }
        DriverFactory.closeDriver();
    }
}
