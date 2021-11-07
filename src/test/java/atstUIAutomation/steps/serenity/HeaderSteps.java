package atstUIAutomation.steps.serenity;

import atstUIAutomation.pages.GlobalNavigationPage;
import atstUIAutomation.pages.HeaderPage;
import atstUIAutomation.pages.SearchProductPage;
import net.thucydides.core.annotations.Step;
import org.jruby.RubyProcess;
import org.junit.Assert;
import org.springframework.core.annotation.Order;

public class HeaderSteps {

    HeaderPage headerPage;
    GlobalNavigationPage navigationPage;
    SearchProductPage searchProductsPage;

    @Step
    public void search_product(String productName){
            headerPage.type_keyword(productName);
            headerPage.search();

        Assert.assertEquals("SEARCH RESULTS FOR '" + productName.toUpperCase()+"'", searchProductsPage.get_search_results_page_term().toUpperCase() );
    }


    @Step
    public void check_navigation_arrows_on_first_page() {
        Assert.assertEquals("1", searchProductsPage.get_search_results_page());
        Assert.assertEquals("1-12 of 84", searchProductsPage.get_page_amount());
        Assert.assertEquals(false, searchProductsPage.previous_is_visible());
        Assert.assertEquals(true, searchProductsPage.next_is_visible());
    }
    @Step
    public void go_to_next_page_from_search(String firstPage, String firstAmount, String secondPage, String secondAmount) {
        Assert.assertEquals(firstPage, searchProductsPage.get_search_results_page());
        Assert.assertEquals(firstAmount, searchProductsPage.get_page_amount());
        searchProductsPage.go_to_next_page();
        Assert.assertEquals(secondPage, searchProductsPage.get_search_results_page());
        Assert.assertEquals(secondAmount, searchProductsPage.get_page_amount());

    }
    @Step
    public void go_to_previous_page_from_search(String firstPage, String firstAmount, String secondPage, String secondAmount) {
        Assert.assertEquals(firstPage, searchProductsPage.get_search_results_page());
        Assert.assertEquals(firstAmount, searchProductsPage.get_page_amount());
        searchProductsPage.go_to_previous_page();
        Assert.assertEquals(secondPage, searchProductsPage.get_search_results_page());
        Assert.assertEquals(secondAmount, searchProductsPage.get_page_amount());
    }


    @Step
    public void check_language_changed(String language){
        Assert.assertEquals("English", headerPage.get_language_value());
        headerPage.select_language_value(language);
        Assert.assertEquals(language, headerPage.get_language_value());
    }

    @Step
    public void check_language_for_welcome_msg(String language, String expectedWelcomeMsg){
        headerPage.select_language_value(language);
        Assert.assertEquals(language, headerPage.get_language_value());
        Assert.assertEquals(expectedWelcomeMsg.toUpperCase(), headerPage.get_welcome_msg());
    }
    @Step
    public void check_language_list_size(int size){
        Assert.assertEquals(headerPage.language_list_size(), size);
    }

}
