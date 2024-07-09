package com.itacademy.seleniumtests;

import com.itacademy.selenium.model.User;
import com.itacademy.selenium.pages.HomePage;
import com.itacademy.selenium.utils.UserCreator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{


    static final String ERROR_MESSAGE = "Неправильно заполнены поля E-Mail и/или пароль!";

    @DataProvider(name = "data")
    public Object[][] getData(){
        return new Object[][]{
                {UserCreator.withWrongCredentials(), ERROR_MESSAGE},
                {UserCreator.withEmptyUsername(), ERROR_MESSAGE},
                {UserCreator.withEmptyPassword(), ERROR_MESSAGE},
                {UserCreator.withEmptyCredentials(), ERROR_MESSAGE}

        };
    }

    @Test(dataProvider = "data")
    public void testLoginInvalidUser(User user, String errorMessage){
        HomePage homepage = new HomePage(driver, wait);
        String message = homepage.openURL()
                .clickLoginButton()
                .inputLogin(user.getUsername())
                .inputPassword(user.getPassword())
                .confirm()
                .readAlert();
        Assert.assertEquals(message, errorMessage);
    }

    @Test
    public void testLoginValidUser(){
        HomePage homepage = new HomePage(driver, wait);
        User testUser = UserCreator.withCredentials();
        boolean isAccountPresent = homepage.openURL()
                .clickLoginButton()
                .inputLogin(testUser.getUsername())
                .inputPassword(testUser.getPassword())
                .confirm()
                .clickCartButton()
                .myAccountButtonIsPresent();
        Assert.assertTrue(isAccountPresent, "My account button is not displayed");
    }

}
