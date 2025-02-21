package com.metr.actiondriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.metr.base.BaseClass;

public class ActionDriver extends BaseClass {

	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	public static JavascriptExecutor js = (JavascriptExecutor) driver;

	// Method to highlight an element with a specific border color
	public static void highlightElement(WebElement element, String color) {
		js.executeScript("arguments[0].style.border='3px solid " + color + "'", element);
	}

	// Method to click an element
	public static void click(WebElement element) {
		try {
			waitForElementToBeClickable(element);
			element.click();
		} catch (Exception e) {
			System.out.println("Unable to click element: " + e.getMessage());
		}
	}

	// Method to enter text into input filed
	public static void enterText(WebElement element, String value) {
		try {
			waitForElementToBeVisible(element);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Unable to enter the value in input box: " + e.getMessage());
		}
	}

	// wait for element to be clickable
	public static void waitForElementToBeClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			System.out.println("element is not clickable: " + e.getMessage());
		}
	}

	// Method to get text from an input field
	public String getText(WebElement element) {
		try {
			waitForElementToBeVisible(element);
			return element.getText();
		} catch (Exception e) {
			System.out.println("Unable to getText: " + e.getLocalizedMessage());
			return "";
		}

	}

	// Wait for the Page to Load
	public static void waitForPageLoad(int timeOutInSec) {
		try {
			wait.withTimeout(Duration.ofSeconds(timeOutInSec)).until(WebDriver -> ((JavascriptExecutor) WebDriver)
					.executeScript("return document.readyState").equals("complete"));
			System.out.println("Page loaded successfully.");
		} catch (Exception e) {
			System.out.println("Page did not load within " + timeOutInSec + " secondes. Exception: " + e.getMessage());
		}
	}

	// Scroll to an element
	public void scrollToElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// WebElement element1 = driver.findElement((By) element);
			element = driver.findElement((By) element);
			js.executeScript("arguments[0],sccrollIntoView(true)", element);
		} catch (Exception e) {
			System.out.println("Unable to locate element:" + e.getMessage());
		}
	}

	// wait for element to be Visible
	public static void waitForElementToBeVisible(WebElement uname) {
		try {
			wait.until(ExpectedConditions.visibilityOf(uname));
		} catch (Exception e) {
			System.out.println("Element is not visible: " + e.getMessage());
		}

	}

	// Simplified the method and remove redundant condition
	public boolean isDisplayed(WebElement element) {
		try {
			waitForElementToBeVisible(element);
			return driver.findElement((By) element).isDisplayed();
		} catch (Exception e) {
			System.out.println("Element is not displayed: " + e.getMessage());
			return false;
		}
	}

	// implicit wait
	public static void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	public static void jsClick(WebElement element) {
		try {
			waitForElementToBeClickable(element);
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			System.out.println("Unable to click element: " + e.getMessage());
		}
	}
}
