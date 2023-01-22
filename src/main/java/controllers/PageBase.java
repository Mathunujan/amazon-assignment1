package controllers;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utils.Constants;
import utils.configloader.JsonUtils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

// PageBase.java Class Created by mathunujan on 31/03/2020


public class PageBase {
    private static final Logger LOGGER = Logger.getLogger(PageBase.class);
    public SoftAssert softAssert;
    public Properties dataProp;

    public PageBase(){
        dataProp =new Properties();
        File dataPropFile= new File(System.getProperty("user.dir")+"\\src\\main\\resources\\testdata\\testdata.properties");
        try {
            FileInputStream dataF= new FileInputStream(dataPropFile);
            dataProp.load(dataF);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static WebDriver driver;

    private static String baseUrl;

    static {
        try {
            baseUrl = JsonUtils.getValue("url");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String webDriverLocation = "src"+ File.separator+"main"+File.separator+"resources"+File.separator+"drivers"+File.separator;
    protected static String osType;

    static {
        try {
            osType = System.getProperty("os.type", JsonUtils.getValue("OSType"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected static String driverType;

    static {
        try {
            driverType = System.getProperty("browser.type", JsonUtils.getValue("browserType"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Initialize webdriver, set driver path and maximize chrome browser window
     */
    public static void initiateDriver() throws MalformedURLException {
        FunctionHelper.staticWait(1);
        switch (driverType) {
            case Constants.CHROME:
                if(osType.equals(Constants.UBUNTU))
                    System.setProperty("webdriver.chrome.driver", webDriverLocation + "chromedriver");
                else
                    System.setProperty("webdriver.chrome.driver", webDriverLocation + "chromedriver.exe");

                driver = new ChromeDriver();
                break;
            case Constants.FIREFOX:
                if(osType.equals(Constants.UBUNTU))
                    System.setProperty("webdriver.gecko.driver", webDriverLocation + "geckodriver");
                else
                    System.setProperty("webdriver.gecko.driver", webDriverLocation + "geckodriver.exe");



                driver = new FirefoxDriver();
                break;
        }
        getDriver().manage().window().maximize();
        getDriver().get(baseUrl);

        LOGGER.info(" WebsiteURL:"+baseUrl);
        LOGGER.info(" Chrome Type :"+driverType);
        LOGGER.info(" Os Type :"+osType);

    }

    /**
     * Get web driver instance
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Close web driver instances
     */
    public static void closeDriver() {
        getDriver().quit();
       FunctionHelper.staticWait(1);
    }



// get screenshort
    public static String getScreenshot() {
        File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/src/test/resources//screenshots/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);

        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
