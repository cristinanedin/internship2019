package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.core.utility.Driver;
import internship.framework.core.utility.TestUtils;
import internship.framework.pages.LoginPage;
import internship.framework.pages.PersonalDetailsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class PersonalDetailsTest extends TestBase {
    public static ThreadLocal<SoftAssert> softAssert = new ThreadLocal<>();
    private final String TEST_EMAIL = "radu.telegraph+11@gmail.com";
    private final String TEST_PASSWORD = "qwer1234";
    private final String TEST_NEW_EMAIL = "radu.telegraph+12@gmail.com";


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
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        softAssert.get().assertTrue(personalDetailsPage.areALLCheckboxesSelected(), "Not every checkbox is selected.");
        softAssert.get().assertAll();
    }

    @Test(dependsOnMethods = "checkPersonalDetailsFunctionality", testName = "Change email address test",
            description = "Testing change email address functionality")
    public void checkChangeEmailFunctionality() {
        TestUtils.login(TEST_EMAIL, TEST_PASSWORD);
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage().navigatePersonalDetails()
                .clickChangeEmailLink();
        softAssert.get().assertTrue(personalDetailsPage.isConfirmPasswordTextDisplayed().contains("confirm your password"), "Confirm password text is not displayed.");
        personalDetailsPage.fillWithValuePassword()
                .clickContinueButton()
                .fillWithValueNewEmail(TEST_NEW_EMAIL)
                .clickSaveEmailButton();
        LoginPage loginPage = new LoginPage();
        softAssert.get().assertTrue(loginPage.isLoginTextDisplayed().contains("Log in"));
        loginPage.enterEmail(TEST_EMAIL)
                .enterPassword(TEST_PASSWORD)
                .clickLogInButton();
        softAssert.get().assertTrue(loginPage.isFailedLoginTextDisplayed().contains("Sorry"));
        softAssert.get().assertAll();
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
