package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.PropertyFileReader;
import utils.Tradeling;

public class BinanceHomePage {
    WebDriver driver = Tradeling.getInstance().getDriver();
    PropertyFileReader propertyFileReader = new PropertyFileReader();
    String navigationMenuMarketElement = propertyFileReader.getProperty("BinanceHomePage",
            "navigation.menu.market.element");

    public BinanceMarketsHomePage clickMarketMenu() {
        Tradeling.getInstance().waitForElement(By.linkText(navigationMenuMarketElement), 10);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.linkText(navigationMenuMarketElement))).click().build().perform();
        return new BinanceMarketsHomePage();
    }
}
