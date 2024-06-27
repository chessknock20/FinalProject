package org.example.seleniumtests.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(id = ("gs-login"))
    private WebElement LoginButton;

    @FindBy(id = ("mod_virtuemart_search"))
    private WebElement seachField;

    @FindBy(xpath = ("//i[@class = 'fa fa-search']"))
    private WebElement searchButton;

    @FindBy(xpath = ("//p/a[contains(text(), ' Magnesium Citrate от VPLab ( 90 капс)')]"))
    private WebElement MgnesiumItom;

    @FindBy(id = ("button-cart"))
    private WebElement addToCartButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openURL(){
        driver.get("https://expert-sport.by/");
        return this;
    }

    public LoginPage clickLoginButton(){
        LoginButton.click();
        return new LoginPage(driver);
    }
    public HomePage inputSearchingProduct(String product){
        seachField.sendKeys(product);
        return this;
    }
    public HomePage clickSeachButton(){
        searchButton.click();
        return this;
    }
    public HomePage selectMagnesiunItem(){
        MgnesiumItom.click();
        return this;
    }
    public CartPage addToCart(){
        addToCartButton.click();
        return new CartPage(driver);
    }
}
