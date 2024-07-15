package com.itacademy.selenium.pages;

import com.itacademy.selenium.utils.ScreenshotUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    @FindBy(xpath = ("//img[@class = 'cart-ico-vm']"))
    private WebElement cartButton;

    @FindBy(xpath = ("//td[contains(text(), ' Magnesium Citrate от VPLab ( 90 капс)')]"))
    private WebElement magnesiumItem;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public CartPage closeAlert(){
        String cssPath = "[class = 'vex-close']";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[class = 'vex-content']"))));
        ((JavascriptExecutor)driver).executeScript("document.querySelector(arguments[0],':before').click();",cssPath);
        return this;
    }

    public CartPage clickCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
        return this;
    }

    public String getTextMagnesium(){
        return magnesiumItem.getText();
    }
}
