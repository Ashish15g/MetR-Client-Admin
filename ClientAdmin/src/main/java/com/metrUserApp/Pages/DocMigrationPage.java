package com.metrUserApp.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocMigrationPage {
	public DocMigrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//DocMirations Web elements
	//Navigate to the DocMigrations section
	public @FindBy(xpath = "//span[text()='DocMigration']")
	WebElement docMigration;
	/*
	 * public @FindBy() WebElement public @FindBy() WebElement public @FindBy()
	 * WebElement public @FindBy() WebElement public @FindBy() WebElement
	 * public @FindBy() WebElement public @FindBy() WebElement
	 */
}
