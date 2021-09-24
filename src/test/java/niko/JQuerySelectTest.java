package niko;

import static niko.pages.JQuerySelectPage.getJQuerySelectPage;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import niko.listeners.Retry;
import niko.pages.JQuerySelectPage;
import niko.pages.utils.Navigation;
import niko.pages.utils.VerifyPageTitle;

public class JQuerySelectTest extends BaseTestClass {

	JQuerySelectPage jQuerySelectPage = getJQuerySelectPage();

	@Test(retryAnalyzer = Retry.class)
	public void verifyNameField() {
//			JQuerySelectPage
		Navigation.JQUERYSELECTTEST.navigate();
		VerifyPageTitle.JQUERYSELECTTEST.verify();
		
		jQuerySelectPage.clickCountryDropDown().enterCountry("Denmark").selectState("Arizona").selectState("California");

	}

}
