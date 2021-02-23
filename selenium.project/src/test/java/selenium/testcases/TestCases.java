package selenium.testcases;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.Search;
import selenium.testcases.utils.AssertUtils;

public class TestCases {
    WebDriver driver;
    Search search;
    selenium.testcases.linkTest linkTest;
    TestSearch testSearch = new TestSearch();

    String productName;

    /* to open ratioform website on Chrome driver*/
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        search = new Search(driver);
        linkTest = new linkTest(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.ratioform.at/");
        productName = search.getProductName();

    }

    /**
     * "Verify that after giving valid product name
     * all the list of product realted to that product should get display."
     */
    public void tc_Search_1() {
        search.searchproduct(productName);
        WebElement actual = search.getProductList();
        AssertUtils.assertEquals(actual.getText().contains("Produkte"), true);
        search.getSearch().clear();
    }

    /**
     * Verify that after clicking on the valid and desired product the product detail page should get display.
     */
    public void tc_Search_2() {
        search.searchproduct(productName);
        search.getProductDetails().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().back();
    }

    /**
     * Verify that after getting redirected to the product page the page link should not be broken.
     */
    public void tc_Search_3() {
        search.searchproduct(productName);
        search.getProductDetails();
        String url = (driver.findElement(By.tagName("a"))).getAttribute("href");
        linkTest.checkUrl(url);
        search.getSearch().clear();
    }

    /**
     * "Verify that after hiting the enter button
     * on keybord, result should get displayed."
     */
    public void tc_Search_4() {
        search.searchproduct(productName);
        search.getSearchButton();
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).build().perform();
        String actualmsg = search.getKeyButton().getText();
        String expect = "74 Produkte gefunden";
        AssertUtils.assertEquals(actualmsg.contains(expect), true);
        driver.navigate().back();
    }

    /**
     * productDetails
     * "Verify that after hiting the clicking the search button with mouse
     * on result ,should get display."
     */
    public void tc_Search_5() {
        search.searchproduct(productName);
        search.btnclick();
        String actualmsg = search.getKeyButton().getText();
        String expect = "75 Produkte gefunden";
        AssertUtils.assertEquals(actualmsg.contains(expect), true);
        driver.navigate().back();
    }

    /**
     * Verify that autosuggestion result is containing the search product name
     */
    public void tc_Search_6() {
        search.searchproduct(productName);
        List<WebElement> webElementList = search.getAllSearchExactMatch();

        Iterator<WebElement> itr = webElementList.iterator();
        while (itr.hasNext()) {
            WebElement element = (WebElement) itr.next();
            String actualMsg = element.getText();
            AssertUtils.assertEquals(actualMsg.toLowerCase().contains(productName), true);
        }
        search.getSearch().clear();
    }

    /**
     * Verify that placeholder should be there in search box for unserstanding what to search in serach box.
     */
    public void tc_Search_7() {
        String placeholder = search.getPlaceholder().getAttribute("placeholder");
        String actplaceholder = "Suchbegriff, Produktname, Artikelnummer...";
        AssertUtils.assertEquals(placeholder.contains(actplaceholder), true);
    }

    /**
     * "1. Verify that after giving invalid product data in search option no result found message should get display.
     * 2. Should not get redirected to not found page."
     */
    public void tc_Search_8() {
        String productName = "%";
        search.searchproduct(productName);
        search.btnclick();
        String actualmsg = search.getKeyButton().getText();
        String expect = "0 Produkte gefunden";
        AssertUtils.assertEquals(actualmsg.contains(expect), true);
        driver.navigate().back();
    }

    /**
     * Verify that after giving invalid product data in serach option no result found message should get display.
     */
    public void tc_Search_9() {
        String productName = "  ";
        search.searchproduct(productName);
        search.btnclick();
        String actualmsg = search.getKeyButton().getText();
        String expect = "0";
        AssertUtils.assertEquals(actualmsg.contains(expect), true);
        driver.navigate().back();
    }

    /**
     * "Verify that after giving valid product name in search box and after clicking on all product option,
     * should get redirected to the list of all product page"
     */
    public void tc_Search_10() {
        search.searchproduct(productName);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement all = search.getShowAllButton();
        Actions act = new Actions(driver);
        act.moveToElement(all).click().build().perform();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.navigate().back();
    }

    /**
     * Verify the output without giving any input in search box and clicking on search button
     */
    public void tc_Search_11() {
        String productName = "";
        search.searchproduct(productName);
        search.btnclick();
        String actualmsg = search.getKeyButton().getText();
        String expect = "0"; // total 1243 product found
        AssertUtils.assertEquals(actualmsg.contains(expect), false);
        driver.navigate().back();
    }

    /**
     * "Verify the number of items in the auto-suggestion after entering
     * valid product name."
     */
    public void tc_Search_12() {
        search.searchproduct(productName);
        int actual = (search.getAutoSuggestionCounts()).size();
        AssertUtils.assertEquals(actual, 5);
    }

    public void afterClass() {
        driver.quit();
    }
}
