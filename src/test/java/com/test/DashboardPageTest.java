package com.test;

import controllers.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import steps.DashBoardSteps;
import steps.ItemDetailsPageSteps;
import steps.ProductListPageSteps;
import steps.ShoppingCartPageSteps;

public class DashboardPageTest extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    ProductListPageSteps productListPageSteps= new ProductListPageSteps();
    ItemDetailsPageSteps itemDetailsPageSteps = new ItemDetailsPageSteps();

    @Test(groups = { "test"}, priority = 1)

    public void searchItemTest() throws Exception {
        DashBoardSteps.SearchItemsSteps();
        productListPageSteps.FilterStep();
        softAssert.assertAll();
    }
//    @Test(groups = { "test"}, priority = 2)
//    public void viewItemTest() throws Exception {
//        itemDetailsPageSteps.ViewItemDetailsSteps();
//        softAssert.assertAll();
//    }
//    @Test(groups = { "test"}, priority = 3)
//    public void verifyCartTest() throws Exception {
//        itemDetailsPageSteps.addToCartSteps();
//        ShoppingCartPageSteps.CartItemDetailStep();
//        softAssert.assertAll();
//    }
//    @Test(groups = { "test"}, priority = 4)
//    public void clearCartTest() throws Exception {
//        ShoppingCartPageSteps.CartItemClearStep();
//        softAssert.assertAll();
//    }

}
