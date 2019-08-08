package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.core.runner.GlobalProperties;
import internship.framework.pages.LoginPage;
import internship.framework.pages.PersonalDetailsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PersonalDetailsTest extends TestBase {
    private ThreadLocal<SoftAssert> softAssert = new ThreadLocal<>();

    @Test(testName = "Personal details test",
            description = "Testing personal details.")
    public void checkPersonalDetailsFunctionality() {
        softAssert.set(new SoftAssert());
        login();
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage().navigatePersonalDetails();
        editPersonalDetails();
        softAssert.get().assertTrue(personalDetailsPage.isValidateChangesDisplayed(),
                "Valid changes element is not displayed.");
        personalDetailsPage.selectAllContactPreferences()
                           .navigateSubscriptionDetailsTab()
                           .navigatePersonalDetailsTab();
        softAssert.get().assertTrue(personalDetailsPage.areALLCheckboxesSelected(), "Not every checkbox is selected.");
        softAssert.get().assertAll();
    }

    @Override
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        softAssert.remove();
        super.tearDown();
    }

    private void login()
    {
        LoginPage loginPage=new LoginPage().openPage();
        loginPage.clickLogInButtonHome();
        loginPage.enterEmail(GlobalProperties.USERNAME_VALUE)
                .enterPassword(GlobalProperties.PASSWORD_VALUE)
                .clickLogInButton()
                .clickMyAccountButton();
    }

    private void editPersonalDetails()
    {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        personalDetailsPage.clickEditDetailsElement()
                           .selectTitle()
                           .fillWithValueFirstName()
                           .fillWithValueLastName()
                           .fillWithValueAddress()
                           .fillWithValueCityTown()
                           .selectCountry()
                           .fillWithValueTelephone()
                           .clickSaveChangesButton();
    }
}
