package pages;

import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterResultsPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public RegisterResultsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(id = "createAccountSubmit")
	private WebElement createAccountSubmit;

	@FindBy(name = "customerName")
	private WebElement customerName;

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(id = "ap_email")
	private WebElement emailOptional;

	@FindBy(id = "ap_password")
	private WebElement password;

	@FindBy(id = "continue")
	private WebElement continueButton;

	@FindBy(xpath = "//span[text()='Hello, Rajesh']")
	private WebElement helloUser;

	@FindBy(id = "searchDropdownBox")
	private WebElement searchDropdownBox;

	@FindBy(xpath = "//span[text()='Account & Lists']")
	private WebElement accountAndList;

	@FindBy(xpath = "//h2[contains(text(),'Login & security')]")
	private WebElement loginAndSecurity;

	@FindBy(xpath = "//span[text()='Account & Lists']")
	private List<WebElement> loginAndSecurityWebElements;

	@FindBy(xpath = "//span[text()='Sign Out']")
	private WebElement signOut;

	@FindBy(xpath = "//[text()='expired']")
	private WebElement expired;

	public void clickOnCreateYourAmazonAccount() {
		elementUtils.clickOnElement(createAccountSubmit, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterYourName(String string) {
		elementUtils.typeTextIntoElement(customerName, string, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterMobileNumber(String string) {
		elementUtils.typeTextIntoElement(email, string, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterEmailId(String string) {
		elementUtils.typeTextIntoElement(emailOptional, string, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void enterPassword(String string) {
		elementUtils.typeTextIntoElement(password, string, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void goBackToSignInPage() {
		driver.navigate().back();
		driver.navigate().back();
	}

	public boolean validateNewUserIsAbleToLogin() {
		return elementUtils.displayStatusOfElement(helloUser, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public boolean viewAllProducts() {
		return elementUtils.selectOptionContains(searchDropdownBox);

	}

	public void clickOnAccountAndList() {
		elementUtils.clickOnElement(accountAndList, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void clickOnLoginAndSecurity() {
		elementUtils.clickOnElement(loginAndSecurity, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public boolean verifyLoginDetails(String expecteddata) {

		return driver
				.findElement(By.xpath("//div[contains(@class,'a-row') and contains(text(),'" + expecteddata + "')]"))
				.isDisplayed();

	}

	public void mouseOverOnAccountsAndList() {
		elementUtils.mouseHover(accountAndList, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public boolean signOutIsDisplayed() {

		return elementUtils.displayStatusOfElement(signOut, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void clickOnSignOut() {
		elementUtils.clickOnElement(signOut, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public Boolean intentedTimePeriod() throws InterruptedException {

		Date date = new Date();
		String currentDate = (date.toString().trim());
		// display time and date using toString()
		System.out.println(currentDate);
		Thread.sleep(1200000);

		elementUtils.clickOnElement(accountAndList, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.clickOnElement(loginAndSecurity, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		date = new Date();
		String lastDate = (date.toString().trim());
		// display time and date using toString()
		System.out.println(lastDate);

		if (elementUtils.displayStatusOfElement(password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME))
			return true;
		else
			return false;

	}

	public Boolean expiringSessionPeriod() {
		if (elementUtils.displayStatusOfElement(password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME))
			return true;
		else
			return false;
	}

}
