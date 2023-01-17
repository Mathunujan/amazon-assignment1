package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import lombok.Getter;


import java.awt.*;
import java.io.File;

public class Constants {
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String UBUNTU = "ubuntu";
    public static final String WINDOWS = "windows";
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static int DEFAULT_EXPLICIT_TIME_OUT = 20;
    public static Robot re;
    public static Alert al;
    public static Actions ac;
    public static Select se;
    public static final String homePageTitle = "Amazon.com. Spend less. Smile more.";
    @Getter
    private static final String configJsonPath = PROJECT_PATH + File.separator + "src/main/resources" + File.separator + "config" + File.separator + "config.json";
}
