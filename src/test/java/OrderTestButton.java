import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import po.MainPage;
import po.OrderPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class OrderTestButton {
    public static WebDriver driver;
    @BeforeClass
    public static void initialOrder() {

//      ChromeOptions options = new ChromeOptions();
//      options.addArguments("--remote-allow-origins=*");
//      driver = new ChromeDriver(options);
//      driver = new Augmenter().augment(driver);
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    @Test
    public void testOrderSecondButton()

    {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        driver.get(mainPage.MAIN_PAGE);
        mainPage.waitForLoadPage();
        mainPage.clickGetCookie();
        mainPage.clickOrder(1);

        assertTrue("страница заказа не загрузилась после нажатия на нижнюю кнопку 'Заказать'", orderPage.waitForOrderPage());
    }

    @AfterClass
    public static void tearDown() {
        if (driver!=null)
            driver.quit();
    }
}
