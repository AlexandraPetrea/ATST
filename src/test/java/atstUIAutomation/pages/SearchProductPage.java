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

}
