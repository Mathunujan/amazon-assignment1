package pages;

import controllers.FunctionHelper;
import controllers.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ProductListPage extends PageBase {
    static String linkText="";
    static String language="";
    private static String[] itemDetails;
    private static String itemDetails2="";
    private static boolean CategorynotExist;
    private static FunctionHelper functionHelper= new FunctionHelper();
    private static By itemlink=By.xpath("(//*[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[2]");
    private static By itemSection=By.xpath("//*[@data-index='2']");
    private static By itemPrice=By.xpath("(//*[@class='a-price-whole'])[4]");
    private static By languaeFilter=By.xpath("(//span[text()='English'])[1]");
    private static By ratingFilter=By.xpath("//*[@aria-label='4 Stars & Up']");
    private static By checkedboxCheck=By.xpath("//li[@aria-label='English']//input[@checked]");
    private static By searchresultsText=By.xpath("//*[@id='search']/span/div/h1/div/div[1]/div/div/span[3]");


    public static boolean isProductListPageDisplayed() {
 FunctionHelper.waiTillVisible(searchresultsText,5);
        return getDriver().findElement(searchresultsText).isDisplayed();
    }
    public static boolean ischeckBoxSelected() {
        try {
            getDriver().findElement(checkedboxCheck).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        return getDriver().findElement(checkedboxCheck).isDisplayed();
    }

    public static void selectFilterByLang(String text) throws Exception {
        functionHelper.scrollDown(languaeFilter);
      functionHelper.click(getDriver().findElement(languaeFilter));

    }
    public static void selectFilterByRating(String text) throws Exception {
        functionHelper.scrollDown(ratingFilter);
          FunctionHelper.waiTillClickable(ratingFilter,10);
        functionHelper.click(getDriver().findElement(ratingFilter));
    }
    public static void navigateItemDetails(String text) throws Exception {
        //FunctionHelper.waiTillClickable(itemlink,2);
        getDriver().findElement(itemlink).click();
    }

    public static void setItemDetails() throws Exception {
        //ArrayList<String> itemDetails = new ArrayList<String>();
        System.out.println("Product list page Full details:"+getDriver().findElement(itemSection).getText()+"!!!!!!!!!!");
        //To do
        itemDetails=getDriver().findElement(itemSection).getText().split("\\r?\\n");
        itemDetails[0]=getDriver().findElement(itemlink).getText();

            System.out.println("Product List Item Name1:.>>>>>>>"+itemDetails[1]);
        System.out.println("Product List Item Price:.>>>>>>>"+itemDetails[5]+"."+itemDetails[6]);



    }
    public static String getPriceDetails(String priceCat) throws Exception {
           for (int i = 0; i<itemDetails.length-1; i++){
                if (itemDetails[i].equalsIgnoreCase(priceCat)){
                    System.out.println("Product List Item Price:>>>>>>>"+itemDetails[i+1]+"."+itemDetails[i+2]);
                    return  itemDetails[i+1]+"."+itemDetails[i+2];
                }else {
                    CategorynotExist=true;
                }
            }
        return "Category '"+priceCat+"' is not matched!";
    }
    public static boolean isCategorynotExist() throws Exception {
        return CategorynotExist;
    }

    public static String getItemname() throws Exception {
        return itemDetails[0];
    }




}
