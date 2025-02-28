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
	public @FindBy(xpath="//div[text()='Project get Successfully']")
	//Project section Heat Success Message.
	WebElement success_Msg;
	public @FindBy(xpath = "//button[contains(text(),' Add new project ')]")
	WebElement addNweProject;
	public @FindBy(xpath = "//input[@name='repoName']")
	WebElement enterProjectName;
	public @FindBy(xpath = "//input[@name='repoDesc']")
	WebElement ProjectDescription;
	public @FindBy(xpath = "//button[contains(text(),' Save ')]")
	WebElement save;
	//New Project Added successfully conformation Massege.
	public @FindBy(xpath = "//div[text()='Project Sync Successfully']")
	WebElement ProjAddAndSyncSucfully;
	public @FindBy(xpath = "//button[contains(text(),' Refresh ')]")
	WebElement refreshButton;
	//Project refresh Success Message
	public @FindBy(xpath = "//div[text()='Project Sync Successfully']")
	WebElement refreshSucfullyMsg;
	public @FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement cancel;
	
	//Search Project By Name
	public @FindBy(xpath = "//input[@id='myInput']")
	WebElement searchByProjectName;
	public @FindBy(xpath="//span[@class='project-name']")
	List<WebElement> projectsList;
	
	
	//View project Details
	public @FindBy(xpath = "//div[contains(text(),'View details ')]")
	List<WebElement> viewDetails;
	
	public @FindBy(xpath = "//div[contains(text(),'View details ')]")
	 WebElement view_button;
	
	public @FindBy(xpath = "//button[contains(text(),' Add collaborators ')]")
	WebElement addCollaborators;
	public @FindBy(xpath = "//div[text()='Collaborators array cannot be empty.']")
	WebElement cannotBeEmpty;
	public @FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement clncelButton;
	//Enter Collaborator name or UserName 
	public @FindBy(xpath = "//span[contains(text(),'Enter usernames')]")
	WebElement enterUserNames;
	public @FindBy(xpath = "//input[@id='updatef_projects']")
	WebElement enterUserName;
	public @FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submitButton;
	// Collaborators added successfully
	public @FindBy(xpath = "//div[text()='Collaborators added.']")
	WebElement collaboratorsAdded;
	//Collaboratore checkBox
	public @FindBy(xpath = "//input[starts-with(@id, 'checkbox-')]")
	WebElement checkBox;
	//Delete collaborators
	public @FindBy(xpath = "//button[contains(text(),'Delete collaborators')]")
	WebElement deleteCollaborators;
	//Remove Collaborators
	public @FindBy(xpath = "//button[text()='Remove']")
	WebElement removeCollaborators;
	//Collaborators removed successfully
	public @FindBy(xpath = "//div[text()='Collaborators removed.']")
	WebElement collaboratorsRemovedScMsg;
	//Delete ptoject
	public @FindBy(xpath="//button[@class='btn']")
	List<WebElement> deleteProjectsList;
	public @FindBy(xpath = "//input[@class='form-control']")
	WebElement deleteProjectName;
	public @FindBy(xpath = "//button[text()=' Delete this repository ']")
	WebElement deleteThisRepository;
	public @FindBy(xpath = "//p[@class='h4']")
	WebElement textDeleteProject1;
	//Delete project Success Notification Massege
	public @FindBy(xpath = "//div[text()='Project deleted successfully.']")
	WebElement projDletdSucfullyMsg;
	

}
