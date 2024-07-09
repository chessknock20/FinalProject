package com.itacademy.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id = ("input-email"))
    private WebElement inputLoginArea;

    @FindBy(id = ("input-password"))
    private WebElement inputPasswordArea;

    @FindBy(xpath = ("//button[@class = 'btn btn-primary']"))
    private WebElement loginButton;

    @FindBy(xpath = ("//div[@class = 'alert alert-danger']"))
    private WebElement alertIncorrectData;


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LoginPage inputLogin(String login){
        inputLoginArea.sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String password){
        inputPasswordArea.sendKeys(password);
        return this;
    }

    public HomePage confirm(){
        loginButton.click();
        return new HomePage(driver, wait);
    }

    public String readAlert(){
        return alertIncorrectData.getText();
    }


}
