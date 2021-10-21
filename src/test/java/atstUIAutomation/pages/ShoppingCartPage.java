package atstUIAutomation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartPage extends PageObject {


    @FindBy(css = ".block block-cart")
    private WebElementFacade modal;

    @FindBy(css = ".block block-cart, .mini-products-list")
    private WebElementFacade productsElementsContainer;

    public List<String> getShoppingCartProductsName(){
        WebElementFacade    productsList = productsElementsContainer;

        return productsList.findElements(By.cssSelector(".product-name, a")).stream().map(element->element.getText().toLowerCase()).collect(Collectors.toList());
    }

    @FindBy(css = "block block-cart, a.remove")
    private WebElementFacade removeProductCardButton;

    public void remove_product_from_shopping_cart(WebDriver webdriver){
        removeProductCardButton.waitUntilVisible().click();

        webdriver.switchTo().alert().accept();
        waitABit(2000);

    }
    public Boolean is_remove_product_from_cart_present(){
        return removeProductCardButton.isVisible();
    }
}
