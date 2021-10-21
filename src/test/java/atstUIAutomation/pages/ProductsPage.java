package atstUIAutomation.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.jruby.RubyProcess;

public class ProductsPage extends PageObject {


    @FindBy(className = "products-grid")
    private WebElementFacade productData;


    //body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a
    //*[@id="top"]/body/div/div/div[2]/div/div[2]/div[2]/div[3]/ul/li[1]/div/div[3]/a
    //  /html/body/div/div/div[2]/div/div[2]/div[2]/div[3]/ul/li[1]/div/div[3]/a

    //@FindBy(css = ".button")
   // <a title="View Details" class="button" href="http://qa1.dev.evozon.com/core-striped-sport-shirt-551.html">View Details</a>
   // @FindBy(linkText = "http://qa1.dev.evozon.com/core-striped-sport-shirt-551.html")
    // product-collection-image-413
    @FindBy(id="product-collection-image-413")
    private WebElementFacade buttonViewDetails;

    @FindBy(id="swatch26")
    private WebElementFacade colorField;

    @FindBy(id="option79")
    private WebElementFacade sizeField;

    //@FindBy(css=".add-to-cart-buttons .btn-cart")
    //*[@id="map-popup-button"]
    //@FindBy(className = "btn-cart")
    // /html/body/div[1]/div/div[2]/div/div[2]/div[3]/div[1]/form/div[3]/div[6]/div[2]/div[2]/button/span/span
    ////*[@id="product_addtocart_form"]/div[3]/div[6]/div[2]/div[2]/button/span/span
    //#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span
    @FindBy(css=".add-to-cart")
    private WebElementFacade buttonAddToCart;
    //#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button


    public Boolean is_products_page(){
        return productData.waitUntilVisible().isVisible();
    }

    public void add_to_cart(){
        productData.waitUntilClickable().click();

        buttonViewDetails.waitUntilClickable().click();

        sizeField.waitUntilClickable().click();
        colorField.waitUntilClickable().click();

        buttonAddToCart.click();

    }

}
