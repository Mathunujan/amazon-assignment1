package pages;

import controllers.FunctionHelper;
import controllers.PageBase;
import org.openqa.selenium.By;

public class ShoppingCartPage extends PageBase {
    static String linkText="";
    static String language="";
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
        System.out.println("Item Details QTY>>>> "+ItemdetailPage.getItemQtyDisplay());
            System.out.println("ShoppingCart QTY>>>> "+getItemQty());
            return ItemdetailPage.getItemQtyDisplay()==getItemQty();
    }
    public static void setItemDetails() throws Exception {
        System.out.println("Shopping Cart-Item Name>>>>>>>>>>>>"+getDriver().findElement(itemLink).getText());
        itemName=getDriver().findElement(itemLink).getText();
        itemQty=Integer.parseInt(getDriver().findElement(qtyDropdownPrompt).getText());
        System.out.println("Item Total at SetItemDetails:>>>"+getDriver().findElement(subTotalLabel).getText().substring(2));
        itemTotal=Double.parseDouble(getDriver().findElement(subTotalLabel).getText().replaceAll("\\s","").substring(1));
    }
    public static String getItemName() throws Exception {
        return itemName;
    }

    public static int getItemQty() throws Exception {
        return itemQty;
    }
        public static double getItemSubTotal() throws Exception {
            return itemTotal;
    }
    public static boolean isItmTotalMatchAsItemDetailsPage() throws Exception {
        double itemDetailsTotal=ItemdetailPage.getItemPrice()*ItemdetailPage.getItemQtyDisplay();
        double CartDetailsTotal=getItemSubTotal();
        System.out.println("#Item Detailsotal: "+itemDetailsTotal+",  #CartDetailsTotal: "+CartDetailsTotal);
        return itemDetailsTotal==CartDetailsTotal;
    }
    public static void deleteItemFromCart() throws Exception {
        FunctionHelper.waiTillClickable(deleteCTA,5);
        functionHelper.doubleClick(getDriver().findElement(deleteCTA));
    }
    public static boolean isItmDeleted() throws Exception {
        staticWait(5);
    String subTotalLabelText=getDriver().findElement(subTtlAmntTLabelUnderItm).getText().replaceAll("\\s","");
    System.out.println("Sub total labelText after clear the cart: "+subTotalLabelText);
        return subTotalLabelText.equalsIgnoreCase("$0.00");
    }


}
