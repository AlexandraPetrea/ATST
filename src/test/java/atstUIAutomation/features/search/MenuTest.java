package atstUIAutomation.features.search;
import atstUIAutomation.steps.serenity.HeaderSteps;
import atstUIAutomation.steps.serenity.NavigationSteps;
import atstUIAutomation.steps.serenity.ProductsSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
public class MenuTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    NavigationSteps navigationSteps;

    @Steps
    HeaderSteps headerSteps;

    @Steps
    ProductsSteps productSteps;

    @Test
    public void check(){
        navigationSteps.navigate_to_homepage();
        navigationSteps.navigate_to_page_from_menu("HOME & DECOR");
    }



}
