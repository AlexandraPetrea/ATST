package atstUIAutomation.steps.serenity;

import atstUIAutomation.pages.ShoppingCartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ShoppingCartSteps extends PageObject {


    ShoppingCartPage shoppingCartPage;

    @Step
    public void should_see_product_in_shopping_cart(String productName){

        Assert.assertThat(shoppingCartPage.getShoppingCartProductsName(), Matchers.hasItem(Matchers.containsString(productName)));
    }

    @Step
    public void remove_product_from_shopping_cart(WebDriver webdriver){
        shoppingCartPage.remove_product_from_shopping_cart(webdriver);

    }
    @Step
    public void should_see_no_removable_product_left(){
        Assert.assertEquals(false, shoppingCartPage.is_remove_product_from_cart_present());
    }
}
