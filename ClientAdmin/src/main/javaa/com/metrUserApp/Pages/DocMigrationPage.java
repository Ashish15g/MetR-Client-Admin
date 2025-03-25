package com.metrUserApp.Pages;

import java.util.List;

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
	//Click input source type
	public @FindBy(xpath = "//div[@class='multiselect__tags']") 
	WebElement selectInputSource;
	//Select input source type DOCS, HTML and MD
	 public @FindBy(xpath = "//li[@class='multiselect__element']") 
	 List<WebElement> inputType;
	 //Upload input source file*
	 public @FindBy(xpath = "//img[@src='/img/upload.600f76dc.svg']")
	 WebElement uploadFile;
	 //Reset
	 public @FindBy(xpath = "//button[contains(text(),'Reset')]")
	 WebElement resetButton;
	 //Select checkbox
	 public @FindBy(xpath = "//input[@class='custom-control-input']") 
	 WebElement checkBox;
	 //Upload Button
	 public @FindBy(xpath = "//button[contains(text(),'Upload')]")
	 WebElement uploadButton;
	 //Docx File containing pages uploaded successfully.["//strong[text()='Success']"
	 public @FindBy(xpath = "//strong[text()='Success']") 
	 WebElement successMsg;
	 //Pre-flight Check
	 public @FindBy(xpath = "//button[contains(text(),'Pre-flight Check')]") 
	 WebElement preFlight;
	 //Back to Upload file
	 public @FindBy(xpath = "//button[contains(text(),'Back')]")
	 WebElement backButton;
	 //Transformation Convert Now
	 public @FindBy(xpath = "//button[contains(text(),'Convert Now')]") 
	 WebElement convertNow;
	 //View Warning and Error Logs Verify Now/No
	 public @FindBy(xpath = "//button[text()='Verify Now']") 
	 WebElement verifyNow;
	 //No view the logs, go to the direct download or the GitHub commit. 
	 public @FindBy(xpath = "//button[(text()='No')])[2]") 
	 WebElement no;
	 //Download Log and DITA Output file
	 public @FindBy(id = "save") 
	 WebElement download;
	 //View generated output Log
	 public @FindBy(xpath = "//span[text()='View generated output']") 
	 WebElement viewLog;
	 //Nevigate to DITA output file Commit on Githubgit
	 public @FindBy(id = "github") 
	 WebElement gitHub;
	 //Select a project section
	 public @FindBy(xpath = "//span[contains(text(),'Choose a project')]") 
	 WebElement projectSectionGit;
	 //Select Project to create new branch on gitHub
	 public @FindBy(id = "multiselect__element") 
	 WebElement chooseProject;
	 //click Create new branch button
	 public @FindBy(xpath = "//button[contains(text(),'Create new branch')]") 
	 WebElement newBranchCreate;
	 //Select or Choose Base Branch on git
	 public @FindBy(xpath = "//span[contains(text(),'Choose a branch')]") 
	 WebElement chooseBranch;
	 //Select/ choose given Branch options[//span[text()='main']
	 public @FindBy(xpath = "//li[starts-with(@id,'null-')]") 
	 List<WebElement> branchSelected;
	 public @FindBy(xpath = "(//span[text()='main'])[1]") 
	 WebElement brcSelectedMain;
	 //New Branch Name* text box
	 public @FindBy(id = "newBranchName") 
	 WebElement newBranchName;
	 //Create new branch final submit Button 
	 public @FindBy(xpath = "(//button[contains(text(),'Create new branch')])[2]") 
	 WebElement newBranchSubmit;
	 //Branch "Random_Name" checked out successfully.
	 public @FindBy(xpath = "//strong[text()='Branch checkout']") 
	 WebElement brSuccessMsg;
	 //git commit button
	 public @FindBy(xpath = "//button[contains(text(),'Commit')]") 
	 WebElement gitCommit;	 
	 //GitHub Sync
	 public @FindBy(xpath = "//button[contains(text(),'Sync')]") 
	 WebElement gitHubSync;
	 //Add description to submit and commit.
	 public @FindBy(id = "swal2-input") 
	 WebElement subComDescriptions;
	 //Add description to submit button
	 public @FindBy(xpath = "//button[text()='Submit']")
	 WebElement submmit;
	 //GitHub Commit request completed.successfully committed
	 public @FindBy(xpath = "//button[text()='OK']")
	 WebElement okButton;
}
