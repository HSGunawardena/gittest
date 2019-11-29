package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.PropertyFileReader;
import utils.Tradeling;

public class BinanceMarketsHomePage {
    WebDriver driver = Tradeling.getInstance().getDriver();
    PropertyFileReader propertyFileReader = new PropertyFileReader();
    String gridETHBTCLinkElement = propertyFileReader.getProperty("BinanceMarketsHomePage",
            "grid.eth.btc.link.element");

    public BinanceETHBTCHomePage clickETHBTCLink() {
        Tradeling.getInstance().waitForElement(By.xpath(gridETHBTCLinkElement), 10);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(gridETHBTCLinkElement))).click().build().perform();
        return new BinanceETHBTCHomePage();
    }
}
