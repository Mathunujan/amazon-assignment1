package steps;


import org.testng.asserts.SoftAssert;
import pages.ProductListPage;

public class ProductListPageSteps {
    //ProductListPage productListPage=new ProductListPage();
    public static void FilterStep() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(ProductListPage.isProductListPageDisplayed(),"The page is not display here ") ;
        ProductListPage.selectFilterByRating("");
        ProductListPage.selectFilterByLang("English");
        softAssert.assertTrue(ProductListPage.ischeckBoxSelected(),"Language not selected");
        ProductListPage.setItemDetails();
        softAssert.assertAll();
    }

}
