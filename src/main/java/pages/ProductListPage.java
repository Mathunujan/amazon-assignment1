package pages;

import controllers.FunctionHelper;
import controllers.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ProductListPage extends PageBase {

    private static String replaceVar;
    private static String[] itemDetails;
    private static String ItemPrice="";

    private static FunctionHelper functionHelper= new FunctionHelper();
   // private static By itemLink =By.xpath("(//*[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[2]");
    private static String itemLinkXpath ="(//*[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[%s]";
    private static String languageFilterXpath ="(//span[text()='%s'])[1]";
    //private static String ratingFilterXpath ="//*[@aria-label='4 Stars & Up']";
    private static By itemLink;
    private static By languageFilter;
    private static By ratingFilter=By.xpath("//*[@aria-label='4 Stars & Up']");
    private static By itemSection=By.xpath("//*[@data-index='2']");
    private static By checkedBoxCheck =By.xpath("//li[@aria-label='English']//input[@checked]");
    private static By searchResultsText =By.xpath("//*[@id='search']/span/div/h1/div/div[1]/div/div/span[3]");

    public static void setItemLink(String itemOrder) throws Exception {
        itemLink=By.xpath(String.format(itemLinkXpath,itemOrder));
    }
    public static void setLanguageFilter(String language) throws Exception {
        languageFilter=By.xpath(String.format(languageFilterXpath,language));
    }
    public static boolean isProductListPageDisplayed() {
 FunctionHelper.waiTillVisible(searchResultsText,5);
        return getDriver().findElement(searchResultsText).isDisplayed();
    }
    public static boolean isCheckBoxSelected() {
        try {
            getDriver().findElement(checkedBoxCheck).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        return getDriver().findElement(checkedBoxCheck).isDisplayed();
    }

    public static void selectFilterByLang(String language) throws Exception {
        setLanguageFilter(language);
        functionHelper.scrollDown(languageFilter);
      functionHelper.click(getDriver().findElement(languageFilter));

    }
    public static void selectFilterByRating(String rating) throws Exception {
        functionHelper.scrollDown(ratingFilter);
          FunctionHelper.waiTillClickable(ratingFilter,10);
        functionHelper.click(getDriver().findElement(ratingFilter));
    }
    public static void navigateItemDetails() throws Exception {
        getDriver().findElement(itemLink).click();

    }
    public static void setItemDetails(String itemOder) throws Exception {
        setItemLink(itemOder);
        System.out.println("Product list page Full details:"+getDriver().findElement(itemSection).getText()+"!!!!!!!!!!");
        itemDetails=getDriver().findElement(itemSection).getText().split("\\r?\\n");
        itemDetails[0]=getDriver().findElement(itemLink).getText();

            System.out.println("Product List Item Name1:.>>>>>>>"+itemDetails[1]);
        System.out.println("Product List 5 and 6 Index:.>>>>>>>"+itemDetails[5]+"."+itemDetails[6]);



    }
    public static String getPrice(String priceCat) throws Exception {
           for (int i = 0; i<itemDetails.length-1; i++){
                if (itemDetails[i].equalsIgnoreCase(priceCat)){
                    System.out.println("Product List Item Price:>>>>>>>"+itemDetails[i+1].substring(1)+"."+itemDetails[i+2]);
                    ItemPrice=itemDetails[i+1].substring(1)+"."+itemDetails[i+2];
                    return  ItemPrice;
                }
            }
        return "Category '"+priceCat+"' is not matched!";
    }
    public static String getItemName() throws Exception {
        return itemDetails[0];
    }




}
