package pl.globallogic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final String host;
    private final By searchFieldLocator = By.id("search_query_top");

    public HomePage(WebDriver driver, String host) {
        super(driver);
        this.host = host;
    }

    public void search(String searchQuery) {

    }
}
