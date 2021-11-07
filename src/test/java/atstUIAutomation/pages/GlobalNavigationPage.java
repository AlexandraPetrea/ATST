package atstUIAutomation.pages;


import atstUIAutomation.helpers.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.jruby.RubyProcess;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl(Constants.url)
public class GlobalNavigationPage extends PageObject {

    @FindBy(className = "nav-primary")
    private WebElementFacade productSeeAllLink;


    public Boolean products_link_is_visible() {
        return productSeeAllLink.waitUntilVisible().isVisible();
    }

    @FindBy(className = "page-title")
    private WebElementFacade pageTitle;

    public String get_page_title() {
        return pageTitle.getText();
    }
/*
    @FindBy(id="nav")
    private List<WebElementFacade> first;
    public void click_on_page(String page){
        System.out.println(first.get(0).getText());
        }
    }*/
}
