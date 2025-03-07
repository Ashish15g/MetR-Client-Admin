package userAppTestScripts;

import static org.testng.Assert.assertTrue;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import org.testng.annotations.Test;
import com.metr.actiondriver.ActionDriver;
import com.metr.base.UserAppBaseClass;
import com.metr.utilities.JavaUtilitieMethod;
import com.metrUserApp.Pages.DocMigrationPage;

public class DocMigrationPageTest1 extends UserAppBaseClass {

    @Test
    public void docsToDitaMigration() throws InterruptedException {
        performMigration("C:\\Users\\Admin\\git\\repository\\ClientAdmin\\src\\test\\resources\\testdata\\Docx_Input_file\\Printer User's Guide.docx", "Docs to DITA Migration", 0);
    }

    @Test
    public void htmlToDitaMigration() throws InterruptedException {
        performMigration("C:\\Users\\Admin\\git\\repository\\ClientAdmin\\src\\test\\resources\\testdata\\HTML_input\\sample1_html.zip", "HTML to DITA Migration", 1);
    }

    @Test
    public void mdToDitaMigration() throws InterruptedException {
        performMigration("C:\\Users\\Admin\\git\\repository\\ClientAdmin\\src\\test\\resources\\testdata\\MD_input\\final_md_sample.zip", "MD to DITA Migration", 2);
    }

    private void performMigration(String filePath, String migrationType, int inputTypeIndex) throws InterruptedException {
        DocMigrationPage docMig = new DocMigrationPage(driver);
        System.out.println("Starting " + migrationType);
        ActionDriver.highlightElement(docMig.docMigration, "yellow");
        ActionDriver.click(docMig.docMigration);
        
        ActionDriver.click(docMig.selectInputSource);
        ActionDriver.click(docMig.inputType.get(inputTypeIndex));
        ActionDriver.click(docMig.uploadFile);
        Thread.sleep(3000);
        
        StringSelection filePathSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);
        Thread.sleep(3000);
        ActionDriver.pressEnter();
        Thread.sleep(3000);
        
        ActionDriver.jsClick(docMig.checkBox);
        ActionDriver.click(docMig.uploadButton);
        assertTrue(docMig.successMsg.isDisplayed());
        
        ActionDriver.click(docMig.preFlight);
        assertTrue(docMig.successMsg.isDisplayed());
        
        ActionDriver.click(docMig.convertNow);
        assertTrue(docMig.successMsg.isDisplayed());
        
        ActionDriver.click(docMig.verifyNow);
        ActionDriver.click(docMig.no);
        Thread.sleep(3000);
        ActionDriver.click(docMig.download);
        ActionDriver.click(docMig.viewLog);
        Thread.sleep(6000);
        ActionDriver.click(docMig.download);
        Thread.sleep(6000);
        ActionDriver.click(docMig.gitHub);
        Thread.sleep(6000);
        ActionDriver.click(docMig.selectInputSource);
        Thread.sleep(3000);
        ActionDriver.click(docMig.inputType.get(0));
        Thread.sleep(3000);
        ActionDriver.click(docMig.newBranchCreate);
        Thread.sleep(3000);
        ActionDriver.click(docMig.chooseBranch);
        Thread.sleep(3000);
        ActionDriver.click(docMig.branchSelected.get(docMig.branchSelected.size() - 1));
        Thread.sleep(6000);
        ActionDriver.enterText(docMig.newBranchName, "Docs Testing"+JavaUtilitieMethod.randomChar());
        Thread.sleep(3000);
        ActionDriver.click(docMig.newBranchSubmit);
        
        assertTrue(docMig.brSuccessMsg.isDisplayed());
        
        ActionDriver.click(docMig.gitCommit);
        Thread.sleep(3000);
        ActionDriver.enterText(docMig.subComDescriptions, migrationType + " - Docs Migration T1");
        ActionDriver.click(docMig.submmit);
        ActionDriver.click(docMig.okButton);
        
        Thread.sleep(6000);
//        ActionDriver.click(docMig.docMigration);
//        System.out.println(migrationType + " completed successfully.");
    }
}
