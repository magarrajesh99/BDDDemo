package stepdefinitions;

import java.util.List;

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
		
	@Given("Can a guest purchage product as a guest user{string}{string}{string}")
	public void can_a_guest_purchage_product_as_a_guest_user(String searchDropdownBox, String bookName,String bookPrice) throws InterruptedException {
		driver = DriverFactory.getDriver();
		searchResultsPage=new SearchResultsPage(driver);
		shoppingCartResultPage=new ShoppingCartPage(driver);
		searchResultsPage.selectSearchDropdownBox(searchDropdownBox);
		shoppingCartResultPage.enterBookNameInSerachBox(bookName);
		searchResultsPage.clickOnSearchSubmitButton();
		shoppingCartResultPage.clickOnProduct();
		shoppingCartResultPage.clickOnBuyNowButton();
		Assert.assertTrue(shoppingCartResultPage.validateEmailSignInPageAppearForGuest());
			}

	@When("Can a guest able to register on the website")
	public void can_a_guest_able_to_register_on_the_website(DataTable table) {
		List<String> data = table.row(1);
		registerResultsPage=new RegisterResultsPage(driver);
		registerResultsPage.clickOnCreateYourAmazonAccount();
		registerResultsPage.enterYourName(data.get(0));
		registerResultsPage.enterMobileNumber(data.get(1));
		registerResultsPage.enterEmailId(data.get(2));
		registerResultsPage.enterPassword(data.get(3));
		registerResultsPage.clickOnContinueButton();
				
	}

	@Then("Once registered can a user able to log in successfully{string}{string}")
	public void once_registered_can_a_user_able_to_log_in_successfully(String email,String pass) {
		registerResultsPage.goBackToSignInPage();
		shoppingCartResultPage.enterMobileNumber(email);
		shoppingCartResultPage.clickOnContinueButton();
		shoppingCartResultPage.enterPassword(pass);
		shoppingCartResultPage.clickOnSignInSubmit();
		shoppingCartResultPage.clickOnUseThisAddressButton();
		shoppingCartResultPage.clickOnCashOnDelivery();
		shoppingCartResultPage.clickOnUseThisPaymentMethod();
		shoppingCartResultPage.removeProduct();
		Assert.assertTrue(shoppingCartResultPage.validateAmazonCartMessage());
		
		Assert.assertTrue(registerResultsPage.validateNewUserIsAbleToLogin());
	}

	@Then("Can a registered user able to view all the products listed on the website")
	public void can_a_registered_user_able_to_view_all_the_products_listed_on_the_website() {
		Assert.assertTrue(registerResultsPage.viewAllProducts());
	}
	
	@Then("Is the registered user able to view and modify its user account information")
	public void is_the_registered_user_able_to_view_and_modify_its_user_account_information(DataTable table)  {
		
		List<String> data = table.row(1);
		registerResultsPage.clickOnAccountAndList();
		registerResultsPage.clickOnLoginAndSecurity();
		for(String expecteddata:data) {
			Assert.assertTrue(registerResultsPage.verifyLoginDetails(expecteddata));
		}
		
	}

	@Then("Are the user sessions being manitained for the intended time period")
	public void are_the_user_sessions_being_manitained_for_the_intended_time_period() throws InterruptedException {
		Assert.assertTrue(registerResultsPage.intentedTimePeriod());
	}

	@Then("Is the users session timing out and expiring after a defined time")
	public void is_the_users_session_timing_out_and_expiring_after_a_defined_time() {
		Assert.assertTrue(registerResultsPage.expiringSessionPeriod());
	}

	
	@Then("Is the registered user not able to access the user account after logout{string}")
	public void is_the_registered_user_not_able_to_access_the_user_account_after_logout(String pass) {
		shoppingCartResultPage=new ShoppingCartPage(driver);
		shoppingCartResultPage.enterPassword(pass);
		shoppingCartResultPage.clickOnSignInSubmit();
		registerResultsPage.mouseOverOnAccountsAndList();
		Assert.assertTrue(registerResultsPage.signOutIsDisplayed());
		registerResultsPage.clickOnSignOut();
		
	}
}
