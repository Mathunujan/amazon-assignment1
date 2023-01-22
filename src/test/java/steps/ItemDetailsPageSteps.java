package steps;


import controllers.FunctionHelper;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.Dashboard;
import pages.ItemDetailPage;
import pages.ProductListPage;

import java.util.ArrayList;

public class ItemDetailsPageSteps {
    ProductListPage productListPage= new ProductListPage();
    ItemDetailPage itemDetailPage= new ItemDetailPage();
    public void ViewItemDetailsSteps() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        FunctionHelper.staticWait(5);
        productListPage.navigateItemDetails(itemDetailPage.dataProp.getProperty("itemSelect"));
        Assert.assertTrue(ItemDetailPage.isItemDetailPageDisplayed(),"Page not landed on Item Detail page!") ;
            softAssert.assertTrue(ItemDetailPage.isPriceMatchAsProdList(),"The price not matched! ") ;
        softAssert.assertTrue(ItemDetailPage.isItmNameMatchAsProdList(),"The Item name not matched") ;
        ItemDetailPage.selectQTY(itemDetailPage.dataProp.getProperty("quantitySelect"));
        ItemDetailPage.setItemDetails();
        softAssert.assertTrue(ItemDetailPage.isQtySelect(),"The quantity is not selected") ;

    }

    public void addToCartSteps() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        ItemDetailPage.selectQTY(itemDetailPage.dataProp.getProperty("quantitySelect"));
        ItemDetailPage.setItemDetails();
        softAssert.assertTrue(ItemDetailPage.isQtySelect(),"The quantity is not selected") ;
        ItemDetailPage.addToCart();

    }

}
