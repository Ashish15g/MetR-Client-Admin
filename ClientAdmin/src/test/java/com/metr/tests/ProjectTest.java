package com.metr.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.metr.actiondriver.ActionDriver;
import com.metr.base.BaseClass;
import com.metr.pages.ProjectsPages;
import com.metr.utilities.JavaUtilitieMethod;

public class ProjectTest extends BaseClass {

	@Test
	public void projectValidation() throws InterruptedException {
		ProjectsPages pro = new ProjectsPages(driver);
		ActionDriver.waitForPageLoad(30);
		// Heat the project section
		ActionDriver.highlightElement(pro.projectSection, "green");
		ActionDriver.click(pro.projectSection);
		Thread.sleep(20000);
		// Project get Successfully Notification Message
		ActionDriver.waitForElementToBeVisible(pro.success_Msg);
		ActionDriver.highlightElement(pro.success_Msg, "yellow");
		assertTrue(pro.success_Msg.isDisplayed());
		System.out.println("Success Message is Displayed successfully. ");
		// Add new project
		Thread.sleep(20000);
		ActionDriver.highlightElement(pro.addNweProject, "yellow");
		ActionDriver.jsClick(pro.addNweProject);

		// Enter project name
		ActionDriver.highlightElement(pro.enterProjectName, "yellow");
		ActionDriver.enterText(pro.enterProjectName, "DocsAT"+JavaUtilitieMethod.randomNum());
		// Enter project Deiscription
		ActionDriver.highlightElement(pro.ProjectDescription, "yellow");
		ActionDriver.enterText(pro.ProjectDescription, "Docs Migration");
		// Seve the project
		ActionDriver.highlightElement(pro.save, "yellow");
		ActionDriver.click(pro.save);
		// Project Added success Message
		ActionDriver.waitForElementToBeVisible(pro.ProjAddAndSyncSucfully);
		ActionDriver.highlightElement(pro.ProjAddAndSyncSucfully, "yellow");
		assertTrue(pro.ProjAddAndSyncSucfully.isDisplayed());
		// Refresh project button
		ActionDriver.waitForElementToBeClickable(pro.refreshButton);
		ActionDriver.highlightElement(pro.refreshButton, "yellow");
		ActionDriver.click(pro.refreshButton);
		// Project Refresh success Message
		ActionDriver.waitForElementToBeVisible(pro.refreshSucfullyMsg);
		ActionDriver.highlightElement(pro.refreshSucfullyMsg, "yellow");
		assertTrue(pro.refreshSucfullyMsg.isDisplayed());

		Thread.sleep(30000);
		// Get project text name
		String text = pro.projectsList.get(0).getText();
		// search text in search field
		ActionDriver.highlightElement(pro.searchByProjectName, "yellow");
		ActionDriver.enterText(pro.searchByProjectName, text);
		Thread.sleep(10000);
	}

	@Test(dependsOnMethods = "addAndDeleteCollaborator",enabled =false)
	public void deleteProject() throws InterruptedException {
		ProjectsPages pro = new ProjectsPages(driver);

		// Delete project
		String text = pro.projectsList.get(0).getText();
		WebElement delete_1st_project = pro.deleteProjectsList.get(0);
		ActionDriver.highlightElement(delete_1st_project, "yellow");
		ActionDriver.click(delete_1st_project);
		Thread.sleep(10000);
		//for(int i=0; i<pro.deleteProjectsList.size(); i++){
		for (int i = 0; i < 1; i++) {
			WebElement deleteproject = pro.deleteProjectsList.get(i);
			ActionDriver.highlightElement(deleteproject, "yellow");
			ActionDriver.click(deleteproject);
			Thread.sleep(10000);
			ActionDriver.highlightElement(pro.deleteProjectName, "yellow");
			ActionDriver.enterText(pro.deleteProjectName, text);
			Thread.sleep(10000);
			ActionDriver.highlightElement(pro.deleteThisRepository, "yellow");
			ActionDriver.click(pro.deleteThisRepository);
			// Peoject Deleted Success Message
			ActionDriver.waitForElementToBeVisible(pro.projDletdSucfullyMsg);
			ActionDriver.highlightElement(pro.projDletdSucfullyMsg, "yellow");
			assertTrue(pro.projDletdSucfullyMsg.isDisplayed());

		}
	}

