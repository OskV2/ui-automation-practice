package pl.globallogic;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;
    protected String host = "http://www.automationpractice.pl";
    HomePage homePage;
    SearchResultPage resultPage;

    @BeforeMethod
    public void testSetup() {
        ChromeOptions opt = new ChromeOptions();
//        opt.addArguments("--headless");
//        opt.addArguments("-private");

        driver = new ChromeDriver(opt);

        driver.manage().window().setPosition(new Point(2000, 0));
        driver.manage().window().maximize();

        homePage = new HomePage(driver, host);
        resultPage = new SearchResultPage(driver);
    }

    @AfterMethod
    public void testCleanUp() {
        driver.quit();
    }

}
