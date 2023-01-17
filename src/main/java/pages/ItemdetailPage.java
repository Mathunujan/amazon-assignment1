package pages;

import controllers.FunctionHelper;
import controllers.PageBase;
import org.openqa.selenium.By;

public class ItemdetailPage extends PageBase {
    private static String linkText="";
    private static String language="";

    private static String itemQty;
    private static String[] itemPriceDetails;
    private static FunctionHelper functionHelper= new FunctionHelper();
    private static By itemPriceSection =By.xpath("//*[@class='a-unordered-list a-nostyle a-button-list a-horizontal']");
    private static By allItemDetails2=By.xpath("//*[@id='centerCol']");
    private static By productTitle=By.id("productTitle");
    private static By qtyDropDown=By.id("quantity");
    private static By  qtyDropdownPrompt=By.xpath("(//*[@class='a-dropdown-prompt'])[1]");
    private static By addToCartButton=By.id("add-to-cart-button");

    private static By goToCartButton=By.xpath("//*[@data-csa-c-content-id='sw-gtc_CONTENT']");






    public static boolean isProductListPageDisplayed() {

        return true;
    }
    public static boolean isPricematchAsProdList() throws Exception {
        setItemDetails();
        System.out.println("Check 11111"+ProductListPage.getPriceDetails("price"));
        FunctionHelper.waiTillVisible(itemPriceSection,10);
 String allDetails= getDriver().findElement(itemPriceSection).getText();
 System.out.println("ItemDetails page All item details:>>>>>>>> "+allDetails);

    if (ProductListPage.getPriceDetails("Paperback").equalsIgnoreCase(getPriceDetails("Paperback"))){
        return true;
    }
        return false;
    }
    public static boolean isItmNameMatchAsProdList() throws Exception {
        return (ProductListPage.getItemname().equalsIgnoreCase(getDriver().findElement(productTitle).getText()));
    }
    public static void setItemDetails() throws Exception {
        //ArrayList<String> itemDetails = new ArrayList<String>();
        System.out.println(getDriver().findElement(itemPriceSection).getText());
        //To do
        itemPriceDetails=getDriver().findElement(itemPriceSection).getText().split("\\r?\\n");
        itemQty=getDriver().findElement(qtyDropdownPrompt).getText();

            System.out.println("Item Detail page Price:>>>>>>>>>>>>>>>>"+itemPriceDetails[4]);
            System.out.println("Item Details page-All Item Details:>>>>>>>>>"+itemPriceDetails.toString());
            System.out.println("Item Details page Item Price:.>>>>>>>"+itemPriceDetails.toString());

    }

    public static String getPriceDetails(String priceCat) throws Exception {
         for (int i = 0; i<itemPriceDetails.length-1; i++){
                if (itemPriceDetails[i].equalsIgnoreCase(priceCat)){
                    return itemPriceDetails[i+1];
                }
            }
        return "Category '"+priceCat+"' is not matched!";
    }

    public static void selectQTY(String qty) throws Exception {
        functionHelper.dropDownSelectByText(getDriver().findElement(qtyDropDown),qty);
    }
    public static String getItemQty() throws Exception {

        return itemQty;
    }
    public static void addToCart() throws Exception {
        functionHelper.click(getDriver().findElement(addToCartButton));
    }

    public static void goToCart() throws Exception {
        functionHelper.click(getDriver().findElement(goToCartButton));
    }
    public static boolean isQtySelect() throws Exception {
        return getDriver().findElement(qtyDropdownPrompt).getText().equalsIgnoreCase(null);
    }
}
