package pl.globallogic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By firstItemInCartNameLocator = By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/p/a");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstItemInCartName() {
        return findElementBy(firstItemInCartNameLocator).getText();
    }

}
