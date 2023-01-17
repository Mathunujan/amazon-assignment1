package steps;


import controllers.FunctionHelper;
import org.testng.Assert;
import pages.Dashboard;
import pages.ProductListPage;

import java.util.ArrayList;

public class DashBoardSteps {

    public static void SearchItemsSteps() throws Exception {
        Assert.assertTrue(Dashboard.isDashboardPageDisplayed(),"That title is not display here ") ;
        Dashboard.SelectSearchCategory("Books");
        Dashboard.searchTextBox("Automation");
        Dashboard.clickSearchIcon();
        Dashboard.staticWait(2);

    }



}
