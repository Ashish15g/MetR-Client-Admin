package loginScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.metr.base.BaseClass;
import com.metr.pages.Login;

public class EmailVaiditation extends BaseClass {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	@Test(priority = 0)
	public void withValidCr() throws InterruptedException {
		Login lg = new Login(driver);
		lg.DevLogOut();

		lg.enterUsername("clientadmin2@met-r.io");
		lg.enterPassword("Meta@123");
		lg.selectCheckBox();

		lg.clickSubmit();
		// Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(lg.development_option));
		String given_url = "https://devclientadmin.met-r.io/dashboard";
		String current_url = driver.getCurrentUrl();
		assertEquals(given_url, current_url);
		Reporter.log("Login successfully with vailid Email", true);
	}

	@Test(priority = 1)
	public void withInValidCr() throws InterruptedException {
		Login lg = new Login(driver);
		lg.DevLogOut();

		lg.enterUsername("clientadmin22@met-r.io");
		lg.enterPassword("Meta@123");
		lg.selectCheckBox();

		lg.clickSubmit();

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(lg.invalid_credential));

		assertTrue(lg.invalid_credential.isDisplayed());
		Reporter.log("Login Unsuccessfully with Invailid Email", true);

	}

}
