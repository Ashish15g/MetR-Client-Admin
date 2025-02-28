package com.metr.tests;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.metr.actiondriver.ActionDriver;
import com.metr.base.BaseClass;
import com.metr.pages.ProjectsPages;
import com.metr.utilities.JavaUtilitieMethod;

public class ProjectManagementTest extends BaseClass {

	@Test(priority = 1)
	public void navigateToProjectSection() {
		ProjectsPages pro = new ProjectsPages(driver);
		ActionDriver.waitForPageLoad(30);

		// Navigate to project section
		ActionDriver.highlightElement(pro.projectSection, "green");
		ActionDriver.jsClick(pro.projectSection);
		ActionDriver.waitForElementToBeVisible(pro.success_Msg);

		assertTrue(pro.success_Msg.isDisplayed(), "Project section not loaded.");
		System.out.println("✅ Navigated to Project Section.");
	}

	@Test(priority = 2, dependsOnMethods = "navigateToProjectSection",enabled =true)
	public void addProject() throws InterruptedException {
		ProjectsPages pro = new ProjectsPages(driver);
		Thread.sleep(5000);

		// Add new project
		ActionDriver.highlightElement(pro.addNweProject, "yellow");
		ActionDriver.jsClick(pro.addNweProject);

		// Enter project details
		String projectName = "DocsAT" + JavaUtilitieMethod.randomNum();
		ActionDriver.enterText(pro.enterProjectName, projectName);
		ActionDriver.enterText(pro.ProjectDescription, "Docs Migration");

		// Save project
		ActionDriver.click(pro.save);
		ActionDriver.waitForElementToBeVisible(pro.ProjAddAndSyncSucfully);

		assertTrue(pro.ProjAddAndSyncSucfully.isDisplayed(), "Project not added.");
		System.out.println("✅ Project Added Successfully: " + projectName);

		// Refresh project list
		ActionDriver.click(pro.refreshButton);
		ActionDriver.waitForElementToBeVisible(pro.refreshSucfullyMsg);

		assertTrue(pro.refreshSucfullyMsg.isDisplayed(), "Project refresh failed.");
		System.out.println("✅ Project List Refreshed.");
	}

	@Test(priority = 3, dependsOnMethods = "addProject",enabled =true)
	public void addCollaborator() throws InterruptedException {
		ProjectsPages pro = new ProjectsPages(driver);
		Thread.sleep(8000);
		// View project
		ActionDriver.waitForElementToBeClickable(pro.view_button);
		ActionDriver.highlightElement(pro.view_button, "yellow");
		ActionDriver.click(pro.view_button);

		// Add collaborator
		ActionDriver.waitForElementToBeClickable(pro.addCollaborators);
		ActionDriver.highlightElement(pro.addCollaborators, "Yellow");
		ActionDriver.click(pro.addCollaborators);
		// Enter Collaborators Name or UserName
		ActionDriver.waitForElementToBeClickable(pro.enterUserName);
		ActionDriver.highlightElement(pro.enterUserName, "Yellow");
		ActionDriver.click(pro.enterUserNames);

		ActionDriver.highlightElement(pro.enterUserName, "yellow");
		ActionDriver.enterText(pro.enterUserName, "metruser2");
		ActionDriver.pressEnter();
		// SubmitButton
		ActionDriver.waitForElementToBeClickable(pro.submitButton);
		ActionDriver.highlightElement(pro.submitButton, "yellow");
		ActionDriver.click(pro.submitButton);
		// Collaborators added successfully
		ActionDriver.waitForElementToBeVisible(pro.collaboratorsAdded);
		ActionDriver.highlightElement(pro.collaboratorsAdded, "yellow");
		assertTrue(pro.collaboratorsAdded.isDisplayed());
		System.out.println("Collaborators added successfully");
	}

	@Test(priority = 4, dependsOnMethods = "addCollaborator",enabled =true)
	public void deleteCollaborator() throws InterruptedException {
		ProjectsPages pro = new ProjectsPages(driver);

		// Select collaborator checkbox
		ActionDriver.waitForElementToBeClickable(pro.checkBox);
		ActionDriver.jsClick(pro.checkBox);
		Thread.sleep(2000);

		// Delete collaborator
		ActionDriver.click(pro.deleteCollaborators);
		ActionDriver.click(pro.removeCollaborators);
		ActionDriver.waitForElementToBeVisible(pro.collaboratorsRemovedScMsg);

		assertTrue(pro.collaboratorsRemovedScMsg.isDisplayed(), "Collaborator deletion failed.");
		System.out.println("✅ Collaborator Removed Successfully.");
		
	}

	@Test(priority = 5, dependsOnMethods = "deleteCollaborator",enabled =true)
	public void deleteProject() throws InterruptedException {
		ProjectsPages pro = new ProjectsPages(driver);
		driver.navigate().back();
		Thread.sleep(4000);
		// Get project name
		String projectName = pro.projectsList.get(0).getText();

		// Delete project
		WebElement deleteProjectButton = pro.deleteProjectsList.get(0);
		ActionDriver.click(deleteProjectButton);
		Thread.sleep(2000);

		ActionDriver.enterText(pro.deleteProjectName, projectName);
		ActionDriver.click(pro.deleteThisRepository);
		ActionDriver.waitForElementToBeVisible(pro.projDletdSucfullyMsg);

		assertTrue(pro.projDletdSucfullyMsg.isDisplayed(), "Project deletion failed.");
		
		System.out.println("✅ Project Deleted Successfully: " + projectName);
		//invocationCount = 5
	}

	@Test(priority = 6, dependsOnMethods = "navigateToProjectSection",invocationCount = 10,enabled =false)
	public void deleteAllProjects() throws InterruptedException {
		ProjectsPages pro = new ProjectsPages(driver);
		
		
		int totalProjects = pro.deleteProjectsList.size();

		//System.out.println("🔄 Total Projects to Delete: " + totalProjects);

		for (int i = 0; i < totalProjects; i++) {

			WebElement deleteProjectButton = pro.deleteProjectsList.get(i);
             
			ActionDriver.click(deleteProjectButton);
			Thread.sleep(2000);
			String projectName = pro.projectsList.get(i).getText();

			ActionDriver.enterText(pro.deleteProjectName, projectName);
			ActionDriver.click(pro.deleteThisRepository);
			ActionDriver.waitForElementToBeVisible(pro.projDletdSucfullyMsg);

			assertTrue(pro.projDletdSucfullyMsg.isDisplayed(), "Failed to delete project: " + projectName);
			System.out.println("✅ Deleted Project: " + projectName);
			Thread.sleep(4000);
			 //totalProjects += pro.deleteProjectsList.size();
		}
	}
}
