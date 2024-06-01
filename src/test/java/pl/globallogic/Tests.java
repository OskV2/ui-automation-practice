package pl.globallogic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    //  Verify successful Item Search (verification - check if first result item title is visible)
    @Test
    public void verifySuccessfulItemSearch() {
        String searchQuery = "Blouse";

        homePage.visit(host);
        homePage.search(searchQuery);

        Assert.assertTrue(resultPage.isSearchSuccessful(searchQuery));
    }

    //  Verify searching with invalid query
    @Test
    public void verifySearchingWithInvalidQuery() {}

    //  Verify empty search query processing
    @Test
    public void verifyEmptySearchQueryProcessing() {}

    //  Verify search result item sorting - by price
    @Test
    public void verifySearchResultItemSorting() {}

    //  Verify if first item from results can be added to cart from item details page
    @Test
    public void verifyIfFirstItemFromResultsCanBeAddedToCartFromItemDetailsPage() {}

    //  Verify if first item from results can be added to cart from search page
    @Test
    public void verifyIfFirstItemFromResultsCanBeAddedToCartFromSearchPage() {}

    //  Verify first item from results can be removed from the cart
    @Test
    public void verifyFirstItemFromResultsCanBeRemovedFromTheCart() {}

    //  Verify that item review is available on the items details page
    @Test
    public void verifyThatItemReviewIsAvailableOnTheItemsDetailsPage() {}

}
