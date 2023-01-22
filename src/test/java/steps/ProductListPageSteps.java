package steps;


import controllers.PageBase;
import org.testng.asserts.SoftAssert;
import pages.ProductListPage;

public class ProductListPageSteps {
    ProductListPage productListPage=new ProductListPage();
    public void FilterStep() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(ProductListPage.isProductListPageDisplayed(),"The page is not display here ") ;
        productListPage.selectFilterByRating(productListPage.dataProp.getProperty("ratingFilterSelect"));
        productListPage.selectFilterByLang(productListPage.dataProp.getProperty("languageFilterSelect"));
        softAssert.assertTrue(ProductListPage.isCheckBoxSelected(),"Language not selected");
        productListPage.setItemDetails(productListPage.dataProp.getProperty("itemSelect"));
    }

}
