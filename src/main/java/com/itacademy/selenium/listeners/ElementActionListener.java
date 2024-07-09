package com.itacademy.selenium.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;
import java.util.List;

public class ElementActionListener implements WebDriverListener {

    private static final Logger LOGGER = LogManager.getLogger(ElementActionListener.class);

    @Override
    public void afterClick(WebElement element) {
        LOGGER.info(Arrays.stream(element.toString().split("->")).toList().get(1) + " is clicked");
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        LOGGER.info(Arrays.stream(element.toString().split("->")).toList().get(1) + "get text " + result);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        LOGGER.info(Arrays.stream(result.toString().split("->")).toList().get(1) +" found successfully");
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        LOGGER.info("elements found successfully");
    }
}
