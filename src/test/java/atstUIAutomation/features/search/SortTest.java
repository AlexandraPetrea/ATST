package atstUIAutomation.features.search;

import atstUIAutomation.steps.serenity.HeaderSteps;
import atstUIAutomation.steps.serenity.NavigationSteps;
import atstUIAutomation.steps.serenity.SortSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.core.annotation.Order;


@RunWith(SerenityRunner.class)
public class SortTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    SortSteps sortSteps;


    @Test
    public void change_sorting_option_on_page(){
        sortSteps.change_sorting_option();
    }

    @Test
    public void change_view_mode_on_page(){
        sortSteps.change_view_mode();
    }

}
