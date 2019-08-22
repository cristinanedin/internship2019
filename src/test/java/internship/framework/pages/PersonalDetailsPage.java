package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.runner.GlobalProperties;
import internship.framework.core.utility.ElementUtils;
import internship.framework.core.utility.ProjectLogger;
import internship.framework.core.utility.TestData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PersonalDetailsPage extends PageBase {

    @FindBy(xpath = "//a[@class='header-middle-nav'][contains(text(),'Personal Details')]")
    private WebElement myDetailsButton;

    @FindBy(xpath = "//a[contains(text(),'Edit your details')]")
    private WebElement editDetailsElement;

    @FindBy(xpath = "//select[@name='salutation']")
    private WebElement selectTitleElement;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameElement;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameElement;

    @FindBy(xpath = "//input[@id='streetline1']")
    private WebElement addressElement;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityTownElement;

    @FindBy(xpath = "(//select[@class='dropdown-wrapper-select'])[2]")
    private WebElement countryElement;

    @FindBy(xpath = "//input[@id='mobile']")
    private WebElement telephoneElement;

    @FindBy(xpath = "//div[@class='toast-content']")
    private WebElement validateChangesElement;

    @FindBy(xpath = "//span[@class='top-edit-mode-buttons']//button[@class='button primary']")
    private WebElement saveChangesElement;

    @FindBy(xpath = "//div[@class='checkboxes']//div[1]//label[1]//span[1]")
    private WebElement firstCheckBoxElement;

    @FindBy(xpath = "//div[@id='___gatsby']//div[2]//label[1]//span[1]")
    private WebElement secondCheckBoxElement;

    @FindBy(xpath = "//div[3]//label[1]//span[1]")
    private WebElement thirdCheckBoxElement;

    @FindBy(xpath = "//div[4]//label[1]//span[1]")
    private WebElement fourthCheckBoxElement;

    @FindBy(xpath = "//a[contains(text(),'Subscription Details')]")
    private WebElement subscriptionDetailsButton;

    @FindBy(xpath = "//a[contains(text(),'Personal Details')]")
    private WebElement personalDetailsButton;

    @FindBy(xpath = "//input[@id='marketingEmailOptIn']")
    private WebElement checkFirstCheckboxElement;

    @FindBy(xpath = "//input[@id='marketingPostOptIn']")
    private WebElement checkSecondCheckboxElement;

    @FindBy(xpath = "//input[@id='marketingPhoneOptIn']")
    private WebElement checkThirdCheckboxElement;

    @FindBy(xpath = "//input[@id='marketingSMSOptIn']")
    private WebElement checkFourthCheckboxElement;

    @FindBy(xpath = "//a[contains(text(),'Change your email')]")
    private WebElement changeEmailElement;

    @FindBy(xpath = "//h2[contains(text(),'Please confirm your password to update your email')]")
    private WebElement confirmPasswordText;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordElement;

    @FindBy(xpath = "//button[@class='button primary']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailElement;

    @FindBy(xpath = "//span[@class='top-edit-mode-buttons']//button[@class='button primary']")
    private WebElement saveEmailChangesElement;

    public PersonalDetailsPage navigatePersonalDetails() {
        ProjectLogger.info("Navigate to Personal Details page.");
        ElementUtils.clickOn(myDetailsButton);
        return this;
    }

    public PersonalDetailsPage clickEditDetailsElement() {
        ProjectLogger.info("Click edit details button.");
        ElementUtils.clickOn(editDetailsElement);
        return this;
    }

    public PersonalDetailsPage selectTitle() {
        ProjectLogger.info("Select title.");
        Select select = new Select(selectTitleElement);
        select.selectByVisibleText(TestData.YOUR_DETAILS_TITLE);
        return this;
    }

    public PersonalDetailsPage fillWithValueFirstName() {
        ProjectLogger.info("Fill first name element with value.");
        ElementUtils.fillInWithValue(firstNameElement, TestData.YOUR_DETAILS_FIRST_NAME);
        return this;
    }

    public PersonalDetailsPage fillWithValueLastName() {
        ProjectLogger.info("Fill last name element with value.");
        ElementUtils.fillInWithValue(lastNameElement, TestData.YOUR_DETAILS_LAST_NAME);
        return this;
    }

    public PersonalDetailsPage fillWithValueAddress() {
        ProjectLogger.info("Fill address element with value.");
        ElementUtils.fillInWithValue(addressElement, TestData.YOUR_DETAILS_ADDRESS);
        return this;
    }

    public PersonalDetailsPage fillWithValueCityTown() {
        ProjectLogger.info("Fill city/town element with value.");
        ElementUtils.fillInWithValue(cityTownElement, TestData.YOUR_DETAILS_CITY_TOWN);
        return this;
    }

    public PersonalDetailsPage selectCountry() {
        ProjectLogger.info("Select country.");
        Select select = new Select(countryElement);
        select.selectByVisibleText(TestData.YOUR_DETAILS_COUNTRY);
        return this;
    }

    public PersonalDetailsPage fillWithValueTelephone() {
        ProjectLogger.info("Fill telephone element with value.");
        ElementUtils.fillInWithValue(telephoneElement, TestData.YOUR_DETAILS_TELEPHONE);
        return this;
    }

    public boolean isValidateChangesDisplayed() {
        ProjectLogger.info("Check if validate changes element is displayed.");
        return ElementUtils.doesAppear(validateChangesElement);
    }

    public void clickSaveChangesButton() {
        ProjectLogger.info("Save changes made.");
        ElementUtils.clickOn(saveChangesElement);
    }

    public PersonalDetailsPage selectAllContactPreferences() {
        ProjectLogger.info("We check all contact preferences.");
        ElementUtils.clickOn(firstCheckBoxElement);
        ElementUtils.clickOn(secondCheckBoxElement);
        ElementUtils.clickOn(thirdCheckBoxElement);
        ElementUtils.clickOn(fourthCheckBoxElement);
        return this;
    }

    public PersonalDetailsPage navigateSubscriptionDetailsTab() {
        ProjectLogger.info("Navigate to Subscription Details page.");
        ElementUtils.clickOn(subscriptionDetailsButton);
        return this;
    }

    public void navigatePersonalDetailsTab() {
        ProjectLogger.info("Navigate to Personal Details page.");
        ElementUtils.clickOn(personalDetailsButton);
    }

    private boolean isFirstCheckBoxSelected() {
        ProjectLogger.info("Check if first contact checkbox is selected.");
        return Boolean.parseBoolean(checkFirstCheckboxElement.getAttribute("checked"));
    }

    private boolean isSecondCheckBoxSelected() {
        ProjectLogger.info("Check if second contact checkbox is selected.");
        return Boolean.parseBoolean(checkSecondCheckboxElement.getAttribute("checked"));
    }

    private boolean isThirdCheckBoxSelected() {
        ProjectLogger.info("Check if third contact checkbox is selected.");
        return Boolean.parseBoolean(checkThirdCheckboxElement.getAttribute("checked"));
    }

    private boolean isFourthCheckBoxSelected() {
        ProjectLogger.info("Check if fourth contact checkbox is selected.");
        return Boolean.parseBoolean(checkFourthCheckboxElement.getAttribute("checked"));
    }

    public boolean areALLCheckboxesSelected() {
        return isFirstCheckBoxSelected() && isSecondCheckBoxSelected()
                && isThirdCheckBoxSelected() && isFourthCheckBoxSelected();
    }

    public PersonalDetailsPage clickChangeEmailLink() {
        ProjectLogger.info("Navigate to change email page.");
        ElementUtils.clickOn(changeEmailElement);
        return this;
    }

    public String isConfirmPasswordTextDisplayed() {
        ProjectLogger.info("Confirm password text is displayed.");
        return ElementUtils.getElementText(confirmPasswordText);
    }

    public PersonalDetailsPage fillWithValuePassword() {
        ProjectLogger.info("Fill element with password.");
        ElementUtils.fillInWithValue(passwordElement, GlobalProperties.PASSWORD_VALUE);
        return this;
    }

    public PersonalDetailsPage clickContinueButton() {
        ProjectLogger.info("Click continue button.");
        ElementUtils.clickOn(continueButton);
        return this;
    }

    public PersonalDetailsPage fillWithValueNewEmail(String email) {
        ProjectLogger.info("Fill element with new email.");
        ElementUtils.fillInWithValue(emailElement, email);
        return this;
    }

    public void clickSaveEmailButton() {
        ProjectLogger.info("Click save email button.");
        ElementUtils.clickOn(saveEmailChangesElement);
    }
}
