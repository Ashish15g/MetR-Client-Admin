package com.metr.tests;

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
	    //Get project text
		String text = pro.projectsList.get(0).getText();
		//search text in search field
		ActionDriver.highlightElement(pro.searchByProjectName, "yellow");
		ActionDriver.enterText(pro.searchByProjectName, text);

	}
}
