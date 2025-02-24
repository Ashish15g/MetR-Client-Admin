package com.metr.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.metr.actiondriver.ActionDriver;
import com.metr.base.BaseClass;
import com.metr.pages.ProjectsPages;

public class ProjectTest extends BaseClass {
	@Test
	public void projectValidation() throws InterruptedException {
		ProjectsPages pro = new ProjectsPages(driver);
		ActionDriver.waitForPageLoad(30);
		ActionDriver.highlightElement(pro.projectSection, "green");
		ActionDriver.click(pro.projectSection);
		//Thread.sleep(20000);
		ActionDriver.waitForElementToBeVisible(pro.success_Msg);
		assertTrue(pro.success_Msg.isDisplayed());
		System.out.println("Success Message is Displayed successfully. ");
		// Add new project
		Thread.sleep(20000);
		ActionDriver.highlightElement(pro.addNweProject, "yellow");
		ActionDriver.jsClick(pro.addNweProject);
		Thread.sleep(10000);
		// Enter project name
		ActionDriver.highlightElement(pro.enterProjectName, "yellow");
		ActionDriver.enterText(pro.enterProjectName, "DocsAT1");
		// Enter project Deiscription
		ActionDriver.highlightElement(pro.ProjectDescription, "yellow");
		ActionDriver.enterText(pro.ProjectDescription, "Docs Migration");
		// Seve the project
		ActionDriver.highlightElement(pro.save, "yellow");
		ActionDriver.click(pro.save);

		Thread.sleep(30000);
		//Refresh project
		ActionDriver.highlightElement(pro.refreshButton, "yellow");
		ActionDriver.click(pro.refreshButton);
		
		Thread.sleep(30000);
	    //Get project  text name
		String text = pro.projectsList.get(0).getText();
		//search text in search field
		ActionDriver.highlightElement(pro.searchByProjectName, "yellow");
		ActionDriver.enterText(pro.searchByProjectName, text);
		Thread.sleep(30000);
		//Delete project
		WebElement delete_1st_project = pro.deleteProjectsList.get(0);
		ActionDriver.highlightElement(delete_1st_project, "yellow");
		ActionDriver.click(delete_1st_project);
		Thread.sleep(30000);
		//for(int i=0; i<pro.deleteProjectsList.size(); i++)
		for(int i=0; i<1; i++)
		{
			WebElement deleteproject = pro.deleteProjectsList.get(i);
			ActionDriver.highlightElement(deleteproject, "yellow");
			ActionDriver.click(deleteproject);
			Thread.sleep(30000);
			ActionDriver.highlightElement(pro.DeleteProjectName, "yellow");
			ActionDriver.enterText(pro.DeleteProjectName, text);
			Thread.sleep(30000);
			ActionDriver.highlightElement(pro.DeleteThisRepository, "yellow");
			ActionDriver.click(pro.DeleteThisRepository);
			
		}

	}
}
