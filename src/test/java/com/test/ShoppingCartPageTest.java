package com.test;

import controllers.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import steps.ItemDetailsPageSteps;
import steps.ProductListPageSteps;
import steps.ShoppingCartPageSteps;

public class ShoppingCartPageTest extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    ProductListPageSteps productListPageSteps= new ProductListPageSteps();
    ItemDetailsPageSteps itemDetailsPageSteps = new ItemDetailsPageSteps();

    @Test(groups = { "test"}, priority = 4)
    public void verifyCartTest() throws Exception {
        ShoppingCartPageSteps.CartItemDetailStep();
        softAssert.assertAll();
    }
    @Test(groups = { "test"}, priority = 5)
    public void clearCartTest() throws Exception {
        ShoppingCartPageSteps.CartItemClearStep();
        softAssert.assertAll();
    }

}
