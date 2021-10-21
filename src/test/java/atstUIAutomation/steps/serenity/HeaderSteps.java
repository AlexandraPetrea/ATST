package atstUIAutomation.steps.serenity;

import atstUIAutomation.pages.GlobalNavigationPage;
import atstUIAutomation.pages.HeaderPage;
import atstUIAutomation.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;
import org.jruby.RubyProcess;
import org.junit.Assert;
import org.springframework.core.annotation.Order;

public class HeaderSteps {

    HeaderPage headerPage;
    GlobalNavigationPage navigationPage;
    SearchResultsPage searchResultsPage;

    @Step
    public void global_header_elements_should_be_visible(){
        Assert.assertEquals(true, headerPage.my_account_is_visible());
        Assert.assertEquals(true, headerPage.my_cart_is_visible());
    }

    @Step
    public void global_navigation_elements_should_be_visible(){
        Assert.assertEquals(true,navigationPage.products_link_is_visible());
    }


    @Step
    public void search_product(String productName){
            headerPage.type_keyword(productName);
            headerPage.search();
            Assert.assertEquals("SEARCH RESULTS FOR '" + productName.toUpperCase()+"'", searchResultsPage.get_search_results_page_term().toUpperCase() );
    }

    @Step
    public void go_to_next_page_from_search(String firstPage, String secondPage) {
        Assert.assertEquals(firstPage, searchResultsPage.get_search_results_page());
        searchResultsPage.go_to_next_page();
        Assert.assertEquals(secondPage, searchResultsPage.get_search_results_page());
    }
    @Step
    public void go_to_previous_page_from_search(String firstPage, String secondPage) {
        Assert.assertEquals(firstPage, searchResultsPage.get_search_results_page());
        searchResultsPage.go_to_previous_page();
        Assert.assertEquals(secondPage, searchResultsPage.get_search_results_page());
    }

    @Step
    public void navigate_to_shopping_cart(){
        headerPage.go_to_cart();
    }

    @Step
    public void check_language_changed(){
        Assert.assertEquals("English", headerPage.get_language_value());
        headerPage.select_language_value();
        Assert.assertEquals("French", headerPage.get_language_value());
    }
    @Step
    public void check_language_list_size(int size){
        Assert.assertEquals(headerPage.language_list_size(), size);
    }

}
