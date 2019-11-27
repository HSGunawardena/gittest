package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.Sparta;

public class Seylan {
    WebDriver driver = Sparta.getInstance().getDriver();
    PropertyFileReader propertyFileReader = new PropertyFileReader();
    String ttBuyingRateEelement = propertyFileReader.getProperty("Seylan", "seylan.tt.buying.rate");

    public String ttBuyingRate() {
        Sparta.getInstance().waitForElement(By.xpath(ttBuyingRateEelement), 10);
        String seylanBuyingRate = driver.findElement(By.xpath(ttBuyingRateEelement)).getText();
        return seylanBuyingRate;
    }
}
