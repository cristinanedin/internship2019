package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.core.utility.TestUtils;
import internship.framework.pages.LoginPage;
import internship.framework.pages.PersonalDetailsPage;
import org.testng.annotations.Test;

public class PersonalDetailsTest extends TestBase {
    private final String TEST_EMAIL = "radu.telegraph+1@gmail.com";
    private final String TEST_PASSWORD = "qwer1234";
    private final String TEST_NEW_EMAIL = "radu.telegraph+2@gmail.com";
    private final String LOGIN_TEXT = "Log in";
    private final String WRONG_ACCOUNT_TEXT = "Sorry, we can't find an account with this email address and password.";


    @Test(testName = "Personal details test",
            description = "Testing personal details.")
    public void checkPersonalDetailsFunctionality() {
        TestUtils.login(TEST_EMAIL, TEST_PASSWORD);
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage().navigatePersonalDetails();
        editPersonalDetails();
        softAssert.get().assertTrue(personalDetailsPage.isValidateChangesDisplayed(),
                "Valid changes element is not displayed.");
        personalDetailsPage.selectAllContactPreferences()
                .navigateSubscriptionDetailsTab()
                .navigatePersonalDetailsTab();
        softAssert.get().assertTrue(personalDetailsPage.areALLCheckboxesSelected(), "Not every checkbox is selected.");
        personalDetailsPage.selectAllContactPreferences();
        softAssert.get().assertAll();
    }

    @Test(dependsOnMethods = "checkPersonalDetailsFunctionality", testName = "Change email address test",
            description = "Testing change email address functionality")
    public void checkChangeEmailFunctionality() {
        TestUtils.login(TEST_EMAIL, TEST_PASSWORD);
        changeEmailAddress(TEST_NEW_EMAIL);
        LoginPage loginPage = new LoginPage();
        softAssert.get().assertEquals(loginPage.isLoginTextDisplayed(), LOGIN_TEXT);
        loginPage(TEST_EMAIL);
        softAssert.get().assertEquals(loginPage.isFailedLoginTextDisplayed(), WRONG_ACCOUNT_TEXT);
        loginPage(TEST_NEW_EMAIL);
        changeEmailAddress(TEST_EMAIL);
        softAssert.get().assertAll();
    }

    private void changeEmailAddress(String newEmail) {
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage().navigatePersonalDetails()
                .clickChangeEmailLink();
        softAssert.get().assertTrue(personalDetailsPage.isConfirmPasswordTextDisplayed().contains("confirm your password"), "Confirm password text is not displayed.");
        personalDetailsPage.fillWithValuePassword()
                .clickContinueButton()
                .fillWithValueNewEmail(newEmail)
                .clickSaveEmailButton();
    }

    private void loginPage(String newEmail) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail(newEmail)
                .enterPassword(TEST_PASSWORD)
                .clickLogInButton();
    }

    private void editPersonalDetails() {
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
