package pages;

import controllers.FunctionHelper;
import controllers.PageBase;
import org.openqa.selenium.By;
import utils.Constants;

import java.util.ArrayList;

public class Dashboard extends PageBase {
    static String linkText="";
    private static FunctionHelper functionHelper= new FunctionHelper();
    private static By amazonLogo=By.id("nav-logo-sprites");
    private static By searchDropdownBox=By.id("searchDropdownBox");
    private static By searchTextBox=By.id("twotabsearchtextbox");
    private static By searchIcon=By.id("nav-search-submit-button");

    public static boolean isDashboardPageDisplayed() {
        return getDriver().getTitle().equalsIgnoreCase(Constants.homePageTitle);
    }
    public static void SelectSearchCategory(String category) throws Exception {
        functionHelper.dropDownSelectByText(getDriver().findElement(searchDropdownBox),category);

    }
    public static void searchTextBox(String value) throws Exception {
        functionHelper.sendKeys(getDriver(),searchTextBox,value);
    }

    public static void clickSearchIcon() throws Exception {
        functionHelper.click(getDriver().findElement(searchIcon));
    }




}
