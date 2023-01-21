package steps;


import org.testng.asserts.SoftAssert;
import pages.Dashboard;
import pages.ItemDetailPage;
import pages.ProductListPage;

import java.util.ArrayList;

public class ItemDetailsPageSteps {
    //ProductListPage productListPage=new ProductListPage();
   static ArrayList<String> itemDetails = new ArrayList<String>();
    public static void ViewItemDetailsSteps() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        //Assert.assertTrue(Dashboard.isItemDetailsPageDisplayed(),"") ;
        Dashboard.staticWait(5);
        ProductListPage.navigateItemDetails();
        softAssert.assertTrue(ItemDetailPage.isPriceMatchAsProdList(),"The price not matched ") ;
        softAssert.assertTrue(ItemDetailPage.isItmNameMatchAsProdList(),"The Item name not matched ") ;
        ItemDetailPage.selectQTY("2");
        ItemDetailPage.setItemDetails();
        softAssert.assertTrue(ItemDetailPage.isQtySelect(),"The quantity is not selected") ;
        ItemDetailPage.addToCart();
        ItemDetailPage.goToCart();

        softAssert.assertAll();


    }

}
