package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchDomainPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public SearchDomainPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//button[text()='Domains']")
	private WebElement domains;
	
	@FindBy(xpath = "//a[text()='Domain Name Search' and contains(@data-track-name,'domain_name_search')]")
	private WebElement domainNameSearch;
	
	@FindBy(xpath = "//button[contains(@class,'button-primary')]")
	private WebElement searchBox;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Find your best domain')]")
	private WebElement findYourBestDoman;
	
	@FindBy(xpath = "//span[text()='Add to Cart']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//span[text()='mydomain.com']")
	private WebElement myDomainName;
	
	@FindBy(id = "hcViewCart")
	private WebElement viewCart;
	
	@FindBy(xpath = "//span[text()='Subtotal:']/following::span[contains(@class,'subtotal')]")
	private WebElement subTotal;
	
	@FindBy(xpath = "//span[text()='mydomain.com']")
	private WebElement myDomain;
		
	public void clickOnDomains() {
		elementUtils.clickOnElement(domains,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}


	public boolean domainNameSearchIsDisplayed() {
		return elementUtils.displayStatusOfElement(domainNameSearch,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}


	public void clickOnDomainNameSearch() {
		elementUtils.clickOnElement(domainNameSearch,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}


	public String getTitleOfSearchDomainName() {
		return driver.getTitle();
		
		
	}


	public boolean searchBoxIsPresent() {
		return elementUtils.displayStatusOfElement(findYourBestDoman,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}


	public boolean searchBoxIsEnabled() {
		return elementUtils.displayEnabledStatusOfElement(findYourBestDoman,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}


	public void enterDomainNameInSearchBox(String domainName) {
		elementUtils.typeTextIntoElement(findYourBestDoman,domainName,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
			
	}


	public void clickOnAddToCart() {
		elementUtils.clickOnElement(addToCart,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}


	public boolean domainNameIsPresent() {
		 return elementUtils.displayStatusOfElement(myDomainName,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}


	public boolean addToCartIsPresent() {
		return elementUtils.displayStatusOfElement(addToCart,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}


	public void clickOnViewCartButton() {
		elementUtils.clickOnElement(viewCart,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}


	public String verifyPriceOfDomainName() {
		return subTotal.getText().trim();
	}


	public String verifyDomainName() {
		return myDomain.getText().trim();
	}


	public void clickOnSearchBox() {
		elementUtils.clickOnElement(searchBox,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}


	}
