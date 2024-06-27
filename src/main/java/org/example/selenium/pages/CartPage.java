package org.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    @FindBy(xpath = ("//img[@class = 'cart-ico-vm']"))
    private WebElement cartButton;

    @FindBy(xpath = ("//td[contains(text(), ' Magnesium Citrate от VPLab ( 90 капс)')]"))
    private WebElement magnesiunItom;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage closeAlert(){
        String cssPath = "[class = 'vex-close']";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[class = 'vex-content']"))));
        ((JavascriptExecutor)driver).executeScript("document.querySelector(arguments[0],':before').click();",cssPath);
        return this;
    }

    public CartPage clickCartButton(){
        cartButton.click();
        return this;
    }

    public String getTextMagnesium(){
        return magnesiunItom.getText();
    }
}
