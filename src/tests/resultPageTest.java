package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.SearchPage;

import java.util.List;

public class resultPageTest extends BaseTest {

    String search_Text = "lexisnexis";

    @Test(priority = 0)
    public void searchTest_sendkeys() {
        SearchPage searchPage = new SearchPage(driver);
        List<WebElement> elementsRoot = searchPage.results_page_list(search_Text);

        //Assert
        searchPage.keyword_search(elementsRoot, search_Text);
    }

    @Test(priority = 1)
    public void searchTest_mouse() {
        SearchPage searchPage = new SearchPage(driver);
        List<WebElement> elementsRoot = searchPage.results_page_list(search_Text, "Gaeilge");

        //Assert
        searchPage.keyword_search(elementsRoot, search_Text);
    }
}