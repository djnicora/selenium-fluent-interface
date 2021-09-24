package niko;

import static niko.pages.AjaxFormSubmitPage.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import niko.listeners.Retry;
import niko.pages.AjaxFormSubmitPage;
import niko.pages.utils.Navigation;
import niko.pages.utils.VerifyPageTitle;

public class AjaxFormSubmitTest extends BaseTestClass {

	AjaxFormSubmitPage selectDropdownListPage = getAjaxFormSubmitPage();

	@Test(retryAnalyzer = Retry.class)
	public void verifyNameField() {
//			selectDropdownListPage
		Navigation.AJAXFROMSUBMIT.navigate();
		VerifyPageTitle.AJAXFROMSUBMIT.verify();
		selectDropdownListPage.clickSubmit();

		assertThat(selectDropdownListPage.verifyNameField())
		.hasSize(33) // check how many characters
		.contains("border: 1px solid rgb(255, 0, 0);")
		.doesNotContain("Phiton");
	}

	@Test(retryAnalyzer = Retry.class)
	public void fillDes() {

		Navigation.AJAXFROMSUBMIT.navigate();
		VerifyPageTitle.AJAXFROMSUBMIT.verify();
		selectDropdownListPage.enterdescription("Description");
		selectDropdownListPage.clickSubmit();
		
		assertThat(selectDropdownListPage.verifyNameField())
		.hasSize(33) // check how many characters
		.contains("border: 1px solid rgb(255, 0, 0);")
		.doesNotContain("Phiton");

	}
	
	@Test(retryAnalyzer = Retry.class)
	public void formSubmited() {
		Navigation.AJAXFROMSUBMIT.navigate();
		VerifyPageTitle.AJAXFROMSUBMIT.verify();
		selectDropdownListPage
		.enterdescription("Description")
		.enterName("Name")
		.clickSubmit()
		.verifyMessage();
	}

	
	
}
