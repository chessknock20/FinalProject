package com.itacademy.selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    @FindBy(id = ("gs-login"))
    private WebElement loginButton;

    @FindBy(id = ("mod_virtuemart_search"))
    private WebElement seachField;

    @FindBy(xpath = ("//*[@class = 'button']"))
    private WebElement searchButton;

    @FindBy(xpath = ("//p/a[contains(text(), ' Magnesium Citrate от VPLab ( 90 капс)')]"))
    private WebElement magnesiumItem;

    @FindBy(id = ("button-cart"))
    private WebElement addToCartButton;

    @FindBy(xpath = ("//*[@class = 'product-item col-xs-12 col-sm-12 col-md-6 col-lg-4 ']"))
    private List<WebElement> caffeineItems;

//    @FindBy(xpath = (" //*[text()=' В корзину']"))
//    private List<WebElement> addToCartButtons;

//    @FindBy(xpath = ("//div[@class = 'total_products']"))
//    private WebElement productsInCart;


    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public HomePage openURL() {
        driver.get("https://expert-sport.by/");
        return this;
    }

    public LoginPage clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new LoginPage(driver, wait);
    }

    public HomePage inputSearchingProduct(String product) {
        seachField.sendKeys(product);
        return this;
    }

    public HomePage clickSeachButton() {
        searchButton.click();
        return this;
    }

    public HomePage selectMagnesiumItem() {
        magnesiumItem.click();
        return this;
    }

    public CartPage addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        return new CartPage(driver, wait);
    }

//    public HomePage addToCartAllItems() {
//
//        for (WebElement element : addToCartButtons) {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//        }
//        return this;
//    }


    public int countCaffeineItems() {
        return caffeineItems.size();
    }
}
