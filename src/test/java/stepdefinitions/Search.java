package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchResultsPage;

public class Search { 
	
	WebDriver driver;
	SearchResultsPage searchResultsPage;
	
	@Given("Is the website having multiple filters to search products like price range,category,brands etc {string}")
	public void is_the_website_having_multiple_filters_to_search_products_like_price_range_category_brands_etc(String searchDropdownBox) throws InterruptedException {
		driver = DriverFactory.getDriver();
		searchResultsPage=new SearchResultsPage(driver);
		Assert.assertTrue(searchResultsPage.validateSearchDropdownBox());
		searchResultsPage.selectSearchDropdownBox(searchDropdownBox);
		searchResultsPage.clickOnSearchSubmitButton();
		Assert.assertTrue(searchResultsPage.validateMultileFilters());
		Thread.sleep(2000);
	}

	@When("Are relevent products displaying after applying single or multiple search filters")
	public void are_relevent_products_displaying_after_applying_single_or_multiple_search_filters() throws InterruptedException {
		searchResultsPage.clickOnChildrenBooks();
		Assert.assertTrue(searchResultsPage.validateSortByDropdown());		
		Thread.sleep(2000);
	}

	@Then("Is there an option to display a fixed number of products on the search page")
	public void is_there_an_option_to_display_a_fixed_number_of_products_on_the_search_page() {
		Assert.assertTrue(searchResultsPage.validateFixedNumberOfProducts());
	}

	@Then("Is there any sort option available on the search page and is that working properly {string} {string}")
	public void is_there_any_sort_option_available_on_the_search_page_and_is_that_working_properly(String low, String high) {
		searchResultsPage.clickOnSortByButton();
		searchResultsPage.selectPriceLowtoHigh(low);
		searchResultsPage.clickOnSortByButton();
		searchResultsPage.selectPriceHighToLow(high);
	}
		
	

	


}
