package pages;

import controllers.FunctionHelper;
import controllers.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.awt.*;

public class ProductListPage extends PageBase {
    private static final Logger LOGGER = Logger.getLogger(ProductListPage.class);
    private  String replaceVar;
    private static String[] itemDetails;
    private static String ItemPrice="";

    private static FunctionHelper functionHelper= new FunctionHelper();
    private static String itemLinkXpath ="(//*[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[%s]";
    private static String languageFilterXpath ="(//span[text()='%s'])[1]";
    private static String ratingFilterXpath ="//*[@aria-label='%s']";
    private static String itemSectionXpath ="//*[@data-index='%s']";
    private static String languageCheckBoxCheckedXpath ="//li[@aria-label='English']//input[@checked]";
    private static String searchResultsTextXpath ="//*[@id='search']/span/div/h1/div/div[1]/div/div/span[3]";
    private static By itemLink;
    private static By languageFilter;
    private static By ratingFilter;
    private static By itemSection;
    private static By languageCheckBoxChecked;
    private static By searchResultsText =By.xpath("//*[@id='search']/span/div/h1/div/div[1]/div/div/span[3]");


    public static boolean isProductListPageDisplayed() {
 FunctionHelper.waiTillVisible(searchResultsText,5);
        return getDriver().findElement(searchResultsText).isDisplayed();
    }
    public static boolean isCheckBoxSelected() {
        try {
            getDriver().findElement(languageCheckBoxChecked).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        return getDriver().findElement(languageCheckBoxChecked).isDisplayed();
    }
    public void selectFilterByLang(String language) throws Exception {
        languageFilter=By.xpath(String.format(languageFilterXpath,language));
        languageCheckBoxChecked=By.xpath(String.format(ratingFilterXpath,language));
        functionHelper.scrollDown(languageFilter);
      functionHelper.click(getDriver().findElement(languageFilter));

    }
    public void selectFilterByRating(String rating) throws Exception {
        ratingFilter=By.xpath(String.format(ratingFilterXpath,rating));
        functionHelper.scrollDown(ratingFilter);
          FunctionHelper.waiTillClickable(ratingFilter,10);
        functionHelper.click(getDriver().findElement(ratingFilter));
    }
    public static void navigateItemDetails(String itemOrder) throws Exception {
        itemLink=By.xpath(String.format(itemLinkXpath,itemOrder));
        getDriver().findElement(itemLink).click();
    }
    public void setItemDetails(String itemOrder) throws Exception {
        itemLink=By.xpath(String.format(itemLinkXpath,itemOrder));
        itemSection=By.xpath(String.format(itemSectionXpath,itemOrder));
        //System.out.println("Product list page Full details:"+getDriver().findElement(itemSection).getText()+"!!!!!!!!!!");
        itemDetails=getDriver().findElement(itemSection).getText().split("\\r?\\n");
        itemDetails[0]=getDriver().findElement(itemLink).getText();
        //System.out.println("Getting Product List Item Name1:.>>>>>>>"+itemDetails[1]);
        //System.out.println("Product List 5th and 6th Index:.>>>>>>>"+itemDetails[5]+"."+itemDetails[6]);
    }
    public static String getPrice(String priceCat) throws Exception {
           for (int i = 0; i<itemDetails.length-1; i++){
                if (itemDetails[i].equalsIgnoreCase(priceCat)){
                    LOGGER.info("Getting Product List Item Price:"+itemDetails[i+1].substring(1)+"."+itemDetails[i+2]);
                    ItemPrice=itemDetails[i+1].substring(1)+"."+itemDetails[i+2];
                    return  ItemPrice;
                }
            }
        return "Category '"+priceCat+"' is not matched!";
    }
    public static String getItemName() throws Exception {
        LOGGER.info("Getting Product List Item Name:"+itemDetails[0]);
        return itemDetails[0];
    }




}
