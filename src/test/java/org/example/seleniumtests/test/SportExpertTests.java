package org.example.seleniumtests.test;

import org.example.selenium.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SportExpertTests extends BaseTest {

    @Test
    public void FindItem() {
        HomePage homepage = new HomePage(driver);
        String product = "magnesium";
        String result = homepage.openURL()
                .inputSearchingProduct(product)
                .clickSeachButton()
                .selectMagnesiunItem()
                .addToCart()
                .closeAlert()
                .clickCartButton()
                .getTextMagnesium();
        Assert.assertEquals(result, "Magnesium Citrate от VPLab ( 90 капс)");
    }
}
