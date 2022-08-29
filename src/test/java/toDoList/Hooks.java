package toDoList;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BrowserSetup;
import utils.LoadProp;

import java.time.Duration;

public class Hooks extends BrowserSetup {

    private static int WAIT_SEC = Integer.parseInt(LoadProp.getProperty("timeoutDuration"));

    @Before
    public void initializeBrowser() {

        driver= selectBrowser();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_SEC));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_SEC));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(WAIT_SEC));

    }

    @After
    public void quitBrowser() {
        driver.close();
        driver.quit();
    }
}

