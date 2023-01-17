package pages;

import controllers.FunctionHelper;
import controllers.PageBase;
import org.openqa.selenium.By;

public class ShoppingCartPage extends PageBase {
    static String linkText="";
    static String language="";
    private static String[] itemDetails=new String[5];
    private static FunctionHelper functionHelper= new FunctionHelper();
    private static By itemlink=By.xpath("//*[@class='a-size-base-plus a-color-base sc-product-title sc-grid-item-product-title']");
    private static By  qtyDropdownPrompt=By.xpath("//*[@class='a-dropdown-prompt']");
    private static By  subTotalAmount=By.id("sc-subtotal-amount-buybox");


    public static boolean isProductListPageDisplayed() {
 FunctionHelper.waiTillVisible(itemlink,5);
        return getDriver().findElement(itemlink).isDisplayed();
    }


    public static boolean isCategorynotExist() throws Exception {
        return true;
    }

    public static boolean isItmNameMatchAsItemDetailsPage() throws Exception {
        if (ProductListPage.getItemname().equalsIgnoreCase(getItemname())) {
            return true;
        }
        return false;
    }
        public static boolean isItmQtyMatchAsItemDetailsPage() throws Exception {
        System.out.println("Item Details QTY>>>> "+ItemdetailPage.getItemQty());
            System.out.println("Shopping QTY>>>> "+getItemQty());
            return ItemdetailPage.getItemQty().equalsIgnoreCase(getItemQty());
    }
    public static void setItemDetails() throws Exception {
        System.out.println("Shopping Cart-Item Name>>>>>>>>>>>>"+getDriver().findElement(itemlink).getText());
        itemDetails[0]=getDriver().findElement(itemlink).getText();
        itemDetails[1]=getDriver().findElement(qtyDropdownPrompt).getText();
        itemDetails[2]=getDriver().findElement(subTotalAmount).getText();
    }
    public static String getItemname() throws Exception {
        return itemDetails[0];
    }

    public static String getItemQty() throws Exception {
        return itemDetails[1];
    }
        public static String getItemSubTotal() throws Exception {
            return itemDetails[2];
    }
    public static boolean isItmTotalMatchAsItemDetailsPage() throws Exception {
        if (1==0){}
        double itemDetailsTotal=Integer.parseInt(ItemdetailPage.getItemQty())*Integer.parseInt(ItemdetailPage.getPriceDetails("Paperback").substring(1));
        double CartDetailsTotal=Integer.parseInt(getItemSubTotal());

        return itemDetailsTotal==CartDetailsTotal;
    }



}
