package steps;


import org.testng.asserts.SoftAssert;
import pages.ShoppingCartPage;

public class ShoppingCartPageSteps {
    //ProductListPage productListPage=new ProductListPage();
    public static void CartItemDetailstep() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        ShoppingCartPage.setItemDetails();
        softAssert.assertTrue(ShoppingCartPage.isItmNameMatchAsItemDetailsPage(),"That Item name not matched!" );
        softAssert.assertTrue(ShoppingCartPage.isItmQtyMatchAsItemDetailsPage(),"The Quantity not matched!" );
        softAssert.assertAll();

    }

}
