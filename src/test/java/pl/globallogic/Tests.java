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
    public void verifySearchingWithInvalidQuery() {
        String searchQuery = "asd";

        homePage.visit(host);
        homePage.search(searchQuery);

        Assert.assertTrue(resultPage.isSearchQueryInvalid(searchQuery));
    }

    //  Verify empty search query processing
    @Test
    public void verifyEmptySearchQueryProcessing() {
        String searchQuery = "";

        homePage.visit(host);
        homePage.search(searchQuery);

        Assert.assertTrue(resultPage.isSearchQueryEmpty());
    }

    //  Verify search result item sorting - by price
    @Test
    public void verifySearchResultItemSorting() {
        String searchQuery = "Shoes";

        homePage.visit(host);
        homePage.search(searchQuery);
        resultPage.selectSortingOption(1); //  Passed number is index of chosen option - this option is second option element in DOM in this select
        //  resultPage.selectSortingOption("price:asc"); It can also be made with value of option instead of index

        Assert.assertTrue(resultPage.isSearchResultSortedProperly());
    }

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
