package atstUIAutomation.pages;

import atstUIAutomation.helpers.Constants;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.jruby.RubyProcess;

import javax.swing.text.html.parser.Element;
import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl(Constants.url+"accessories/shoes.html")
public class SortPage extends PageObject {
    @FindBy(className = "products-grid")
    private WebElementFacade productData;

    @FindBy(className = "sort-by-switcher")
    private WebElementFacade sortingOption;


    public Boolean is_products_page(){
        return productData.waitUntilVisible().isVisible();
    }

    public String get_sorting(){
        return sortingOption.getText();
    }

    public void change_sorting(){
        sortingOption.waitUntilClickable().click();
    }


    @FindBy(xpath = "//*[@id='top']/body/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[1]/p")
    private WebElementFacade viewMode;
    @FindBy(xpath = "//*[@id='top']/body/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[1]/p/strong")
    private WebElementFacade viewMode1;
    @FindBy(className = "list")
    private WebElementFacade viewOptionList;
    @FindBy(className = "grid")
    private WebElementFacade viewOptionGrid;



    public String get_view_mode(){
        System.out.println(viewMode.getText());

        System.out.println(viewMode1.getText());

        return viewMode1.getText();
    }

    public void change_view_list(){
        viewOptionList.waitUntilClickable().click();
    }

    public void change_view_grid(){
        viewOptionGrid.waitUntilClickable().click();
    }


    @FindBy(className = "last odd")
    private WebElementFacade category;
    public String get_category(){
        return category.getText();
    }

    public List getProducts() {
        WebElementFacade productsList = productData;

        return productsList.findElements(By.className("product-image")).stream()
                .map(element ->
                        element.getAttribute("Title")
                )
                .collect(Collectors.toList());
    }

    public String getNProduct(Integer position) {
        String[] array = new String[getNumberOfProducts()];
        List productsList = getProducts();
        productsList.toArray(array);
        return array[position];
    }
    public Integer getNumberOfProducts() {
        List products = getProducts();
        return products.size();
    }

    @FindBy(className = "sort-by")
    private WebElementFacade sortingBy;

    public List<String> get_all_sortiong_options(){
     System.out.println(sortingBy.getSelectOptions());
     return sortingBy.getSelectOptions();

 }
    @FindBy(xpath = "//*[@id='top']/body/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[1]/div/select")
    private WebElementFacade changeSortingBy;

    public void change_sortingBy_option(String sortingByOption){
        changeSortingBy.click();
        changeSortingBy.selectByVisibleText(sortingByOption);

 }
    public String get_sortingBy(){
      System.out.println(sortingBy.getSelectOptions());
        List aux = sortingBy.findElements(By.xpath("//option[@selected='selected']")).stream()
                .map(element ->
                        element.getText()
                )
                .collect(Collectors.toList());

       System.out.println(aux.get(1).toString());
        return aux.get(1).toString();
    }


}

