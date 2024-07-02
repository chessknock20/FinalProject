package org.example.seleniumtests;

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
                .selectMagnesiumItem()
                .addToCart()
                .closeAlert()
                .clickCartButton()
                .getTextMagnesium();
        Assert.assertEquals(result, "Magnesium Citrate от VPLab ( 90 капс)");
    }

    @Test
    public void FindAllItems(){
        HomePage homepage = new HomePage(driver);
        String product = "caffeine";
        int result = homepage.openURL()
                .inputSearchingProduct(product)
                .clickSeachButton()
                .countCaffeineItems();
        Assert.assertEquals(result, 6);

    }

}
