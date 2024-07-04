package com.itacademy.seleniumtests;

import com.itacademy.selenium.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SportExpertTests extends BaseTest {

    @Test
    public void addToCartTest() {
        HomePage homepage = new HomePage(driver, wait);
        String product = "magnesium";
        String result = homepage.openURL()
                .inputSearchingProduct(product)
                .clickSeachButton()
                .selectMagnesiumItem()
                .addToCart()
                .closeAlert()
                .clickCartButton()
                .getTextMagnesium();
        Assert.assertEquals(result, "Magnesium Citrate от VPLab ( 90 капс)");
    }

    @Test
    public void findAllItemsTest(){
        HomePage homepage = new HomePage(driver, wait);
        String product = "caffeine";
        int result = homepage.openURL()
                .inputSearchingProduct(product)
                .clickSeachButton()
                .countCaffeineItems();
        Assert.assertEquals(result, 6);

    }

}
