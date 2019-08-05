package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.clickOn;

public class NavigationPage extends PageBase {

    @FindBy(xpath = "//a[contains(@class,'header-nav-primary__link')][contains(text(),'News')]")
    private WebElement buttonNews;

    @FindBy(xpath = "//a[contains(@class,'header-nav-primary__link')][contains(text(),'Politics')]")
    private WebElement buttonPolitics;

    @FindBy(xpath = "//a[contains(@class,'header-nav-primary__link')][contains(text(),'Sport')]")
    private WebElement buttonSport;

    @FindBy(xpath = "//a[contains(@class,'header-nav-primary__link')][contains(text(),'Technology')]")
    private WebElement buttonTechnology;

    @FindBy(xpath = "//a[contains(@class,'header-nav-primary__link')][contains(text(),'Business')]")
    private WebElement buttonBusiness;

    @FindBy(xpath = "//a[contains(@class,'header-nav-primary__link')][contains(text(),'Money')]")
    private WebElement buttonMoney;

    @FindBy(xpath = "//a[contains(@class,'header-nav-primary__link')][contains(text(),'Opinion')]")
    private WebElement buttonOpinion;

    @FindBy(xpath = "//a[contains(@class,'header-nav-primary__link')][contains(text(),'Lifestyle')]")
    private WebElement buttonLifestyle;

    @FindBy(xpath = "//a[contains(@class,'header-nav-primary__link')][contains(text(),'Culture')]")
    private WebElement buttonCulture;

    @FindBy(xpath = "//a[contains(@class,'header-nav-primary__link')][contains(text(),'Travel')]")
    private WebElement buttonTravel;

    public String getSectionUrl() {
        return Driver.get().getCurrentUrl();
    }

    public enum Sections {
        NEWS("https://www.telegraph.co.uk/news/"),
        POLITICS("https://www.telegraph.co.uk/politics/"),
        SPORT("https://www.telegraph.co.uk/sport/"),
        TECHNOLOGY("https://www.telegraph.co.uk/technology/"),
        BUSINESS("https://www.telegraph.co.uk/business/"),
        MONEY("https://www.telegraph.co.uk/money/"),
        OPINION("https://www.telegraph.co.uk/opinion/"),
        LIFESTYLE("https://www.telegraph.co.uk/lifestyle/"),
        CULTURE("https://www.telegraph.co.uk/culture/"),
        TRAVEL("https://www.telegraph.co.uk/travel/");
        private final String url;


        Sections(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    public void goToPage(Sections clickButton) {
        switch (clickButton) {
            case NEWS:
                clickOn(buttonNews);
                break;
            case POLITICS:
                clickOn(buttonPolitics);
                break;
            case SPORT:
                clickOn(buttonSport);
                break;
            case TECHNOLOGY:
                clickOn(buttonTechnology);
                break;
            case BUSINESS:
                clickOn(buttonBusiness);
                break;
            case MONEY:
                clickOn(buttonMoney);
                break;
            case OPINION:
                clickOn(buttonOpinion);
                break;
            case LIFESTYLE:
                clickOn(buttonLifestyle);
                break;
            case CULTURE:
                clickOn(buttonCulture);
                break;
            case TRAVEL:
                clickOn(buttonTravel);
                break;
            default:
                throw new NoSuchElementException("Invalid option");
        }
    }
}