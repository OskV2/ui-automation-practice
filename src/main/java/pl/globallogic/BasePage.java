package pl.globallogic;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected int timeout = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void visit(String url) {
//        logger.info("Navigating to '{}'", url);
        driver.get(url);
    }

    public WebElement findElementBy(By locator) {
//        logger.info("Looking for element with locator {}", locator);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
    }

    protected void type(By locator, String text) {
//        logger.info("Typing '{}' to element located {}", text, locator);
        WebElement target = findElementBy(locator);
        target.clear();
        target.sendKeys(text);
    }

    protected void click(By locator) {
        findElementBy(locator).click();
    }

    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
//            logger.warn("Thread interrupted while pausing!");
            throw new RuntimeException(e);
        }
    }

    protected boolean isDisplayed(By locator) {
//        logger.info("Verify visibility of element located by {}", locator);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
//            logger.warn("Timeout of {} wait for {}", timeout, locator);
            return false;
        }
        return true;
    }
}
