package niko;

import static niko.pages.CheckboxPage.getCheckboxPage;
import static niko.pages.HomePage.getHomePage;
import static niko.pages.RadioButtonsPage.getRadioButtonsPage;
import static niko.pages.SimpleFormPage.getSimpleFormPage;

import org.testng.annotations.Test;

import niko.listeners.Retry;
import niko.pages.CheckboxPage;
import niko.pages.HomePage;
import niko.pages.RadioButtonsPage;
import niko.pages.SimpleFormPage;

public class TitlesTest extends BaseTestClass {

	
    HomePage homePage = getHomePage();
  
    
    @Test(retryAnalyzer = Retry.class)
    public void StramTitlesTest() {
    	

        
        //find all categories and titles
        homePage.displayGroupsAndSubCategory();
        
        
    }
    
    
	
	
	
}
