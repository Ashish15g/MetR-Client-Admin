package userAppTestScripts;

import static org.testng.Assert.assertTrue;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import org.testng.annotations.Test;
import com.metr.actiondriver.ActionDriver;
import com.metr.base.UserAppBaseClass;
import com.metrUserApp.Pages.DocMigrationPage;

public class DocMigrationPageTest extends UserAppBaseClass{
	
	@Test
	public void docMigrationValidate() throws InterruptedException {
		DocMigrationPage docMig = new DocMigrationPage(driver);
		StringSelection filePathSelection;
		ActionDriver.highlightElement(docMig.docMigration, "yellow");
		ActionDriver.click(docMig.docMigration);
		//Select input source type
	
		for(int i=0; i<docMig.inputType.size(); i++)
		{
		ActionDriver.click(docMig.selectInputSource);
		
		ActionDriver.click(docMig.inputType.get(i));//List WebElement
		ActionDriver.click(docMig.uploadFile);
		Thread.sleep(3000);
		if(i==0)//Docs to DITA Migrations
		{
			filePathSelection = new StringSelection("C:\\Users\\Admin\\git\\repository\\ClientAdmin\\src\\test\\resources\\testdata\\Docx_Input_file\\Printer User's Guide.docx");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);
		}
		else if(i==1)//HTML to DITA Migrations
		{
			filePathSelection =	new StringSelection("C:\\Users\\Admin\\git\\repository\\ClientAdmin\\src\\test\\resources\\testdata\\HTML_input\\sample1_html.zip");	
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);
		}
		else if(i==2)//MD to DITA Migrations
		{
			filePathSelection = new StringSelection("C:\\Users\\Admin\\git\\repository\\ClientAdmin\\src\\test\\resources\\testdata\\MD_input\\final_md_sample.zip");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);
		}
		
		Thread.sleep(3000);
		ActionDriver.pressEnter();
		Thread.sleep(3000);
		//docMig.resetButton.click();
		ActionDriver.jsClick(docMig.checkBox);
		ActionDriver.click(docMig.uploadButton);
		ActionDriver.isDisplayed(docMig.successMsg);
		//ActionDriver.isDisplayed(docMig.successMsg);
		//ActionDriver.click(docMig.backButton);
		ActionDriver.click(docMig.preFlight);
		ActionDriver.isDisplayed(docMig.successMsg);
		ActionDriver.click(docMig.convertNow);
		assertTrue(docMig.successMsg.isDisplayed());
		//ActionDriver.isDisplayed(docMig.successMsg);
		ActionDriver.click(docMig.verifyNow);
		ActionDriver.click(docMig.no);
		Thread.sleep(3000);
		ActionDriver.click(docMig.download);
		ActionDriver.click(docMig.viewLog);
		Thread.sleep(3000);
		ActionDriver.click(docMig.download);
		Thread.sleep(3000);
		ActionDriver.click(docMig.gitHub);
		
		ActionDriver.click(docMig.selectInputSource);
		
		ActionDriver.click(docMig.inputType.get(0));
		Thread.sleep(6000);
		ActionDriver.click(docMig.newBranchCreate);
		Thread.sleep(3000);
		ActionDriver.click(docMig.chooseBranch);
		Thread.sleep(3000);
		ActionDriver.click(docMig.branchSelected.get(docMig.branchSelected.size()-1));//List Webelement
		Thread.sleep(6000);
		ActionDriver.enterText(docMig.newBranchName, "Docs Testing");
		Thread.sleep(3000);
		ActionDriver.click(docMig.newBranchSubmit);
		ActionDriver.isDisplayed(docMig.brSuccessMsg);
		ActionDriver.click(docMig.gitCommit);
		ActionDriver.enterText(docMig.subComDescriptions, "Docs Migration T1");
		ActionDriver.click(docMig.submmit);
		ActionDriver.click(docMig.okButton);
		Thread.sleep(6000);
		ActionDriver.click(docMig.docMigration);

		}
	}
}
