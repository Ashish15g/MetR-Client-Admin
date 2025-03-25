package userAppTestScripts;

import com.metr.actiondriver.ActionDriver;
import com.metr.base.UserAppBaseClass;
import com.metrUserApp.Pages.DocPublisherPage;

public class DocPublisherPageTest extends UserAppBaseClass{
	public void docPublisherValidations() {
		DocPublisherPage docPub = new DocPublisherPage(driver);
		ActionDriver.highlightElement(docPub.docPublisher, "yellow");
		ActionDriver.click(docPub.docPublisher);
		ActionDriver.click(docPub.projectSection);
		ActionDriver.click(docPub.chooseProject.get(0));
		ActionDriver.click(docPub.branchSection);
		ActionDriver.click(docPub.chooseProject.get(0));
		ActionDriver.click(docPub.nextButton);
	}
}
