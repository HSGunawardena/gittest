import example.BOC;
import example.Seylan;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Sparta;

public class RateTest {
    WebDriver driver;
    Seylan seylan;
    BOC boc;

    @BeforeMethod
    public void setUp() {
        Sparta.getInstance().openBrowser();
        driver = Sparta.getInstance().getDriver();
    }

    @Test
    public void testSeylanRate() {
        seylan = new Seylan();
        Sparta.getInstance().navigateToSeylan();
        String rate = seylan.ttBuyingRate();
        System.out.println(rate);
    }

//    @Test
//    public void testBOCRate() {
//        boc = new BOC();
//        Sparta.getInstance().navigateToBOC();
//        String rate = boc.ttBuyingRate();
//        System.out.println(rate);
//    }

    @AfterMethod
    public void tearDown() {
        Sparta.getInstance().closeBrowser();
    }
}
