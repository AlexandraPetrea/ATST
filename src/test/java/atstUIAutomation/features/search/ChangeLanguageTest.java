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
public class ChangeLanguageTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    NavigationSteps navigationSteps;

    @Steps
    HeaderSteps headerSteps;

    @Test
    public void changeLanguageTest(){
        navigationSteps.navigate_to_homepage();
        headerSteps.check_language_changed();
    }

    @Test
    public void languageListSizeTest(){
        navigationSteps.navigate_to_homepage();
        headerSteps.check_language_list_size(3);
    }

}
