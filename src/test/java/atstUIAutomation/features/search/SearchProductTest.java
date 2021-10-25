package atstUIAutomation.features.search;

import atstUIAutomation.steps.serenity.SearchProductSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchProductTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    SearchProductSteps rnSteps;

    @Test
    public void searchForPants(){
        rnSteps.navigateToMainPage();
        rnSteps.searchForAProduct("pants");
        rnSteps.getNumberOfProducts(4);
    }

    @Test
    public void searchForSkirts(){
        rnSteps.navigateToMainPage();
        rnSteps.searchForAProduct("skirt");
        rnSteps.getNumberOfProducts(2);
    }

    @Test
    public void searchForNPants(){
        rnSteps.navigateToMainPage();
        rnSteps.searchForAProduct("pants");
        rnSteps.getNProduct(2);
    }
}