package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchResultsPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public SearchResultsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//select[@id='searchDropdownBox']")
	private WebElement allCategoriesDropdown;

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchSubmitButton;

	@FindBy(xpath = "//span[text()='New Arrivals']")
	private WebElement newArrivals;

	@FindBy(xpath = "//span[text()='Price']")
	private WebElement price;

	@FindBy(xpath = "//span[text()='Avg. Customer Review']")
	private WebElement avgCustomerReview;

	@FindBy(xpath = "//span[text()='English' and contains(@class,'size')]")
	private WebElement englishLanguage;

	@FindBy(xpath = "//span[text()='Sort by:']")
	private WebElement sortByDropdown;

	@FindBy(xpath = "//a[text()='Price: Low to High']")
	private WebElement lowToHigh;

	@FindBy(xpath = "//a[text()='Price: High to Low']")
	private WebElement highToLow;

	@FindBy(xpath = "//h2/parent::div/parent::div//div[contains(@class,'top-micro')]//span[@class='a-price-whole']")
	private List<WebElement> resultValues;

	@FindBy(xpath = "//span[contains(text(),'of over')]")
	private WebElement overResults;

	public boolean validateSearchDropdownBox() {
		return elementUtils.selectOptionContains(allCategoriesDropdown);
	}

	public void selectSearchDropdownBox(String searchDropdownBox) {
		elementUtils.selectOptionInDropdown(allCategoriesDropdown, searchDropdownBox);
	}

	public void clickOnSearchSubmitButton() {
		elementUtils.clickOnElement(searchSubmitButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public boolean validateMultileFilters() {

		boolean newArrivalsStatus = elementUtils.displayStatusOfElement(newArrivals,
				CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		boolean priceStatus = elementUtils.displayStatusOfElement(price, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		boolean avgCustomerReviewStatus = elementUtils.displayStatusOfElement(avgCustomerReview,
				CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		if (newArrivalsStatus && priceStatus && avgCustomerReviewStatus)
			return true;
		else
			return false;

	}

	public void clickOnChildrenBooks() {
		elementUtils.clickOnElement(englishLanguage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public boolean validateSortByDropdown() {
		return elementUtils.displayStatusOfElement(sortByDropdown, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void clickOnSortByButton() {
		elementUtils.clickOnElement(sortByDropdown, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void selectPriceLowtoHigh(String low) {
		elementUtils.clickOnElement(lowToHigh, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.sortingOrderAscending(resultValues, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void selectPriceHighToLow(String high) {
		elementUtils.clickOnElement(highToLow, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.sortingOrderDescending(resultValues, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public boolean validateFixedNumberOfProducts() {
		return elementUtils.displayStatusOfElement(overResults, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

}
