package testng.testcase;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 *
 */

public class linkTest {
    WebDriver driver;
    HttpURLConnection httpconnection = null;

    public linkTest(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * To check each autosuggestion urls
     */
    public void urlTestCase() {
        List<WebElement> searchTags = driver.findElements(By.xpath("//div[@class='suggestion-product']"));
        Iterator itr = searchTags.iterator();

        while (itr.hasNext()) {
            WebElement link = (WebElement) itr.next();
            String url = (driver.findElement(By.tagName("a"))).getAttribute("href");
            // checkUrl(url);
        }

    }

    /*
     * To open http connection and receive the response header
     */

    public void checkUrl(String url) {
        if (url == null || url == "") {
            System.out.println("Url is empty");
            Assert.fail();
        }

        try {
            httpconnection = ((HttpURLConnection) new URL(url).openConnection());
            httpconnection.setRequestMethod("HEAD");
            httpconnection.connect();

            int respCode = httpconnection.getResponseCode();

            if (respCode >= 400) {
                Assert.fail();
            } else {
                System.out.println("Pass");
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
