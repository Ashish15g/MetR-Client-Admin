package com.metr.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.metr.pages.Login;
import com.metr.utilities.GetPropData;

public class UserAppBaseClass extends BaseDriver
{
	@BeforeClass
	public void preCondition() throws IOException, InterruptedException {
		String mr_browser = GetPropData.propData("browser");
		String mr_url = GetPropData.propData("ua_url");
		String u_name = GetPropData.propData("ua_username");
		String pass = GetPropData.propData("ua_password");

		if (mr_browser.equals("chrome")) {
			driver = new ChromeDriver();
		} 
		else if (mr_browser.equals("edge")) {
			driver = new EdgeDriver();
		} 
		else if (mr_browser.equalsIgnoreCase("firefox")) { 
		    driver = new FirefoxDriver();
		} 
		else if (mr_browser.equalsIgnoreCase("safari")) {
		    driver = new SafariDriver();
		} 
		else {
		    throw new IllegalArgumentException("Unsupported browser: " + mr_browser);
		}

		driver.manage().window().maximize();
		driver.get(mr_url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Login lg = new Login(driver);
		lg.enterUsername(u_name);
		lg.enterPassword(pass);
//		Thread.sleep(2000);
//		lg.selectCheckBox();
		lg.clickSubmit();
		Thread.sleep(6000);
		
        SoftAssert sa = new SoftAssert();
        
		try {
			sa.assertTrue(lg.logout.isDisplayed(), pass);
			lg.logOut();
			lg.Logout_successful_ok.click();
			lg.enterUsername(u_name);
			lg.enterPassword(pass);
			//Thread.sleep(2000);
			//lg.selectCheckBox();
			lg.clickSubmit();
		} catch (Exception e) 
		{
			System.out.println("Exception occurred: not login in any device" + e.getMessage());
		}
	}
	@AfterClass
	public void postCondition() throws InterruptedException {
		Login lg = new Login(driver);
		Thread.sleep(6000);
		lg.userAppLogout();
		Thread.sleep(6000);
		driver.close();
		driver.quit();
	}
}
