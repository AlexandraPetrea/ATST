package atstUIAutomation.steps.serenity;

import atstUIAutomation.pages.ProductsPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ProductsSteps {


    ProductsPage productsPage;

    @Step
    public void add_first_product_to_cart() {
        Assert.assertEquals(true, productsPage.is_products_page());
        productsPage.add_to_cart();
    }


}
