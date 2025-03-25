package com.metrUserApp.Pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocPublisherPage {
	public DocPublisherPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}
	//DocPublisher WebElements
	//Navigate to the DocPublisher section
	public @FindBy(xpath = "//span[text()='DocPublisher']")
	WebElement docPublisher;
	//Select Project* section
	public @FindBy(xpath = "//input[@placeholder='Choose a Project']")
	WebElement projectSection;
	//Choose project*
	public @FindBy(xpath = "//li[starts-with(@id,'null-')]")
	List<WebElement> chooseProject;
	//Select Branch*
	public @FindBy(xpath = "//input[@placeholder='Choose a branch']")
	WebElement branchSection;
	//
	public @FindBy(xpath = "//button[contains(text(),'Next')]")
	WebElement nextButton;
	//
	//public @FindBy()
	//WebElement
	//
	//public @FindBy()
	//WebElement
	//
	//public @FindBy()
	//WebElement
	//
	//public @FindBy()
	//WebElement
	//
	//public @FindBy()
	//WebElement
	//
	//public @FindBy()
	//WebElement
	//
	//public @FindBy()
	//WebElement
	
}
