package com.test;

import controllers.TestBase;
import org.testng.annotations.Test;
import steps.DashBoardSteps;
import steps.ItemDetailsPageSteps;
import steps.ProductListPageSteps;
import steps.ShoppingCartPageSteps;

public class DashboardPageTest extends TestBase {

    @Test(groups = { "test"}, priority = 1)
    public void searchItemTest() throws Exception {

        DashBoardSteps.SearchItemsSteps();
        ProductListPageSteps.FilterStep();
    }
    @Test(groups = { "test"}, priority = 2)
    public void viewItemTest() throws Exception {
        ItemDetailsPageSteps.ViewItemDetailsSteps();
    }
    @Test(groups = { "test"}, priority = 3)
    public void verifyCartTest() throws Exception {
        ShoppingCartPageSteps.CartItemDetailStep();
    }
    @Test(groups = { "test"}, priority = 4)
    public void clearCartTest() throws Exception {
        ShoppingCartPageSteps.CartItemClearStep();
    }

}
