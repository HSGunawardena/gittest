package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.Tradeling;

public class BinanceHomePage {
    WebDriver driver = Tradeling.getInstance().getDriver();
    PropertyFileReader propertyFileReader = new PropertyFileReader();
    String navigationMenuMarketElement = propertyFileReader.getProperty("BinanceHomePage",
            "navigation.menu.market.element");

    public BinanceMarketsHomePage clickMarketMenu() {
        Tradeling.getInstance().waitForElement(By.linkText(navigationMenuMarketElement), 10);
        driver.findElement(By.linkText(navigationMenuMarketElement)).click();
        return new BinanceMarketsHomePage();
    }
}
