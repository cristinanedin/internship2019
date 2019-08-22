package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.clickOn;

public class NavigationPage extends PageBase {

    @FindBy(xpath = "//span[contains(text(),'News')]")
    private WebElement buttonNews;

    @FindBy(xpath = "//span[contains(text(),'Politics')]")
    private WebElement buttonPolitics;

    @FindBy(xpath = "//span[@class='e-navigation-primary-item__link-text e-navigation-border'][contains(text(),'Sport')]")
    private WebElement buttonSport;

    @FindBy(xpath = "//span[contains(text(),'Business')]")
    private WebElement buttonBusiness;

    @FindBy(xpath = "//span[@class='e-navigation-primary-item__link-text e-navigation-border'][contains(text(),'Money')]")
    private WebElement buttonMoney;

    @FindBy(xpath = "//span[contains(text(),'Opinion')]")
    private WebElement buttonOpinion;

    @FindBy(xpath = "//span[contains(text(),'Tech')]")
    private WebElement buttonTechnology;

    @FindBy(xpath = "//span[contains(text(),'Life & Style')]")
    private WebElement buttonLifestyle;

    @FindBy(xpath = "//span[contains(text(),'Travel')]")
    private WebElement buttonTravel;

    @FindBy(xpath = "//span[contains(text(),'Culture')]")
    private WebElement buttonCulture;

    public String getSectionUrl() {
        return Driver.get().getCurrentUrl();
    }

    public enum Sections {
        NEWS("https://www.telegraph.co.uk/news/"),
        POLITICS("https://www.telegraph.co.uk/politics/"),
        SPORT("https://www.telegraph.co.uk/sport/"),
        BUSINESS("https://www.telegraph.co.uk/business/"),
        MONEY("https://www.telegraph.co.uk/money/"),
        OPINION("https://www.telegraph.co.uk/opinion/"),
        TECHNOLOGY("https://www.telegraph.co.uk/technology/"),
        LIFESTYLE("https://www.telegraph.co.uk/lifestyle/"),
        TRAVEL("https://www.telegraph.co.uk/travel/"),
        CULTURE("https://www.telegraph.co.uk/culture/");
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
            case BUSINESS:
                clickOn(buttonBusiness);
                break;
            case MONEY:
                clickOn(buttonMoney);
                break;
            case OPINION:
                clickOn(buttonOpinion);
                break;
            case TECHNOLOGY:
                clickOn(buttonTechnology);
                break;
            case LIFESTYLE:
                clickOn(buttonLifestyle);
                break;
            case TRAVEL:
                clickOn(buttonTravel);
                break;
            case CULTURE:
                clickOn(buttonCulture);
                break;
            default:
                throw new NoSuchElementException("Invalid option");
        }
    }
}