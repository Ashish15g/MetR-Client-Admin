package com.metr.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.metr.actiondriver.ActionDriver;
import com.metr.base.BaseClass;
import com.metr.pages.UsersManagementPages;
import com.metr.utilities.GetExcelData;

public class UsersManagementPagesTest extends BaseClass{
	@Test 
	public void usersManagement() throws EncryptedDocumentException, IOException, InterruptedException {
		UsersManagementPages userMng = new UsersManagementPages(driver);
		ActionDriver.waitForPageLoad(30);
		//navigateTo Users section
		ActionDriver.waitForElementToBeClickable(userMng.navigetUsersSection);
		ActionDriver.highlightElement(userMng.navigetUsersSection, "yellow");
		ActionDriver.click(userMng.navigetUsersSection);
		//Add users
		ActionDriver.waitForElementToBeClickable(userMng.addUsers);
		ActionDriver.click(userMng.addUsers);
		//userName
		ActionDriver.enterText(userMng.userName, GetExcelData.Exceldata("Users_Credentials", 2, 0));
		//select project name is pending
		//for(int i=0; i<userMng.projectListName.size(); i++)//multips project
			for(int i=0; i<3; i++)//how much you need to aad
		{
			
		ActionDriver.click(userMng.selectProject);
		Thread.sleep(1000);
		ActionDriver.click(userMng.projectListName.get(i));
		Thread.sleep(4000);
		
		
		}
		System.out.println("projects are selected Lists: "+userMng.projectListName.size());
		//Email Address
		ActionDriver.enterText(userMng.emailAddress, GetExcelData.Exceldata("Users_Credentials", 2, 1));
		//password
		ActionDriver.enterText(userMng.password, GetExcelData.Exceldata("Users_Credentials", 2, 2));
		//Github UserName
		ActionDriver.enterText(userMng.githubUsername, GetExcelData.Exceldata("Users_Credentials", 2, 3));
		//Github Email Address
		ActionDriver.enterText(userMng.githubEmail, GetExcelData.Exceldata("Users_Credentials", 2, 4));
		//View Remaining credits Enable or Disable
		ActionDriver.click(userMng.buttonEnable);
		//ActionDriver.click(userMng.buttonDisable);
		//Save or Cancel Users Details
		ActionDriver.click(userMng.saveButton);
		//ActionDriver.click(userMng.cancelButton);
	}
	

}
