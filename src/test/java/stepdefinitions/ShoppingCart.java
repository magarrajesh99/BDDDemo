package stepdefinitions;

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
	
	@Given("User Sign in Amazon website{string}{string}")
	public void user_sign_in_amazon_website_mar$(String email, String pass) {
		driver = DriverFactory.getDriver();
		searchResultsPage=new SearchResultsPage(driver);
		shoppingCartResultPage=new ShoppingCartPage(driver);
		shoppingCartResultPage.clickOnSignInButton();
		shoppingCartResultPage.enterMobileNumber(email);
		shoppingCartResultPage.clickOnContinueButton();
		shoppingCartResultPage.enterPassword(pass);
		shoppingCartResultPage.clickOnSignInSubmit();
		
	}

	@Given("Is the correct price getting displayed in the shopping cart for the selected products {string}{string}{string}")
	public void is_the_correct_price_getting_displayed_in_the_shopping_cart_for_the_selected_products(String searchDropdownBox,String bookName,String bookPrice) throws InterruptedException {
		
		searchResultsPage.selectSearchDropdownBox(searchDropdownBox);
		shoppingCartResultPage.enterBookNameInSerachBox(bookName);
		searchResultsPage.clickOnSearchSubmitButton();
		shoppingCartResultPage.clickOnProduct();
		Assert.assertTrue(shoppingCartResultPage.correctPriceOfBook(bookPrice));
		Thread.sleep(2000);
	}
	
	@Then("Can a user increase or decrease the quantity of a product from shopping cart{string}{string}")
	public void can_a_user_increase_or_decrease_the_quantity_of_a_product_from_shopping_cart(String value1,String value2) {
		shoppingCartResultPage.selectQuantity(value1,value2);
		shoppingCartResultPage.clickOnBuyNowButton();
		shoppingCartResultPage.clickOnUseThisAddressButton();
	}

	@When("Is there an option to apply coupn codes")
	public void is_there_an_option_to_apply_coupn_codes() {
		Assert.assertTrue(shoppingCartResultPage.validateCouponCodeOption());
	}

	

	@Then("Can a user remove the product from the shopping cart")
	public void can_a_user_remove_the_product_from_the_shopping_cart() throws InterruptedException {
		shoppingCartResultPage.clickOnCashOnDelivery();
		Thread.sleep(2000);
		shoppingCartResultPage.clickOnUseThisPaymentMethod();
		shoppingCartResultPage.removeProduct();
		Assert.assertTrue(shoppingCartResultPage.validateAmazonCartMessage());
	}

}
