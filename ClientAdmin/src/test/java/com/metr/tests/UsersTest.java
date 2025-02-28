package com.metr.tests;

import org.testng.annotations.Test;

import com.metr.actiondriver.ActionDriver;
import com.metr.base.BaseClass;
import com.metr.pages.UsersPages;

public class UsersTest extends BaseClass{
	@Test 
	public void usersManagemetn() {
		UsersPages userMng = new UsersPages(driver);
		ActionDriver.waitForPageLoad(30);
		//navigateTo Users section
		ActionDriver.waitForElementToBeClickable(userMng.navigetUsersSection);
		ActionDriver.highlightElement(userMng.navigetUsersSection, "yellow");
		ActionDriver.click(userMng.navigetUsersSection);
		//Add users
		ActionDriver.waitForElementToBeClickable(userMng.addUsers);
		ActionDriver.click(userMng.addUsers);
		//userName
		ActionDriver.enterText(userMng.userName, "ashish");
		//select project name is pending
		ActionDriver.click(userMng.selectProject);
		//ActionDriver.
		//Email Address
		ActionDriver.enterText(userMng.emailAddress, "ashish.kg@metapercept.com");
		//password
		ActionDriver.enterText(userMng.password, "Meta@123");
		//Github UserName
		ActionDriver.enterText(userMng.githubUsername, "Ashish15g");
		//Github Email Address
		ActionDriver.enterText(userMng.githubEmail, "ashish.kg@metapercept.com");
		//View Remaining credits Enable or Disable
		ActionDriver.click(userMng.buttonEnable);
		//ActionDriver.click(userMng.buttonDisable);
		//Save or Cancel Users Details
		ActionDriver.click(userMng.saveButton);
		ActionDriver.click(userMng.cancelButton);
	}
	

}
