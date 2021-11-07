package atstUIAutomation.features.search;

import atstUIAutomation.steps.serenity.HeaderSteps;
import atstUIAutomation.steps.serenity.SearchProductSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchProductTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    SearchProductSteps rnSteps;


    @Steps
    HeaderSteps headerSteps;


    @Test
    public void searchForPants(){
        rnSteps.navigateToMainPage();
        rnSteps.searchForAProduct("pants");
        rnSteps.getNumberOfProducts(4);
    }

    @Test
    public void searchForSkirts(){
        rnSteps.navigateToMainPage();
        rnSteps.searchForAProduct("skirt");
        rnSteps.getNumberOfProducts(2);
    }

    @Test
    public void searchForNPants(){
        rnSteps.navigateToMainPage();
        rnSteps.searchForAProduct("pants");
        rnSteps.getNProduct(2);
    }

    @Test
    public void check_navigation_arrows_on_first_page(){
        rnSteps.navigateToMainPage();
        headerSteps.search_product("a");
        headerSteps.check_navigation_arrows_on_first_page();
    }


    @Test
    public void check_next_on_search(){
        rnSteps.navigateToMainPage();
        headerSteps.search_product("a");
        headerSteps.go_to_next_page_from_search("1", "1-12 of 84", "2", "13-24 of 84");
        headerSteps.go_to_next_page_from_search("2", "13-24 of 84", "3", "25-36 of 84");
    }

    @Test
    public void check_previous_on_search() {
        rnSteps.navigateToMainPage();
        headerSteps.search_product("a");
        headerSteps.go_to_next_page_from_search("1", "1-12 of 84", "2", "13-24 of 84");
        headerSteps.go_to_next_page_from_search("2", "13-24 of 84", "3", "25-36 of 84");
        headerSteps.go_to_previous_page_from_search("3", "25-36 of 84", "2", "13-24 of 84");
    }

    @Test
    public void scroll_search_results(){
        rnSteps.navigateToMainPage();
        headerSteps.search_product("a");
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
