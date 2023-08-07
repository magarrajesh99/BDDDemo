package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class ShoppingCartPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public ShoppingCartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
		
	}

	
	@FindBy(id="twotabsearchtextbox")
	private WebElement twotabsearchtextbox;
	
	@FindBy(xpath="//a[contains(@href,'Wisdom-Ramayana-Relationships-Chaitanya-Charan')]")
	private WebElement wisdomBook;
	
	@FindBy(xpath="//span[text()=' Buy Now ']")
	private WebElement buyNow;
	
	@FindBy(id="price")
	private WebElement priceBook;
	
	@FindBy(name="quantity")
	private WebElement quantity;
	
	@FindBy(id="buy-now-button")
	private WebElement buyNowButton;
	
	@FindBy(id="shipToThisAddressButton")
	private WebElement useThisAddress ;
	
	@FindBy(xpath="//input[@value='Apply']")
	private WebElement couponApply ;
	
	@FindBy(xpath="(//span[text()='Cash on Delivery (Cash/Card/UPI)']/preceding::input[@type='radio'])[5]")
	private WebElement cashOnDelivery ;
	
	@FindBy(xpath="//span[contains(@id,'orderSummaryPrimary')]/descendant::input")
	private WebElement useThisPaymentMethod ;
	
	@FindBy(xpath="//span[text()='Qty:']")
	private WebElement quantity1 ;
	
	@FindBy(xpath="//a[text()='Delete']")
	private WebElement deleteQty ;
	
	@FindBy(xpath="//h1[contains(text(),'Your Amazon Cart is empty.')]")
	private WebElement yourAmazonCartMessage ;
	
	@FindBy(xpath="//span[text()='Hello, sign in']")
	private WebElement signIn ;
	
	@FindBy(name="email")
	private WebElement email ;
	
	@FindBy(id="continue")
	private WebElement continueButton ;
	
	@FindBy(name="password")
	private WebElement password ;
	
	@FindBy(id="signInSubmit")
	private WebElement signInSubmit ;

	
	public void enterBookNameInSerachBox(String bookName) {
		elementUtils.typeTextIntoElement(twotabsearchtextbox, bookName,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}



	public void clickOnProduct() {
		elementUtils.clickOnElement(wisdomBook,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}



	public boolean correctPriceOfBook(String bookPrice) {
		
		elementUtils.switchToChildWindow();
		if(priceBook.getText().equals(bookPrice))
		return elementUtils.displayStatusOfElement(priceBook,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		else 
			return false;
	
	}



	public void selectQuantity(String value1,String value2) {
		
		elementUtils.selectOptionInDropdown(quantity, value1);
		elementUtils.selectOptionInDropdown(quantity, value2);
				
	}



	public void clickOnBuyNowButton() {
		elementUtils.clickOnElement(buyNowButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}

	public void clickOnUseThisAddressButton() {
		elementUtils.clickOnElement(useThisAddress,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}



	public boolean validateCouponCodeOption() {
		
		return elementUtils.displayStatusOfElement(couponApply,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}



	public void clickOnCashOnDelivery() {
		elementUtils.clickOnElement(cashOnDelivery,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}



	public void clickOnUseThisPaymentMethod() {
		elementUtils.clickOnElement(useThisPaymentMethod,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}



	public void removeProduct() {
		elementUtils.clickOnElement(quantity1,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.clickOnElement(deleteQty,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}



	public boolean validateAmazonCartMessage() {
		
		return elementUtils.displayStatusOfElement(yourAmazonCartMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}



	public void clickOnSignInButton() {
		elementUtils.mouseHoverAndClick(signIn,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}



	public void enterMobileNumber(String emailName) {
		elementUtils.typeTextIntoElement(email,emailName,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}



	public void clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}



	public void enterPassword(String pass) {
		elementUtils.typeTextIntoElement(password,pass,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}



	public void clickOnSignInSubmit() {
		elementUtils.clickOnElement(signInSubmit,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	}
