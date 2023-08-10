package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	private static final Logger logger = LogManager.getLogger(Search.class);

	@Given("Is the website having multiple filters to search products like price range,category,brands etc {string}")
	public void is_the_website_having_multiple_filters_to_search_products_like_price_range_category_brands_etc(
			String searchDropdownBox) throws InterruptedException {
		driver = DriverFactory.getDriver();
		searchResultsPage = new SearchResultsPage(driver);
		logger.info("Before Validate Search Dropdown Box");
		Assert.assertTrue(searchResultsPage.validateSearchDropdownBox());
		logger.info("After Validate Search Dropdown Box");

		logger.info("Before selectSearchDropdownBox");
		searchResultsPage.selectSearchDropdownBox(searchDropdownBox);
		logger.info("Before selectSearchDropdownBox");

		logger.info("Before click On Search Submit Button");
		searchResultsPage.clickOnSearchSubmitButton();
		logger.info("After click On Search Submit Button");
		
		logger.info("Before validateMultileFilters");
		Assert.assertTrue(searchResultsPage.validateMultileFilters());
		logger.info("After validateMultileFilters");
		Thread.sleep(2000);
	}

	@When("Are relevent products displaying after applying single or multiple search filters")
	public void are_relevent_products_displaying_after_applying_single_or_multiple_search_filters()
			throws InterruptedException {
		
		logger.info("Before clickOnChildrenBooks");
		searchResultsPage.clickOnChildrenBooks();
		logger.info("After clickOnChildrenBooks");
		
		logger.info("Before validateSortByDropdown");
		Assert.assertTrue(searchResultsPage.validateSortByDropdown());
		logger.info("After validateSortByDropdown");
		Thread.sleep(2000);
	}

	@Then("Is there an option to display a fixed number of products on the search page")
	public void is_there_an_option_to_display_a_fixed_number_of_products_on_the_search_page() {
		
		logger.info("Before validateFixedNumberOfProducts");
		Assert.assertTrue(searchResultsPage.validateFixedNumberOfProducts());
		logger.info("After validateFixedNumberOfProducts");
	}

	@Then("Is there any sort option available on the search page and is that working properly {string} {string}")
	public void is_there_any_sort_option_available_on_the_search_page_and_is_that_working_properly(String low,
			String high) {
		searchResultsPage.clickOnSortByButton();
		logger.info("After clickOnSortByButton");
		
		searchResultsPage.selectPriceLowtoHigh(low);
		logger.info("After selectPriceLowtoHigh");
		
		searchResultsPage.clickOnSortByButton();
		logger.info("After clickOnSortByButton");
		
		searchResultsPage.selectPriceHighToLow(high);
		logger.info("After selectPriceHighToLow");
	}

}
