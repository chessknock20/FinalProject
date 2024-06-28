package org.example.seleniumtests;

import org.example.selenium.enums.Capability;
import org.example.selenium.pages.HomePage;
import org.example.selenium.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{


    static final String ERROR_MESSAGE = "Неправильно заполнены поля E-Mail и/или пароль!";

    @DataProvider(name = "data")
    public Object[][] getData(){
        return new Object[][]{
                {"Victoria", "123", ERROR_MESSAGE},
                {"", "123", ERROR_MESSAGE},
                {"Victoria", "", ERROR_MESSAGE},
                {"", "", ERROR_MESSAGE}
        };
    }

    @Test(dataProvider = "data")
    public void IncorrectLogin(String name, String password, String errorMessage){
        HomePage homepage = new HomePage(driver);
        String message = homepage.openURL()
                .clickLoginButton()
                .inputLogin(name)
                .inputPassword(password)
                .confirm()
                .readAlert();
        Assert.assertEquals(message, errorMessage);
    }

    @Test
    public void CorrectLogin(){
        HomePage homepage = new HomePage(driver);
        boolean isAccountPresent = homepage.openURL()
                .clickLoginButton()
                .inputLogin(PropertyReader.getUserProperty(Capability.LOGIN))
                .inputPassword(PropertyReader.getUserProperty(Capability.PASSWORD))
                .confirm()
                .myAccountButtonIsPresent();
        Assert.assertTrue(isAccountPresent, "My account button is not displayed");
    }

}
