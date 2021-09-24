package niko;

import static niko.pages.CheckboxPage.getCheckboxPage;
import static niko.pages.HomePage.getHomePage;
import static niko.pages.RadioButtonsPage.getRadioButtonsPage;
import static niko.pages.SimpleFormPage.getSimpleFormPage;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import niko.pages.CheckboxPage;
import niko.pages.HomePage;
import niko.pages.RadioButtonsPage;
import niko.pages.SimpleFormPage;
import niko.pages.utils.FieldEntries;
import niko.pages.utils.Navigation;
import niko.pages.utils.VerifyPageTitle;

import niko.listeners.*;

import java.util.List;
public class UnitTest extends BaseTestClass {

    HomePage homePage = getHomePage();
    SimpleFormPage simpleFormPage = getSimpleFormPage();
    CheckboxPage checkboxPage = getCheckboxPage();
    RadioButtonsPage radioButtonsPage = getRadioButtonsPage();
    
    @Test(retryAnalyzer = Retry.class)
    public void DemoWebsiteToPractice() {

        Navigation.SIMPLEFORMPAGE.navigate();  

        // Simple Form page
        VerifyPageTitle.SIMPLEFORMPAGETITLE.verify();
        simpleFormPage.act().imputField(FieldEntries.ABC)
                        .clickButton().andThen().verifyMessage(FieldEntries.BAR);// and then brings all elements from verifications class
        
//        simpleFormPage.verify().verifyMessage(FieldEntries.ABC); //you can call the verification separately by calling verify() method
   
        
        //fill imput fieldsA and fieldsB using JScript
        simpleFormPage.act().imputFieldA("asd").imputFieldB("dsa").clickTotalButton();
        simpleFormPage.act().highlightButtons();
        
 
        List<String> examplesList = simpleFormPage.getExamplesController().examples();
 
        assertThat(examplesList)
        .hasSize(7) //check how many elements 
        .contains("Input Forms")
        .doesNotContain("Phiton")//does not contain
        .allMatch(element -> element.length() > 1); //does match the predicate
        
        
        Navigation.CHECKBOXPAGE.navigate();

        // Checkbox page
        VerifyPageTitle.CHECKBOXPAGETITLE.verify();
        checkboxPage.clickCheckBox()
                        .verifycheckBoxchecked();
        Navigation.RADIOBUTTONSPAGE.navigate();

        // Radio buttons page
        VerifyPageTitle.RADIOBUTTONSPAGETITLE.verify();
        radioButtonsPage.clickFemaleRadioButton()
                            .clickRadioButtonResult()
                            .verifyRadioButtonResultDisplay();

    }

}
