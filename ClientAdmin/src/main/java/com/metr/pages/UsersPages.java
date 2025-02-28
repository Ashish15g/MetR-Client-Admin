package com.metr.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPages {
	public UsersPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Heat Users Navigation section
	public @FindBy(xpath = "//span[text()='Users']")
	WebElement navigetUsersSection;
	// Click Add users button
	public @FindBy(xpath = "//button[contains(text(),'Add User')]") 
	WebElement addUsers;
	// Enter UserName
	public @FindBy(id = "addf_username") 
	WebElement userName;
	// Select project
	public @FindBy(xpath = "//span[contains(text(),'Please select a project')]") 
	WebElement selectProject;
	//Select project Name
	public @FindBy(xpath = "//span[text()='List is empty.']")
	List<WebElement> projectListName;
	// Email Address
	public @FindBy(id = "addf_email")
	WebElement emailAddress;
	// Password *[[id="addf_password"]
	public @FindBy(id = "addf_password") 
	WebElement password;
	// Github Username
	public @FindBy(id = "addf_githubUsername") 
	WebElement githubUsername;
	// Github Email Address
	public @FindBy(id = "addf_githubEmail") 
	WebElement githubEmail;
	//View remaining credits(Enable or Desable)
	public @FindBy(xpath = "//span[text()='Enable']") 
	WebElement buttonEnable;
	public @FindBy(xpath = "//span[text()='Disable']") 
	WebElement buttonDisable;
	// Save or Cancel 
	public @FindBy(xpath = "//button[contains(text(),'Save')]") 
	WebElement saveButton;
	public @FindBy(xpath = "//button[contains(text(),'Cancel')]") 
	WebElement cancelButton;

}
