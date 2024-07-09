package com.itacademy.selenium.listeners;

import com.itacademy.selenium.utils.DriverFactory;
import com.itacademy.selenium.utils.ScreenshotUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LocalListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(LocalListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("=========================================================");
        LOGGER.info("Test " + result.getMethod().getMethodName() +  " started");
        LOGGER.info("=========================================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("=========================================================");
        LOGGER.info("Test " + result.getMethod().getMethodName() +  " success");
        LOGGER.info("=========================================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("=========================================================");
        LOGGER.info("Test " + result.getMethod().getMethodName() +  " failed");
        LOGGER.info("=========================================================");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.info("=========================================================");
        LOGGER.info("Test " + result.getMethod().getMethodName() +  " skipped");
        LOGGER.info("=========================================================");
    }
}
