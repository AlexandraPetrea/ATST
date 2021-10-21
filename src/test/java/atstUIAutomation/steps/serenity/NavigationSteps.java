package atstUIAutomation.steps.serenity;

import atstUIAutomation.pages.GlobalNavigationPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class NavigationSteps {

    GlobalNavigationPage navigationPage;


    @Step
    public void navigate_to_homepage(){
        navigationPage.open();
    }

    @Step
    public void navigate_to_page_from_menu(String page){
        navigationPage.click_on_page(page);
        navigationPage.get_page_title();
        Assert.assertEquals("HOME & DECOR", navigationPage.get_page_title());

    }

}
