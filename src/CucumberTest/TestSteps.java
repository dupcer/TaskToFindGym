package CucumberTest;

import cucumber.api.java.After;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestSteps {
    private final WebDriver driver = new ChromeDriver();

    private final String HomeURL = "https://www.nuffieldhealth.com/gyms";
    private final By locationFinderInput = By.xpath("//div[@id='main']//input[contains(@id,'location-finder')]");
    private final By searchResults = By.xpath("//div[@id='main']//div[contains(.,'Close')]//div[@data-panel-name='list']//ul");

    @Given("I navigate to home page")
    public void navigate_to_home_page() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(HomeURL);
    }

    @When("I enter a postcode \"([\\s\\S]*)\"")
    public void insert_postcode(String postcode) {
        WebElement element = driver.findElement(locationFinderInput);
        element.sendKeys(postcode);
        element.sendKeys(Keys.ENTER);
    }

    @Then("I see in results \"([\\s\\S]*)\"")
    public void assert_search_results(String expected) {
        WebElement results = driver.findElement(searchResults);
        Assert.assertTrue(results.getText().contains(expected));
    }

    @After()
    public void closeBrowser()
    {
        driver.quit();
    }
}
