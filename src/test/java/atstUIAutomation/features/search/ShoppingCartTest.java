package atstUIAutomation.features.search;


import atstUIAutomation.helpers.Constants;
import atstUIAutomation.steps.serenity.HeaderSteps;
import atstUIAutomation.steps.serenity.NavigationSteps;
import atstUIAutomation.steps.serenity.ProductsSteps;
import atstUIAutomation.steps.serenity.ShoppingCartSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.core.annotation.Order;

@RunWith(SerenityRunner.class)
public class ShoppingCartTest {

    @Managed(uniqueSession = true)
    WebDriver webdriver;


    @Steps
    NavigationSteps navigationSteps;

    @Steps
    HeaderSteps headerSteps;

    @Steps
    ProductsSteps productSteps;

    @Steps
    ShoppingCartSteps shoppingCartSteps;


    @Test @Order(1)
    public  void add_to_cart_searched_product(){
        navigationSteps.navigate_to_homepage();
        headerSteps.search_product(Constants.productName);
        productSteps.add_first_product_to_cart();
        headerSteps.navigate_to_shopping_cart();
        shoppingCartSteps.should_see_product_in_shopping_cart(Constants.productName);
    }
    @Test @Order (2)
    public void remove_product_from_cart(){
        add_to_cart_searched_product();
        shoppingCartSteps.remove_product_from_shopping_cart(webdriver);
        shoppingCartSteps.should_see_no_removable_product_left();


    }
}
