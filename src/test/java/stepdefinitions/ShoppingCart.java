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
import pages.ShoppingCartPage;

public class ShoppingCart {

	WebDriver driver;
	SearchResultsPage searchResultsPage;
	ShoppingCartPage shoppingCartResultPage;
	private static final Logger logger = LogManager.getLogger(ShoppingCart.class);

	@Given("User Sign in Amazon website{string}{string}")
	public void user_sign_in_amazon_website_mar$(String email, String pass) {
		driver = DriverFactory.getDriver();
		searchResultsPage = new SearchResultsPage(driver);
		shoppingCartResultPage = new ShoppingCartPage(driver);
		shoppingCartResultPage.clickOnSignInButton();
		logger.info("After clickOnSignInButton");
		
		shoppingCartResultPage.enterMobileNumber(email);
		logger.info("After enterMobileNumber");
		
		shoppingCartResultPage.clickOnContinueButton();
		logger.info("After clickOnContinueButton");
		
		shoppingCartResultPage.enterPassword(pass);
		logger.info("After enterPassword");
		
		shoppingCartResultPage.clickOnSignInSubmit();
		logger.info("After clickOnSignInSubmit");

	}

	@Given("Is the correct price getting displayed in the shopping cart for the selected products{string}{string}")
	public void is_the_correct_price_getting_displayed_in_the_shopping_cart_for_the_selected_products(
			String searchDropdownBox, String bookName) {

		searchResultsPage.selectSearchDropdownBox(searchDropdownBox);
		logger.info("After selectSearchDropdownBox");

		
		shoppingCartResultPage.enterBookNameInSerachBox(bookName);
		logger.info("After enterBookNameInSerachBox");
		
		searchResultsPage.clickOnSearchSubmitButton();
		logger.info("After clickOnSearchSubmitButton");
		
		shoppingCartResultPage.clickOnProduct();
		logger.info("After clickOnProduct");
		
		Assert.assertTrue(shoppingCartResultPage.correctPriceOfBook());
		logger.info("After correctPriceOfBook");

	}

	@Then("Can a user increase or decrease the quantity of a product from shopping cart{string}{string}")
	public void can_a_user_increase_or_decrease_the_quantity_of_a_product_from_shopping_cart(String value1,
			String value2) {
		shoppingCartResultPage.selectQuantity(value1, value2);
		logger.info("After selectQuantity");
		
		shoppingCartResultPage.clickOnBuyNowButton();
		logger.info("After clickOnBuyNowButton");
		
		Assert.assertTrue(shoppingCartResultPage.verifyProductPrice());
		logger.info("After verifyProductPrice");
		
		shoppingCartResultPage.clickOnUseThisAddressButton();
		logger.info("After clickOnUseThisAddressButton");
	}

	@When("Is there an option to apply coupn codes")
	public void is_there_an_option_to_apply_coupn_codes() {
		Assert.assertTrue(shoppingCartResultPage.validateCouponCodeOption());
		logger.info("After validateCouponCodeOption");
		
	}

	@Then("Can a user remove the product from the shopping cart")
	public void can_a_user_remove_the_product_from_the_shopping_cart() throws InterruptedException {
		shoppingCartResultPage.clickOnCashOnDelivery();
		logger.info("After clickOnCashOnDelivery");
		
		shoppingCartResultPage.clickOnUseThisPaymentMethod();
		logger.info("After clickOnUseThisPaymentMethod");
		
		shoppingCartResultPage.removeProduct();
		logger.info("After removeProduct");
		
		Assert.assertTrue(shoppingCartResultPage.validateAmazonCartMessage());
		logger.info("After validateAmazonCartMessage");
	}

}
