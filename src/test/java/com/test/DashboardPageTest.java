package com.test;

import controllers.FunctionHelper;
import controllers.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Dashboard;
import pages.ProductListPage;
import steps.DashBoardSteps;
import steps.ItemDetailsPageSteps;
import steps.ProductListPageSteps;
import steps.ShoppingCartPageSteps;

public class DashboardPageTest extends TestBase {
    //ProductListPageSteps productListPageSteps = new ProductListPageSteps();
    ItemDetailsPageSteps itemDetailsPageSteps=new ItemDetailsPageSteps();

    @Test(groups = { "test"}, priority = 1)
    public void searchItemTest() throws Exception {

        DashBoardSteps.SearchItemsSteps();
        ProductListPageSteps.FilterStep();

    }
    @Test(groups = { "test"}, priority = 2)
    public void viewItemTest() throws Exception {
        itemDetailsPageSteps.ViewItemDetailsSteps();
    }

    @Test(groups = { "test"}, priority = 3)
    public void verifyCartTest() throws Exception {
        ShoppingCartPageSteps.CartItemDetailstep();
    }
//    @Test(groups = { "test"}, priority = 3)
//    public void clearCartTest() throws Exception {
//        itemDetailsPageSteps.ViewItemDetailsSteps();
//    }

}
