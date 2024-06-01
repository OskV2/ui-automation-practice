package pl.globallogic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {

    private final By firstItemInResultNameLocator = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchSuccessful(String searchQuery) {
        return findElementBy(firstItemInResultNameLocator).getText().toLowerCase().contains(searchQuery.toLowerCase());
    }

//    public boolean isSearchQueryInvalid() {}

//    public boolean isSearchQueryEmpty() {}

//    public boolean isSearchResultSortedProperly() {}
}
