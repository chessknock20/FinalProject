package com.itacademy.seleniumtests;

import com.itacademy.selenium.pages.HomePage;
import com.itacademy.selenium.utils.PropertyReader;
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
    public void testLoginInvalidUser(String name, String password, String errorMessage){
        HomePage homepage = new HomePage(driver, wait);
        String message = homepage.openURL()
                .clickLoginButton()
                .inputLogin(name)
                .inputPassword(password)
                .confirm()
                .readAlert();
        Assert.assertEquals(message, errorMessage);
    }

    @Test
    public void testLoginValidUser(){
        HomePage homepage = new HomePage(driver, wait);
        boolean isAccountPresent = homepage.openURL()
                .clickLoginButton()
                .inputLogin("chessknock20@gmail.com")
                .inputPassword("110v354m")
                .confirm()
                .myAccountButtonIsPresent();
        Assert.assertTrue(isAccountPresent, "My account button is not displayed");
    }

}
