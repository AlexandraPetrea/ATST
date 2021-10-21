package atstUIAutomation.pages;


import atstUIAutomation.helpers.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import java.util.List;


@DefaultUrl(Constants.url)
public class HeaderPage extends PageObject {

    @FindBy(className = "skip-account")
    private WebElementFacade account;

    @FindBy(className = "skip-cart")
    private WebElementFacade cart;

    public Boolean my_account_is_visible(){
        return account.waitUntilVisible().isVisible();
    }

    public Boolean my_cart_is_visible(){
        return cart.waitUntilVisible().isVisible();
    }


    @FindBy(id = "search")
    private WebElementFacade searchBox;

    @FindBy(className = "search-button")
    private WebElementFacade searchButton;

    public void type_keyword(String keyword){
        searchBox.type(keyword);
    }

    public void search(){
        searchButton.waitUntilClickable();
        searchButton.click();
    }

    //<a href="http://qa1.dev.evozon.com/checkout/cart/" data-target-element="#header-cart" class="skip-link skip-cart skip-active">
    //@FindBy(linkText = "http://qa1.dev.evozon.com/checkout/cart/")
    //private WebElementFacade myCartButton;
    //#header > div > div.skip-links > div > div > a

    @FindBy(css = ".block block-cart skip-cart")
    private WebElementFacade cartModal;

    public void go_to_cart(){
        //cartModal.waitUntilClickable().click();
        cart.waitUntilClickable().click();
    }

    @FindBy(id="select-language")
    private WebElementFacade languageDropdown;

    @FindBy(css="#select-language > option")
    private List<WebElementFacade> languageListSize;

    public String get_language_value(){
        return languageDropdown.getSelectedVisibleTextValue();
    }

    public void select_language_value(){
        languageDropdown.selectByVisibleText("French");
  }
    public int language_list_size(){
        return languageListSize.size();
    }


}
