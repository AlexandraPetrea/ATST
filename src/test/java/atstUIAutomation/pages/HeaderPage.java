package atstUIAutomation.pages;


import atstUIAutomation.helpers.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.jruby.RubyProcess;

import java.util.List;


@DefaultUrl(Constants.url)
public class HeaderPage extends PageObject {

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


    @FindBy(id="select-language")
    private WebElementFacade languageDropdown;

    @FindBy(css="#select-language > option")
    private List<WebElementFacade> languageListSize;

    @FindBy(className="welcome-msg")
    private WebElementFacade welcomeMsg;

    public String get_language_value(){

        return languageDropdown.getSelectedVisibleTextValue();
    }

    public void select_language_value(String language){

        languageDropdown.selectByVisibleText(language);
  }
    public int language_list_size(){

        return languageListSize.size();
    }

    public String get_welcome_msg(){

        return welcomeMsg.getText();
    }

}
