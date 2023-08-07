package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {

		this.driver = driver;

	}

	public void clickOnElement(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();

	}

	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);

	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {

		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return webElement;

	}

	public void selectOptionInDropdown(WebElement element, String dropDownOption) {

		Select select = new Select(element);
		select.selectByVisibleText(dropDownOption);
//		System.out.println(element.isEnabled());

	}

	public boolean selectOptionContains(WebElement element) {

		Select select = new Select(element);
		List<WebElement> searchDropdownBox = select.getOptions();
		for (WebElement singlesearchDropdownBox : searchDropdownBox) {
			System.out.println(singlesearchDropdownBox.getText());
		}
		if (searchDropdownBox.size() > 1)
			return true;
		else
			return false;

	}

	public void dismissAlert(long durationInSeconds) {

		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();

	}

	public Alert waitForAlert(long durationInSeconds) {

		Alert alert = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return alert;

	}

	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();

	}

	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {

		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return webElement;

	}

	public void javaScriptClick(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click();", webElement);

	}

	public void javaScriptType(WebElement element, long durationInSeconds, String textToBeTyped) {

		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='" + textToBeTyped + "'", webElement);

	}

	public String getTextFromElement(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		return webElement.getText();

	}

	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {

		try {
			WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
			return webElement.isDisplayed();
		} catch (Throwable e) {
			return false;
		}

	}

	public void sortingOrderAscending(List<WebElement> actualPrices, long durationInSeconds) {

		List<Integer> prices = new ArrayList<Integer>();
		for (WebElement e : actualPrices) {
			String str = e.getText();
			if (str.contains(",")) {
				str = str.replaceAll(",", "");
				Integer values = Integer.parseInt(str);
				prices.add(values);
			} else {
				prices.add(Integer.parseInt(str));
			}

		}

		List<Integer> pricesList = new ArrayList<Integer>(prices);

		// sort the list
		Collections.sort(pricesList);
		System.out.println("sorted \n" + pricesList);
		System.out.println("normal \n" + prices);

		// true if the prices are sorted
		System.out.println(pricesList.equals(prices));

	}

	public void sortingOrderDescending(List<WebElement> actualPrices, long durationInSeconds) {

		List<Integer> prices = new ArrayList<Integer>();
		for (WebElement e : actualPrices) {
			String str = e.getText();
			if (str.contains(",")) {
				str = str.replaceAll(",", "");
				Integer values = Integer.parseInt(str);
				prices.add(values);
			} else {
				prices.add(Integer.parseInt(str));
			}

		}

		List<Integer> pricesList = new ArrayList<Integer>(prices);

		// sort the list
		Collections.sort(pricesList, Collections.reverseOrder());
		System.out.println("sorted \n" + pricesList);
		System.out.println("normal \n" + prices);

		// true if the prices are sorted
		System.out.println(pricesList.equals(prices));

	}
	
	public void switchToChildWindow() {

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		
		System.out.println("Parent Window Id"+winHandleBefore);

		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			
			if(!winHandle.equals(winHandleBefore))
			{
		    driver.switchTo().window(winHandle);
		    System.out.println("Child Window Id"+winHandle);
			}
		}


	}

}
