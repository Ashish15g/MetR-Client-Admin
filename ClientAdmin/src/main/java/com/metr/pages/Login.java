package com.metr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.metr.actiondriver.ActionDriver;

public class Login {
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath = "//input[@id='email']") 
	WebElement uname;

	private @FindBy(xpath = "//input[@id=\"userpassword\"]")
	WebElement password;

	private @FindBy(xpath = "//*[text()=' I agree to the ']") 
	WebElement checkbox;

	private @FindBy(xpath = "//button[@type='submit']") 
	WebElement button;
	//// button[contains(text(),'Logout')]->(//button[text()='Logout'])
	public @FindBy(xpath = "//button[contains(text(),'Logout')]") 
	WebElement logout;

	public @FindBy(xpath = "//button[text()='OK']") 
	WebElement Logout_successful_ok;

	public void enterUsername(String email) {
		// uname.sendKeys(email);
		ActionDriver.highlightElement(uname, "green");
		ActionDriver.enterText(uname, email);
	}

	public void enterPassword(String pass) {
		// password.sendKeys(pass);
		ActionDriver.highlightElement(password, "green");
		ActionDriver.enterText(password, pass);
	}

	public void selectCheckBox() {
		// checkbox.click();
		ActionDriver.highlightElement(checkbox, "green");
		ActionDriver.click(checkbox);
	}

	public void clickSubmit() {
		// button.click();
		ActionDriver.highlightElement(button, "green");
		ActionDriver.click(button);
	}

	public void logOut() {
		// logout.click();
		ActionDriver.highlightElement(logout, "green");
		ActionDriver.click(logout);
	}

	// LogOut webElement.
	public @FindBy(xpath = " //span[contains(text(),'Development')]") WebElement development_option;

	private @FindBy(xpath = " //a[contains(text(),' Logout')]") WebElement lgOut;
	private @FindBy(xpath = "//button[text()='Logout']") WebElement finLOut;

	public @FindBy(xpath = "//div[@class=\"alert alert-dismissible alert-danger\"]") WebElement invalid_credential;

	public void DevLogOut() throws InterruptedException {
		Thread.sleep(50000);
		ActionDriver.highlightElement(development_option, "green");
		ActionDriver.waitForElementToBeClickable(development_option);
		ActionDriver.click(development_option);
		// development_option.click();
		// lgOut.click();
		ActionDriver.highlightElement(lgOut, "green");
		ActionDriver.click(lgOut);
		Thread.sleep(6000);
		// finLOut.click();
		ActionDriver.highlightElement(finLOut, "green");
		ActionDriver.click(finLOut);
	}

}
