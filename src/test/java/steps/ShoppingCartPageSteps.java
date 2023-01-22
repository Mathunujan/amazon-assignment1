package steps;


import org.testng.asserts.SoftAssert;
import pages.ItemDetailPage;
import pages.ShoppingCartPage;

public class ShoppingCartPageSteps {
    public static void CartItemDetailStep() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        ItemDetailPage.goToCart();
        ShoppingCartPage.setItemDetails();
        softAssert.assertTrue(ShoppingCartPage.isItmNameMatchAsItemDetailsPage(),"That Item name not matched!" );
        softAssert.assertTrue(ShoppingCartPage.isItmQtyMatchAsItemDetailsPage(),"The Quantity is not matched!" );
        softAssert.assertTrue(ShoppingCartPage.isItmTotalMatchAsItemDetailsPage(),"The Total amount is not matched!");
        softAssert.assertAll();

    }
    public static void CartItemClearStep() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        ShoppingCartPage.deleteItemFromCart();
        softAssert.assertTrue(ShoppingCartPage.isItmDeleted(),"The Cart is not cleared!");

    }

}