	// View Projects
	@Test(dependsOnMethods = "projectValidation", enabled =true)
	public void addAndDeleteCollaborator() throws InterruptedException {
		ProjectsPages pro = new ProjectsPages(driver);
		//View Project
		ActionDriver.waitForElementToBeClickable(pro.view_button);
		ActionDriver.highlightElement(pro.view_button, "yellow");
		ActionDriver.click(pro.view_button);
		//Add Collaborator
		ActionDriver.waitForElementToBeClickable(pro.addCollaborators);
		ActionDriver.highlightElement(pro.addCollaborators, "Yellow");
		ActionDriver.click(pro.addCollaborators);
		//Enter Collaborators Name or UserName
		ActionDriver.waitForElementToBeClickable(pro.enterUserName);
		ActionDriver.highlightElement(pro.enterUserName, "Yellow");
		ActionDriver.click(pro.enterUserNames);
		
		ActionDriver.highlightElement(pro.enterUserName, "yellow");
		ActionDriver.enterText(pro.enterUserName, "metruser2");
		ActionDriver.pressEnter();
		//SubmitButton
		ActionDriver.waitForElementToBeClickable(pro.submitButton);
		ActionDriver.highlightElement(pro.submitButton, "yellow");
		ActionDriver.click(pro.submitButton);
		// Collaborators added successfully
		ActionDriver.waitForElementToBeVisible(pro.collaboratorsAdded);
		ActionDriver.highlightElement(pro.collaboratorsAdded, "yellow");
		assertTrue(pro.collaboratorsAdded.isDisplayed());
		System.out.println("Collaborators added successfully");
		//collaborators CheckBox
		ActionDriver.waitForElementToBeClickable(pro.checkBox);
		ActionDriver.highlightElement(pro.checkBox, "yellow");
		
		ActionDriver.jsClick(pro.checkBox);
		//Delete Collaborators
		ActionDriver.waitForElementToBeClickable(pro.deleteCollaborators);
		ActionDriver.highlightElement(pro.deleteCollaborators, "yellow");
		ActionDriver.click(pro.deleteCollaborators);
		//Remove Collaborators Button
		ActionDriver.waitForElementToBeClickable(pro.removeCollaborators);
		ActionDriver.highlightElement(pro.removeCollaborators, "yellow");
		ActionDriver.click(pro.removeCollaborators);
		//Collaborators removed successfully Msg
		ActionDriver.waitForElementToBeVisible(pro.collaboratorsRemovedScMsg);
		ActionDriver.highlightElement(pro.collaboratorsRemovedScMsg, "yellow");
		assertTrue(pro.collaboratorsRemovedScMsg.isDisplayed());
		System.out.println("Collaborators removed successfully");
		Thread.sleep(30000);
		driver.navigate().back();
	}
	@Test(dependsOnMethods = "projectValidation")
	public void deleteAllProject() throws InterruptedException {
		driver.navigate().back();
		ProjectsPages pro = new ProjectsPages(driver);

		// Delete project
		
//		WebElement delete_1st_project = pro.deleteProjectsList.get(0);
//		ActionDriver.highlightElement(delete_1st_project, "yellow");
//		ActionDriver.click(delete_1st_project);
		Thread.sleep(10000);
		//for(int i=0; i<pro.deleteProjectsList.size(); i++){
		for (int i = 0; i < pro.deleteProjectsList.size(); i++) {
			String text = pro.projectsList.get(i).getText();
			WebElement delete_project = pro.deleteProjectsList.get(i);
			ActionDriver.highlightElement(delete_project, "yellow");
			ActionDriver.click(delete_project);
			WebElement deleteproject = pro.deleteProjectsList.get(i);
			ActionDriver.highlightElement(deleteproject, "yellow");
			ActionDriver.click(deleteproject);
			Thread.sleep(10000);
			ActionDriver.highlightElement(pro.deleteProjectName, "yellow");
			ActionDriver.enterText(pro.deleteProjectName, text);
			Thread.sleep(10000);
			ActionDriver.highlightElement(pro.deleteThisRepository, "yellow");
			ActionDriver.click(pro.deleteThisRepository);
			// Peoject Deleted Success Message
			ActionDriver.waitForElementToBeVisible(pro.projDletdSucfullyMsg);
			ActionDriver.highlightElement(pro.projDletdSucfullyMsg, "yellow");
			assertTrue(pro.projDletdSucfullyMsg.isDisplayed());

	}
	}

}
