package pages;

import controllers.FunctionHelper;
import controllers.PageBase;
import org.openqa.selenium.By;

public class ItemDetailPage extends PageBase {
    private static String linkText="";
    private static String language="";
    private static String replaceVar="";

    private static int itemQtyDisplay;
    private static int itemQtySelect;
    private static double itemPrice;
    private static FunctionHelper functionHelper= new FunctionHelper();
    private static By itemPriceLabel =By.id("price");
    private static By allItemDetails2=By.xpath("//*[@id='centerCol']");
    private static By productTitle=By.id("productTitle");
    private static By qtyDropDown=By.id("quantity");
    private static By  qtyDropdownPrompt=By.xpath("(//*[@class='a-dropdown-prompt'])[1]");
    private static By addToCartButton=By.id("add-to-cart-button");

    private static By goToCartButton=By.xpath("//*[@data-csa-c-content-id='sw-gtc_CONTENT']");


    public static boolean isProductListPageDisplayed() {
        return true;
    }
    public static boolean isPriceMatchAsProdList() throws Exception {
        setItemDetails();
        System.out.println("ProductList ItemPrice-Checking is price Match with ItemDetailsPage>>> "+ProductListPage.getPrice("Paperback"));
        FunctionHelper.waiTillVisible(itemPriceLabel,10);
        System.out.println("ItemDetails ItemPrice-Checking is price Match with ItemDetailsPage>>> "+getItemPrice());
    if (Double.parseDouble(ProductListPage.getPrice("Paperback"))==getItemPrice()){
        return true;
    }
        return false;
    }
    public static boolean isItmNameMatchAsProdList() throws Exception {
        setItemDetails();
        return (ProductListPage.getItemName().equalsIgnoreCase(getDriver().findElement(productTitle).getText()));
    }
    public static void setItemDetails() throws Exception {
        System.out.println("itemPrice-PriceLabel: "+getDriver().findElement(itemPriceLabel).getText());
        itemPrice=Double.parseDouble(getDriver().findElement(itemPriceLabel).getText().substring(1));
        itemQtyDisplay =Integer.parseInt(getDriver().findElement(qtyDropdownPrompt).getText()) ;
            System.out.println("Item Detail page Price:>>>>>>>>>>>>>>>>"+itemPrice);
    }
    public static double getItemPrice() throws Exception {
        return itemPrice;
    }
    public static void selectQTY(String qty) throws Exception {
        itemQtySelect=Integer.parseInt(qty);
        functionHelper.dropDownSelectByText(getDriver().findElement(qtyDropDown),qty);
    }
    public static int getItemQtyDisplay() throws Exception {
        return itemQtyDisplay;
    }
    public static boolean isQtySelect() throws Exception {
        return itemQtyDisplay==itemQtySelect;
    }
    public static void addToCart() throws Exception {
        functionHelper.click(getDriver().findElement(addToCartButton));
    }

    public static void goToCart() throws Exception {
        functionHelper.click(getDriver().findElement(goToCartButton));
    }

}
