package pl.globallogic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailsPage extends BasePage {

    private final By firstColorLocator = By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/div/fieldset[2]/div/ul/li[1]/a");
    private final By addToCartButtonLocator = By.xpath("//*[@id=\"add_to_cart\"]/button");
    private final By proceedToCheckoutButtonLocator = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");

    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public void chooseColor() {
        click(firstColorLocator);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
        pause(1);
    }

    public void goToCartAfterAddingToCart() {
        click(proceedToCheckoutButtonLocator);
    }

}
