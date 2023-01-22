package pages;

import controllers.FunctionHelper;
import controllers.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ShoppingCartPage extends PageBase {
    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(ItemDetailPage.class);
    private static String itemName="";
    private static int itemQty;
    private static double itemTotal;
    private static String[] itemDetails=new String[5];
    private static FunctionHelper functionHelper= new FunctionHelper();
    private static By itemLink =By.xpath("//*[@class='a-size-base-plus a-color-base sc-product-title sc-grid-item-product-title']");
    private static By  qtyDropdownPrompt=By.xpath("//*[@class='a-dropdown-prompt']");
    private static By  subTtlAmntTLabelUnderItm=By.id("sc-subtotal-amount-activecart");
    private static By  deleteCTA=By.xpath(" //*[@value='Delete']");
    private static By  subTotalLabel=By.id("sc-subtotal-amount-buybox");

    public static boolean isProductListPageDisplayed() {
 FunctionHelper.waiTillVisible(itemLink,5);
        return getDriver().findElement(itemLink).isDisplayed();
    }
    public static boolean isItmNameMatchAsItemDetailsPage() throws Exception {
        if (ProductListPage.getItemName().equalsIgnoreCase(getItemName())) {
            return true;
        }
        return false;
    }
        public static boolean isItmQtyMatchAsItemDetailsPage() throws Exception {
        //System.out.println("Item Details QTY>>>> "+ ItemDetailPage.getItemQtyDisplay());
            //System.out.println("ShoppingCart QTY>>>> "+getItemQty());
            return ItemDetailPage.getItemQtyDisplay()==getItemQty();
    }
    public static void setItemDetails() throws Exception {
        System.out.println("Shopping Cart-Item Name>>>>>>>>>>>>"+getDriver().findElement(itemLink).getText());
        itemName=getDriver().findElement(itemLink).getText();
        itemQty=Integer.parseInt(getDriver().findElement(qtyDropdownPrompt).getText());
        System.out.println("Item Total at SetItemDetails:>>>"+getDriver().findElement(subTotalLabel).getText().substring(2));
        itemTotal=Double.parseDouble(getDriver().findElement(subTotalLabel).getText().replaceAll("\\s","").substring(1));
    }
    public static String getItemName() throws Exception {
        LOGGER.info("Getting shopping cart page Item name:"+ itemName);
        return itemName;
    }

    public static int getItemQty() throws Exception {
        LOGGER.info("Getting shopping cart page Item quantity:"+ itemQty);
        return itemQty;
    }
        public static double getItemSubTotal() throws Exception {
            LOGGER.info("Getting shopping cart page Item subtotal:"+ itemTotal);
            return itemTotal;
    }
    public static boolean isItmTotalMatchAsItemDetailsPage() throws Exception {
        double itemDetailsTotal= ItemDetailPage.getItemPrice()* ItemDetailPage.getItemQtyDisplay();
        double CartDetailsTotal=getItemSubTotal();
        //System.out.println("#Item DetailsTotal: "+itemDetailsTotal+",  #CartDetailsTotal: "+CartDetailsTotal);
        return itemDetailsTotal==CartDetailsTotal;
    }
    public static void deleteItemFromCart() throws Exception {
        FunctionHelper.waiTillClickable(deleteCTA,5);
        functionHelper.doubleClick(getDriver().findElement(deleteCTA));
    }
    public static boolean isItmDeleted() throws Exception {
        FunctionHelper.staticWait(5);
    String subTotalLabelText=getDriver().findElement(subTtlAmntTLabelUnderItm).getText().replaceAll("\\s","");
    LOGGER.info("Sub total labelText after clear the cart: "+subTotalLabelText);
        return subTotalLabelText.equalsIgnoreCase("$0.00");
    }


}
