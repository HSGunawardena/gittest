package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Collections;

public class Sparta {
    private WebDriver driver;
    private static Sparta myObj;
    // public static WebDriver driver;
    utils.PropertyFileReader property = new PropertyFileReader();

    public static Sparta getInstance() {
        if (myObj == null) {
            myObj = new Sparta();
            return myObj;
        } else {
            return myObj;
        }
    }

    //get the selenium driver
    public WebDriver getDriver() {
        return driver;
    }

    //when selenium opens the browsers it will automatically set the web driver
    private void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static void setMyObj(Sparta myObj) {
        Sparta.myObj = myObj;
    }

    public void openBrowser() {
//        String chromeDriverPath = property.getProperty("config", "chrome.driver.path");
        System.setProperty("webdriver.chrome.driver", getChromeDriverFilePath());
        ChromeOptions options = new ChromeOptions();
//        This arguments are not working due to WebDriver version 3 is going to be upgraded to 4.
//        New experimental options are introduced and we will have to use those
//        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-infobars");
        options.addArguments("--headless");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches",
                Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void navigateToSeylan() {
        String url = property.getProperty("config", "seylan.url");
        driver.get(url);
    }

    public void navigateToBOC() {
        String url = property.getProperty("config", "boc.url");
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public WebElement waitForElement(By locator, int timeout) {
        WebElement element = new WebDriverWait(Sparta.getInstance().getDriver(), timeout).until
                (ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    // ToDo: This is not working at the moment. This need to be looked at.
    private String getChromeDriverFilePath() {
        String chromeDriver = property.getProperty("config", "chrome.driver.path");
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(chromeDriver).getFile());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        return file.getPath();
    }

}
