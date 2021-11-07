package atstUIAutomation.steps.serenity;

import atstUIAutomation.pages.SortPage;
import net.thucydides.core.annotations.Step;
import org.jruby.RubyProcess;
import org.junit.Assert;

public class SortSteps {
    SortPage sortPage;

    @Step
    public void check_all_sorting_options() {
        sortPage.open();
        Assert.assertEquals(true, sortPage.is_products_page());
        Assert.assertEquals("[Position, Name, Price]", sortPage.get_all_sortiong_options().toString());

    }

    @Step
    public void change_sortingBy_option(String sortingByOption, String beforeSorting, String afterSorting) {
        sortPage.open();
        Assert.assertEquals(true, sortPage.is_products_page());

        String beforeSortingProduct = sortPage.getNProduct(0);
        Assert.assertEquals(beforeSortingProduct.toUpperCase(), beforeSorting.toUpperCase());

        sortPage.change_sortingBy_option(sortingByOption);

        String afterSortingProduct = sortPage.getNProduct(0);
        System.out.println(afterSortingProduct);
        System.out.println(afterSorting);
        Assert.assertEquals(afterSortingProduct.toUpperCase(), afterSorting.toUpperCase());
    }

        @Step
    public void change_sorting_direction(String sortingByOption, String before, String after) {
        sortPage.open();
        Assert.assertEquals(true, sortPage.is_products_page());

        sortPage.change_sortingBy_option(sortingByOption);
        String beforeSortingProduct = sortPage.getNProduct(0).toUpperCase();
        Assert.assertEquals(beforeSortingProduct.toUpperCase(), before.toUpperCase());

        Assert.assertEquals("Set Descending Direction", sortPage.get_sorting());
        sortPage.change_sorting();

        Assert.assertEquals("Set Ascending Direction", sortPage.get_sorting());
        String afterSortingProduct = sortPage.getNProduct(0).toUpperCase();
        Assert.assertEquals(afterSortingProduct.toUpperCase(), after.toUpperCase());
    }

    @Step
    public void change_view_mode_grid_list() {
        sortPage.open();
        Assert.assertEquals(true, sortPage.is_products_page());

        sortPage.change_view_grid();
        Assert.assertEquals("Grid", sortPage.get_view_mode());

        sortPage.change_view_list();
        Assert.assertEquals("List", sortPage.get_view_mode());
    }

    @Step
    public void change_view_mode_grid_grid() {
        sortPage.open();
        Assert.assertEquals(true, sortPage.is_products_page());

        sortPage.change_view_grid();
        Assert.assertEquals("Grid", sortPage.get_view_mode());

        sortPage.change_view_grid();
        Assert.assertEquals("Grid", sortPage.get_view_mode());
    }

    @Step
    public void change_view_mode_list_list() {
        sortPage.open();
        Assert.assertEquals(true, sortPage.is_products_page());

        sortPage.change_view_list();
        Assert.assertEquals("List", sortPage.get_view_mode());

        sortPage.change_view_list();
        Assert.assertEquals("List", sortPage.get_view_mode());
    }

}
