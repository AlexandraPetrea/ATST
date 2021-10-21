package atstUIAutomation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends PageObject {

    @FindBy(className = "page-title")
    private WebElementFacade searchTermHeading;


    public String get_search_results_page_term(){
        return searchTermHeading.getText();
    }


    @FindBy(className="current")
    private WebElementFacade currentPage;
    @FindBy(className="next")
    private WebElementFacade nextPage;
    @FindBy(className="previous")
    private WebElementFacade previousPage;

    public String get_search_results_page(){
        return currentPage.getText();
    }

    public void go_to_next_page(){
        nextPage.waitUntilClickable().click();
    }
    public void go_to_previous_page(){
        previousPage.waitUntilClickable().click();
    }

}
