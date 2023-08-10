package stepdefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.RegisterResultsPage;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;


public class Register { 

	WebDriver driver;
	SearchResultsPage searchResultsPage;
	ShoppingCartPage shoppingCartResultPage;
	RegisterResultsPage registerResultsPage;
	private static final Logger logger = LogManager.getLogger(Register.class);
		
	@Given("Can a guest purchage product as a guest user{string}{string}")
	public void can_a_guest_purchage_product_as_a_guest_user(String searchDropdownBox, String bookName) {
		driver = DriverFactory.getDriver();
		searchResultsPage=new SearchResultsPage(driver);
		shoppingCartResultPage=new ShoppingCartPage(driver);
		
		logger.info("Before Validate Search Dropdown Box");
		searchResultsPage.selectSearchDropdownBox(searchDropdownBox);
		logger.info("After Validate Search Dropdown Box");
		
		shoppingCartResultPage.enterBookNameInSerachBox(bookName);
		logger.info("After enterBookNameInSerachBox");
		
		searchResultsPage.clickOnSearchSubmitButton();
		logger.info("After clickOnSearchSubmitButton");
		
		shoppingCartResultPage.clickOnProduct();
		logger.info("After clickOnProduct");
		
		shoppingCartResultPage.clickOnBuyNowButton();
		logger.info("After clickOnBuyNowButton");
		
		Assert.assertTrue(shoppingCartResultPage.validateEmailSignInPageAppearForGuest());
		logger.info("After validateEmailSignInPageAppearForGuest");
			}

	@When("Can a guest able to register on the website")
	public void can_a_guest_able_to_register_on_the_website(DataTable table) {
		List<String> data = table.row(1);
		registerResultsPage=new RegisterResultsPage(driver);
		registerResultsPage.clickOnCreateYourAmazonAccount();
		logger.info("After clickOnCreateYourAmazonAccount");
		
		registerResultsPage.enterYourName(data.get(0));
		logger.info("After enterYourName");
		
		registerResultsPage.enterMobileNumber(data.get(1));
		logger.info("After enterMobileNumber");
		
		registerResultsPage.enterEmailId(data.get(2));
		logger.info("After enterEmailId");
		
		registerResultsPage.enterPassword(data.get(3));
		logger.info("After enterPassword");
		
		registerResultsPage.clickOnContinueButton();
		logger.info("After clickOnContinueButton");
				
	}

	@Then("Once registered can a user able to log in successfully{string}{string}")
	public void once_registered_can_a_user_able_to_log_in_successfully(String email,String pass) {
		logger.info("Before goBackToSignInPage");
		registerResultsPage.goBackToSignInPage();
		logger.info("After goBackToSignInPage");
		
		shoppingCartResultPage.enterMobileNumber(email);
		logger.info("After enterMobileNumber");
		
		shoppingCartResultPage.clickOnContinueButton();
		logger.info("After clickOnContinueButton");
		
		shoppingCartResultPage.enterPassword(pass);
		logger.info("After enterPassword");
		
		shoppingCartResultPage.clickOnSignInSubmit();
		logger.info("After clickOnSignInSubmit");
		
		shoppingCartResultPage.clickOnUseThisAddressButton();
		logger.info("After clickOnUseThisAddressButton");
		
		shoppingCartResultPage.clickOnCashOnDelivery();
		logger.info("After clickOnCashOnDelivery");
		
		shoppingCartResultPage.clickOnUseThisPaymentMethod();
		logger.info("After clickOnUseThisPaymentMethod");
		
		shoppingCartResultPage.removeProduct();
		logger.info("After removeProduct");
		
		Assert.assertTrue(shoppingCartResultPage.validateAmazonCartMessage());
		logger.info("After validateAmazonCartMessage");
		
		Assert.assertTrue(registerResultsPage.validateNewUserIsAbleToLogin());
		logger.info("After validateNewUserIsAbleToLogin");
	}

	@Then("Can a registered user able to view all the products listed on the website")
	public void can_a_registered_user_able_to_view_all_the_products_listed_on_the_website() {
		Assert.assertTrue(registerResultsPage.viewAllProducts());
		logger.info("After viewAllProducts");
	}
	
	@Then("Is the registered user able to view and modify its user account information")
	public void is_the_registered_user_able_to_view_and_modify_its_user_account_information(DataTable table)  {
		
		List<String> data = table.row(1);
		registerResultsPage.clickOnAccountAndList();
		registerResultsPage.clickOnLoginAndSecurity();
		for(String expecteddata:data) {
			Assert.assertTrue(registerResultsPage.verifyLoginDetails(expecteddata));
			
		}
		logger.info("After verifyLoginDetails");
		
	}

	@Then("Are the user sessions being manitained for the intended time period")
	public void are_the_user_sessions_being_manitained_for_the_intended_time_period() throws InterruptedException {
		Assert.assertTrue(registerResultsPage.intentedTimePeriod());
		logger.info("After intentedTimePeriod");
	}

	@Then("Is the users session timing out and expiring after a defined time")
	public void is_the_users_session_timing_out_and_expiring_after_a_defined_time() {
		Assert.assertTrue(registerResultsPage.expiringSessionPeriod());
		logger.info("After expiringSessionPeriod");
	}

	
	@Then("Is the registered user not able to access the user account after logout{string}")
	public void is_the_registered_user_not_able_to_access_the_user_account_after_logout(String pass) {
		shoppingCartResultPage=new ShoppingCartPage(driver);
		shoppingCartResultPage.enterPassword(pass);
		logger.info("After enterPassword");
		
		shoppingCartResultPage.clickOnSignInSubmit();
		logger.info("After clickOnSignInSubmit");
		
		registerResultsPage.mouseOverOnAccountsAndList();
		logger.info("After mouseOverOnAccountsAndList");
		
		Assert.assertTrue(registerResultsPage.signOutIsDisplayed());
		logger.info("After signOutIsDisplayed");
		
		registerResultsPage.clickOnSignOut();
		logger.info("After clickOnSignOut");
		
	}
}
