package steps;


import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.Dashboard;
import pages.ItemdetailPage;
import pages.ProductListPage;

import java.util.ArrayList;

public class ItemDetailsPageSteps {
    //ProductListPage productListPage=new ProductListPage();
   static ArrayList<String> itemDetails = new ArrayList<String>();
    public void ViewItemDetailsSteps() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        //Assert.assertTrue(Dashboard.isDashboardPageDisplayed(),"That title is not display here ") ;
//itemDetails=ProductListPage
        Dashboard.staticWait(5);
        ProductListPage.navigateItemDetails("2");
        softAssert.assertTrue(ItemdetailPage.isPricematchAsProdList(),"That Item details not matched ") ;
        softAssert.assertTrue(ItemdetailPage.isItmNameMatchAsProdList(),"That Item name not matched ") ;
        //Assert.assertTrue(ItemdetailPage.isItmNameMatchAsProdList(),"That Item name not matched ") ;
        ItemdetailPage.selectQTY("2");
        ItemdetailPage.addToCart();
        ItemdetailPage.goToCart();
        //Dashboard.PrintSomething();

        softAssert.assertAll();


    }

}
