package pl.globallogic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchResultPage extends BasePage {

    private final By firstItemInResultNameLocator = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a");
    private final By alertWarningLocator = By.className("alert-warning");
    private final By selectElementLocator = By.id("selectProductSort");
    private final By firstItemLocator = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[1]/div/a[1]/img");
    private final By firstElementDetailsLinkLocator = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/div[2]/a");
    private final By firstItemPriceLocator = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[1]/span");
    private final By secondItemPriceLocator = By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[1]/span[2]");
    private final By thirdItemPriceLocator = By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/div[1]/span");

    String INVALID_SEARCH_QUERY_ERROR = "No results were found for your search";
    String EMPTY_SEARCH_QUERY_ERROR = "Please enter a search keyword";

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchSuccessful(String searchQuery) {
        return findElementBy(firstItemInResultNameLocator).getText().toLowerCase().contains(searchQuery.toLowerCase());
    }

    public boolean isSearchQueryInvalid() {
        return findElementBy(alertWarningLocator).getText().contains(INVALID_SEARCH_QUERY_ERROR);
    }

    public boolean isSearchQueryEmpty() {
        return findElementBy(alertWarningLocator).getText().equals(EMPTY_SEARCH_QUERY_ERROR);
    }

    public void selectSortingOption(int number) {
        WebElement selectElement = findElementBy(selectElementLocator);
        Select select = new Select(selectElement);

        List<WebElement> options = select.getOptions();
        select.selectByIndex(number);
    }

    public boolean isSearchResultSortedProperly() {
        int firstPrice = Integer.valueOf(findElementBy(firstItemPriceLocator).getText().substring(1));
        int secondPrice = Integer.valueOf(findElementBy(secondItemPriceLocator).getText().substring(1));
        int thirdPrice = Integer.valueOf(findElementBy(thirdItemPriceLocator).getText().substring(1));

        ArrayList<Integer> prices = new ArrayList<>();
        prices.add(firstPrice);
        prices.add(secondPrice);
        prices.add(thirdPrice);

        ArrayList<Integer> sortedPrices = (ArrayList)prices.clone();
        Collections.sort(sortedPrices);

        return prices.equals(sortedPrices);
    }

    public void goToFirstProductDetailsPage() {
        Actions actions = new Actions(driver);
        WebElement firstProduct = findElementBy(firstItemLocator);

        actions.moveToElement(firstProduct).perform();
        pause(1);
        click(firstElementDetailsLinkLocator);
        pause(1);
    }
}