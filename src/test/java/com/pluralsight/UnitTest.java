package com.pluralsight;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.pluralsight.pages.CheckboxPage;
import com.pluralsight.pages.HomePage;
import com.pluralsight.pages.RadioButtonsPage;
import com.pluralsight.pages.SimpleFormPage;
import com.pluralsight.pages.utils.FieldEntries;
import com.pluralsight.pages.utils.Navigation;
import com.pluralsight.pages.utils.VerifyPageTitle;

import static com.pluralsight.pages.HomePage.getHomePage;
import static com.pluralsight.pages.SimpleFormPage.getSimpleFormPage;

import java.util.List;

import static com.pluralsight.pages.CheckboxPage.getCheckboxPage;
import static com.pluralsight.pages.RadioButtonsPage.getRadioButtonsPage;
public class UnitTest extends BaseTestClass {

    HomePage homePage = getHomePage();
    SimpleFormPage simpleFormPage = getSimpleFormPage();
    CheckboxPage checkboxPage = getCheckboxPage();
    RadioButtonsPage radioButtonsPage = getRadioButtonsPage();
    
    @Test
    public void DemoEebsiteToPractice() {

        // homePage
        VerifyPageTitle.HOMEPAGETITLE.verify();
        homePage.ClosePopup();
        openNavigationTree();
        Navigation.SIMPLEFORMPAGE.navigate();

        // Simple Form page
        VerifyPageTitle.SIMPLEFORMPAGETITLE.verify();
        simpleFormPage.act().imputField(FieldEntries.ABC)
                        .clickButton().andThen().verifyMessage(FieldEntries.ABC);// and then brings all elements from verifications class
        
//        simpleFormPage.verify().verifyMessage(FieldEntries.ABC); //you can call the verification separately by calling verify() method
   
        List<String> examplesList = simpleFormPage.getExamplesController().examples();
 
        assertThat(examplesList)
        .hasSize(7) //check how many elements 
        .contains("Input Forms")
        .doesNotContain("Phiton")//does not contain
        .allMatch(element -> element.length() > 1); //does match the predicate
        
        
        openNavigationTree();
        Navigation.CHECKBOXPAGE.navigate();

        // Checkbox page
        VerifyPageTitle.CHECKBOXPAGETITLE.verify();
        checkboxPage.clickCheckBox()
                        .verifycheckBoxchecked();
        openNavigationTree();
        Navigation.RADIOBUTTONSPAGE.navigate();

        // Radio buttons page
        VerifyPageTitle.RADIOBUTTONSPAGETITLE.verify();
        radioButtonsPage.clickFemaleRadioButton()
                            .clickRadioButtonResult()
                            .verifyRadioButtonResultDisplay();

    }

}
