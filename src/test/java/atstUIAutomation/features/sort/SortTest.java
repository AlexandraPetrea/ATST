package atstUIAutomation.features.sort;

import atstUIAutomation.steps.serenity.HeaderSteps;
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
    public void get_all_sorting_options(){
        sortSteps.check_all_sorting_options();
    }


    @Test
    public void change_sorting_direction_price(){
        sortSteps.change_sorting_direction("Price", "HANA FLAT, CHARCOAL", "ANN ANKLE BOOT");
    }

    @Test
    public void change_sorting_direction_name(){
        sortSteps.change_sorting_direction("Name", "ANN ANKLE BOOT", "WINGTIP COGNAC OXFORD");
    }

    @Test
    public void change_sorting_direction_position(){
        sortSteps.change_sorting_direction("Position", "BARCLAY D'ORSAY PUMP, NUDE", "SUEDE LOAFER, NAVY");
    }


    @Test
    public void change_sorting_by_name()
    {
        sortSteps.change_sortingBy_option("Name","BARCLAY D'ORSAY PUMP, NUDE" ,"ANN ANKLE BOOT" );
    }
    @Test
    public void change_sorting_by_price()
    {
        sortSteps.change_sortingBy_option("Price", "BARCLAY D'ORSAY PUMP, NUDE" , "HANA FLAT, CHARCOAL");
    }
    @Test
    public void change_sorting_by_position()
    {
        sortSteps.change_sortingBy_option("Position", "BARCLAY D'ORSAY PUMP, NUDE" ,"BARCLAY D'ORSAY PUMP, NUDE");
    }

    @Test
    public void change_view_mode_same_grid()
    {
        sortSteps.change_view_mode_grid_grid();

    }

    @Test
    public void change_view_mode_same_list()
    {
        sortSteps.change_view_mode_list_list();

    }

    @Test
    public void change_view_mode_different()
    {
        sortSteps.change_view_mode_grid_list();

    }
}
