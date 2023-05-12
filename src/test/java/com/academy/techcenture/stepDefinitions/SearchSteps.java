package com.academy.techcenture.stepDefinitions;


import com.academy.techcenture.driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchSteps {

    private WebDriver driver;

    @Given("I am on the Google search page")
    public void i_am_on_the_google_search_page() {
        // Navigate to Google search page
        driver = Driver.getDriver();
        driver.get("https://www.google.com");
    }
    @When("I search for {string}")
    public void i_search_for(String searchTerm) {
        // Enter search term (string) and submit form
        WebElement searchBoxInput = driver.findElement(By.id("APjFqb"));
        searchBoxInput.sendKeys(searchTerm);
        searchBoxInput.submit();
    }
    @Then("search results for {string} are displayed")
    public void search_results_for_are_displayed(String searchTerm) {
        // Verify search results are displayed for the given term
        WebElement searchBoxAfterSearch = driver.findElement(By.id("APjFqb"));
        String actualValue = searchBoxAfterSearch.getAttribute("value");
        String expectedValue = "cucumber tutorial";
        Assert.assertEquals("Search results are not displayed",expectedValue, actualValue);
        driver.quit();
    }
}
