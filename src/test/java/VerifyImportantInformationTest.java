import example.BinanceHomePage;
import example.BinanceMarketsHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Tradeling;

public class VerifyImportantInformationTest {
    WebDriver driver;
    BinanceHomePage binanceHomePage;
    BinanceMarketsHomePage binanceMarketsHomePage;

    @BeforeMethod
    public void setUp() {
        Tradeling.getInstance().openBrowser();
        driver = Tradeling.getInstance().getDriver();
        Tradeling.getInstance().navigateToUrl();
        binanceHomePage = new BinanceHomePage();
        binanceMarketsHomePage = binanceHomePage.clickMarketMenu();
        binanceMarketsHomePage.clickETHBTCLink();
    }

    @Test (priority = 1, groups = {"smoke","reg"})
    public void verifyTraidingGrid() {
    }


    @AfterMethod
    public void tearDown() {
//        Tradeling.getInstance().closeBrowser();
    }
}
