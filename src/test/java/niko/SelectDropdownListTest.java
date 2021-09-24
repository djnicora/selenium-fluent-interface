package niko;

import static niko.pages.SelectDropdownListPage.*;
import org.testng.annotations.Test;

import niko.listeners.Retry;
import niko.pages.SelectDropdownListPage;

//import static niko.pages.SelectDropdownListPage;
import niko.pages.utils.Navigation;
import niko.pages.utils.VerifyPageTitle;

public class SelectDropdownListTest extends BaseTestClass {

	SelectDropdownListPage selectDropdownListPage = getDropdownListPage();

	@Test(retryAnalyzer = Retry.class)
	public void dropdownListTest() {
//			selectDropdownListPage
		Navigation.SELECTDROPDOWNLIST.navigate();
		VerifyPageTitle.SELECTDROPDOWNLIST.verify();
		selectDropdownListPage.selectFromList("Friday").verifySelectedDay();
	}

	@Test(retryAnalyzer = Retry.class)
	public void multiSelectList() {
		String[] listToSelect = { "California", "Florida", "New Jersey", "New York", "Ohio", "Texas", };
		selectDropdownListPage.selectFromMultiList(listToSelect).pressPrintAll();
	}

}
