package atstUIAutomation.pages;

import atstUIAutomation.helpers.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl(Constants.url+"accessories/shoes.html")
public class SortPage extends PageObject {
    @FindBy(className = "products-grid")
    private WebElementFacade productData;

    @FindBy(className = "sort-by-switcher")
    private WebElementFacade sortingOption;

    public Boolean is_products_page(){
        return productData.waitUntilVisible().isVisible();
    }

    public String get_sorting(){
        return sortingOption.getText();
    }

    public void change_sorting(){
        sortingOption.waitUntilClickable().click();
    }


    @FindBy(className = "view-mode")
    private WebElementFacade viewMode;
    @FindBy(className = "list")
    private WebElementFacade viewOptionList;
    @FindBy(className = "grid")
    private WebElementFacade viewOptionGrid;

    public String get_view_mode(){
        return viewMode.getText();
    }

    public void change_view_list(){
        viewOptionList.waitUntilClickable().click();
    }

    public void change_view_grid(){
        viewOptionGrid.waitUntilClickable().click();
    }


    @FindBy(className = "last odd")
    private WebElementFacade category;
    public String get_category(){
        return category.getText();
    }

}

