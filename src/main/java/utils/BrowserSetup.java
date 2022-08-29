package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetup extends BaseDriver {

    public static String browser = LoadProp.getProperty("browser");
    private static String chrome = LoadProp.getProperty("driverPath");

    /**
     * browser property and chrome property located in /src/main/resources/GlobalData.properties
     */

    // Function to initialize WebDriver with specific browser drivers
    public WebDriver selectBrowser() {

        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", chrome);
            driver = new ChromeDriver();
        }else {
            System.out.println("Invalid browser drivers input provided");
        }
        return driver;
    }

}
