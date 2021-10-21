package atstUIAutomation.features.search;

import atstUIAutomation.steps.serenity.HeaderSteps;
import atstUIAutomation.steps.serenity.NavigationSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LandingPageValidationTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public NavigationSteps  navigationSteps;

    @Steps
    public HeaderSteps headerSteps;


    @Test
    public void global_header_test(){
        navigationSteps.navigate_to_homepage();
        headerSteps.global_header_elements_should_be_visible();
    }

    @Test
    public void global_navigation_test(){
        navigationSteps.navigate_to_homepage();
        headerSteps.global_navigation_elements_should_be_visible();

    }
}
