package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Prachiti
 */
public class Search {
    WebDriver driver;

    @FindBy(name = "searchQuery")
    WebElement search;

    @FindBy(css = "(button[type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='suggest-search__box']")
    WebElement productList;

    @FindBy(css = "input[placeholder='Suchbegriff, Produktname, Artikelnummer...']")
    WebElement placeholder;

    @FindBy(xpath = "//div[@class='sort']")
    WebElement keyButton;

    @FindAll({ @FindBy(xpath = "//span[@class='suggestion-product__name']") })
    List<WebElement> searchExactMatch;

    @FindBy(xpath = "//html//body//div[2]//header-tag//div[2]//div[1]//div//div[1]//search-form//form//suggest-search//div//div//div//div//div[6]//button")
    WebElement showAllButton;

    @FindAll({ @FindBy(xpath = "//div[@class='suggestion-product']") })
    List<WebElement> autoSuggestionCounts;

    @FindBy(xpath = "//html//body//div[2]//header-tag//div[2]//div[1]//div//div[1]//search-form//form//suggest-search//div//div//div//div//div[2]//a")
    WebElement productDetails;

    String productName;

    public Search(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        productName = "wellpapp";
    }

    public void searchproduct(String productname) {
        search.sendKeys(productname);
    }

    public void btnclick() {
        searchButton.click();
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearch() {
        return search;
    }

    public WebElement getProductList() {
        return productList;
    }

    public WebElement getProductDetails() {
        return productDetails;
    }

    public WebElement getKeyButton() {
        return keyButton;
    }

    public List<WebElement> getAllSearchExactMatch() {
        return searchExactMatch;
    }

    public WebElement getPlaceholder() {
        return placeholder;
    }

    public WebElement getShowAllButton() {
        return showAllButton;
    }

    public List<WebElement> getAutoSuggestionCounts() {
        return autoSuggestionCounts;
    }

    public String getProductName() {
        return productName;
    }
}
