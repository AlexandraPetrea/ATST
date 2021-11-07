package atstUIAutomation.features.language;
import atstUIAutomation.steps.serenity.HeaderSteps;
import atstUIAutomation.steps.serenity.SearchProductSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
public class LanguageTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    SearchProductSteps rnSteps;
    @Steps
    HeaderSteps headerSteps;

    @Test
    public void changeLanguageTest_English(){
        rnSteps.navigateToMainPage();
        headerSteps.check_language_changed("English");
    }
    @Test
    public void changeLanguageTest_French(){
        rnSteps.navigateToMainPage();
        headerSteps.check_language_changed("French");
    }

    @Test
    public void changeLanguageTest_German(){
        rnSteps.navigateToMainPage();
        headerSteps.check_language_changed("German");
    }
    @Test
    public void contentLanguageTest_English(){
        rnSteps.navigateToMainPage();
        headerSteps.check_language_for_welcome_msg("English", "Welcome");
    }
    @Test
    public void contentLanguageTest_French(){
        rnSteps.navigateToMainPage();
        headerSteps.check_language_for_welcome_msg("French", "Bienvenue");
    }
    @Test
    public void contentLanguageTest_German(){
        rnSteps.navigateToMainPage();
        headerSteps.check_language_for_welcome_msg("German", "Willkommen");
    }

    @Test
    public void languageListSizeTest(){
        rnSteps.navigateToMainPage();
        headerSteps.check_language_list_size(3);
    }

}
