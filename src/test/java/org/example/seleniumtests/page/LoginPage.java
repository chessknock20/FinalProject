package org.example.seleniumtests.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = ("input-email"))
    private WebElement InputLoginArea;

    @FindBy(id = ("input-password"))
    private WebElement InputPasswordArea;

    @FindBy(xpath = ("//button[@class = 'btn btn-primary']"))
    private WebElement LoginButton;

    @FindBy(xpath = ("//div[@class = 'alert alert-danger']"))
    private WebElement AlertIncorrectData;

    @FindBy(id = "gs-account")
    private WebElement MyAccountButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputLogin(String login){
        InputLoginArea.sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String password){
        InputPasswordArea.sendKeys(password);
        return this;
    }

    public LoginPage confirm(){
        LoginButton.click();
        return this;
    }
    public String readAlert(){
        return AlertIncorrectData.getText();
    }

    public boolean myAccountButtonIsPresent(){
        return MyAccountButton.isDisplayed();
    }

}
