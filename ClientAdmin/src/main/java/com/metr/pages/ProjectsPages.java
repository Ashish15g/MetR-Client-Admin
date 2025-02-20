package com.metr.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPages {
	public ProjectsPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public @FindBy(xpath = "//span[text()='Projects']")
	WebElement projectSection;
	public @FindBy(xpath = "//button[contains(text(),' Refresh ')]")
	WebElement refreshButton;
	public @FindBy(xpath = "//button[contains(text(),' Add new project ')]")
	WebElement addNweProject;
	public @FindBy(xpath = "//input[@name='repoName']")
	WebElement enterProjectName;
	public @FindBy(xpath = "//input[@name='repoDesc']")
	WebElement ProjectDescription;
	public @FindBy(xpath = "//button[contains(text(),' Save ')]")
	WebElement save;
	public @FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement cancel;
	public @FindBy(xpath = "//input[@id='myInput']")
	WebElement searchByProjectName;
	public @FindBy(xpath="//span[@class='project-name']")
	List<WebElement> projectsList;

}
