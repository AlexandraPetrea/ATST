package atstUIAutomation.pages;


import atstUIAutomation.helpers.Constants;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl(Constants.url)
public class SearchProductPage extends PageObject {

    @FindBy(className = "products-grid")
    private WebElementFacade productsContainer;

    @FindBy(id = "search")
    private WebElementFacade searchBox;

    @FindBy(className = "search-button")
    private WebElementFacade searchButton;

    public void searchAProduct(String productName) {
        searchBox.type(productName);
        searchButton.click();
    }

    public String getNProduct(Integer position) {
        String[] array = new String[getNumberOfProducts()];
        List productsList = getProducts();
        productsList.toArray(array);
        return array[position];
    }

    public List getProducts() {
        WebElementFacade productsList = productsContainer;

        return productsList.findElements(By.className("product-image")).stream()
                .map(element ->
                     element.getAttribute("Title")
                )
                .collect(Collectors.toList());
    }

    public Integer getNumberOfProducts() {
        List products = getProducts();
        return products.size();
    }
    @FindBy(className="current")
    private WebElementFacade currentPage;
    @FindBy(className="next")
    private WebElementFacade nextPage;
    @FindBy(className="previous")
    private WebElementFacade previousPage;

    @FindBy(className = "page-title")
    private WebElementFacade searchTermHeading;

    @FindBy(xpath = "//*[@id='top']/body/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/p")
    private WebElementFacade pageAmount;

    public String get_page_amount(){
        return pageAmount.getText();
    }


    public String get_search_results_page_term(){
        return searchTermHeading.getText();
    }


    public String get_search_results_page(){
        return currentPage.getText();
    }

    public Boolean next_is_visible() {return nextPage.isVisible();}
    public void go_to_next_page(){
        nextPage.waitUntilClickable().click();
    }

    public Boolean previous_is_visible() {return previousPage.isVisible();}
    public void go_to_previous_page(){
        previousPage.waitUntilClickable().click();
    }

}
