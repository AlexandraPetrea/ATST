package atstUIAutomation.steps.serenity;

import atstUIAutomation.helpers.Constants;
import atstUIAutomation.pages.SearchProductPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class SearchProductSteps {
    SearchProductPage searchProductPage;

    @Step
    public void navigateToMainPage(){
        searchProductPage.open();
    }

    @Step
    public void searchForAProduct(String productName){
        searchProductPage.searchAProduct(productName);
    }

    @Step
    public void getNumberOfProducts(Integer numberToCompareWith)
    {
        Assert.assertEquals(searchProductPage.getNumberOfProducts(), numberToCompareWith);
    }

    @Step
    public void getNProduct(Integer numberToCompareWith)
    {
        Assert.assertEquals(searchProductPage.getNProduct(numberToCompareWith), Constants.nThElement);
    }
}
