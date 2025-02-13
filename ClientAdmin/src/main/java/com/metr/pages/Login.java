package com.metr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath = "//input[@id='email']") WebElement uname;

	private @FindBy(xpath = "//input[@id=\"userpassword\"]") WebElement password;

	private @FindBy(xpath = "//*[text()=' I agree to the ']") WebElement checkbox;

	private @FindBy(xpath = "//button[@type='submit']") WebElement button;

	public @FindBy(xpath = "//button[text()='Logout']") WebElement logout;

	public @FindBy(xpath = "//button[text()='OK']") WebElement Logout_successful_ok;

	public void enterUsername(String email) {
		uname.sendKeys(email);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void selectCheckBox() {
		checkbox.click();
	}

	public void clickSubmit() {
		button.click();
	}

	public void logOut() {
		logout.click();
	}

	// LogOut webElement.
	public @FindBy(xpath = " //span[contains(text(),'Development')]") 
	WebElement development_option;

	private @FindBy(xpath = " //a[contains(text(),' Logout')]") 
	WebElement lgOut;
	private @FindBy(xpath = "//button[text()='Logout']")
	WebElement finLOut;
	
	public @FindBy(xpath="//div[@class=\"alert alert-dismissible alert-danger\"]")
	WebElement invalid_credential;

	public void DevLogOut() throws InterruptedException {
		Thread.sleep(3000);
		development_option.click();
		lgOut.click();
		Thread.sleep(6000);
		finLOut.click();
	}
	
	
	
	
}
