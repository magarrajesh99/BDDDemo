package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchDomainPage;

public class SearchDomain {

	WebDriver driver;
	SearchDomainPage searchDomainPage;
	private static final Logger logger = LogManager.getLogger(SearchDomain.class);

	@When("click on the first menu link which is Domains it will open up sub menu")
	public void click_on_the_first_menu_link_which_is_domains_it_will_open_up_sub_menu() {
		driver = DriverFactory.getDriver();
		searchDomainPage = new SearchDomainPage(driver);
		logger.info("Before clickOnDomains");
		searchDomainPage.clickOnDomains();
		logger.info("After clickOnDomains");
		
		Assert.assertTrue(searchDomainPage.domainNameSearchIsDisplayed());
		logger.info("After domainNameSearchIsDisplayed");
	}

	@When("Click on the Domain Name Search link from sub menu")
	public void click_on_the_domain_name_search_link_from_sub_menu() {
		searchDomainPage.clickOnDomainNameSearch();
		logger.info("After clickOnDomainNameSearch");
	}
	

@When("Get value of title of {string} page and print it")
public void get_value_of_title_of_page_and_print_it(String expectedTitle) throws InterruptedException {
	Assert.assertEquals(expectedTitle,searchDomainPage.getTitleOfSearchDomainName());
	logger.info("After getTitleOfSearchDomainName");
	
	
}

@Then("Verify that the search box is present on the page and its enabled")
public void verify_that_the_search_box_is_present_on_the_page_and_its_enabled() {
	Assert.assertTrue(searchDomainPage.searchBoxIsPresent());
	logger.info("After searchBoxIsPresent");
	
	Assert.assertTrue(searchDomainPage.searchBoxIsEnabled());
	logger.info("After searchBoxIsEnabled");
	
}

@Then("Enter some test value in the search box like {string} and click on Add to Cart button")
public void enter_some_test_value_in_the_search_box_like_and_click_on_add_to_cart_button(String domainName) {
	
	searchDomainPage.enterDomainNameInSearchBox(domainName);
	logger.info("After enterDomainNameInSearchBox");
	
	searchDomainPage.clickOnSearchBox();
	logger.info("After clickOnSearchBox");
	
	Assert.assertTrue(searchDomainPage.domainNameIsPresent());
	logger.info("After domainNameIsPresent");
	
	Assert.assertTrue(searchDomainPage.addToCartIsPresent());
	logger.info("After addToCartIsPresent");
	
	searchDomainPage.clickOnAddToCart();
	logger.info("After clickOnAddToCart");
}

@Then("Verify that the price of the domain is also displayed along with domain name {string}")
public void verify_that_the_price_of_the_domain_is_also_displayed_along_with_domain_name(String expectedName) {
	searchDomainPage.clickOnViewCartButton();
	logger.info("After clickOnViewCartButton");
	
	Assert.assertTrue(searchDomainPage.verifyPriceOfDomainName());
	logger.info("After verifyPriceOfDomainName");
	
	Assert.assertEquals(expectedName,searchDomainPage.verifyDomainName());	
	logger.info("After verifyDomainName");
	
}

}
