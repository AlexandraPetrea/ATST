package atstUIAutomation.steps.serenity;

import atstUIAutomation.pages.ProductsPage;
import atstUIAutomation.pages.SortPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class SortSteps {
    SortPage sortPage;

    @Step
    public void change_sorting_option() {
        sortPage.open();
        Assert.assertEquals(true, sortPage.is_products_page());

        //String beforeSortingProduct = sortPage.getNProduct(0);
       // Assert.assertEquals(beforeSortingProduct, "Barclay d'Orsay pump, Nude");

        Assert.assertEquals("Set Descending Direction", sortPage.get_sorting());
        sortPage.change_sorting();

        Assert.assertEquals("Set Ascending Direction", sortPage.get_sorting());
        String afterSortingProduct = sortPage.getNProduct(0);
        Assert.assertEquals(afterSortingProduct, "");
    }

    @Step
    public void change_view_mode() {
        sortPage.open();
        Assert.assertEquals(true, sortPage.is_products_page());
        //Assert.assertEquals("[Grid]List", sortPage.get_view_mode());
        sortPage.change_view_grid();
       // Assert.assertEquals("Grid[List]", sortPage.get_view_mode());
        sortPage.change_view_list();
       // Assert.assertEquals("List", sortPage.get_view_mode());
    }

    @Step
    public void change() {
    sortPage.open();
    sortPage.get_category();
    }
}
