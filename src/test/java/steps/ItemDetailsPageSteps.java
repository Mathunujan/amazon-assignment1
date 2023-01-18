package steps;


import org.testng.asserts.SoftAssert;
import pages.Dashboard;
import pages.ItemdetailPage;
import pages.ProductListPage;

import java.util.ArrayList;

public class ItemDetailsPageSteps {
    //ProductListPage productListPage=new ProductListPage();
   static ArrayList<String> itemDetails = new ArrayList<String>();
    public static void ViewItemDetailsSteps() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        //Assert.assertTrue(Dashboard.isItemDetailsPageDisplayed(),"") ;
        Dashboard.staticWait(5);
        ProductListPage.navigateItemDetails("2");
        softAssert.assertTrue(ItemdetailPage.isPriceMatchAsProdList(),"The price not matched ") ;
        softAssert.assertTrue(ItemdetailPage.isItmNameMatchAsProdList(),"The Item name not matched ") ;
        ItemdetailPage.selectQTY("2");
        ItemdetailPage.setItemDetails();
        softAssert.assertTrue(ItemdetailPage.isQtySelect(),"The quantity is not selected") ;
        ItemdetailPage.addToCart();
        ItemdetailPage.goToCart();

        softAssert.assertAll();


    }

}
