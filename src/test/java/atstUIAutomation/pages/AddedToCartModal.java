package atstUIAutomation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class AddedToCartModal extends PageObject {


    @FindBy(css = ".header-cart")
    private WebElementFacade modal;
}
