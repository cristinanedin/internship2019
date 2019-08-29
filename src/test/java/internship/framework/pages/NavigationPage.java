package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.clickOn;

public class NavigationPage extends PageBase {

    @FindBy(xpath = "//header[@id='navigation']//li[1]//a[1]")
    private WebElement buttonNews;

    @FindBy(xpath = "//header[@id='navigation']//li[2]//a[1]")
    private WebElement buttonPolitics;

    @FindBy(xpath = "//header[@id='navigation']//li[3]//a[1]")
    private WebElement buttonSport;

    @FindBy(xpath = "//header[@id='navigation']//li[4]//a[1]")
    private WebElement buttonBusiness;

    @FindBy(xpath = "//header[@id='navigation']//li[5]//a[1]")
    private WebElement buttonMoney;

    @FindBy(xpath = "//header[@id='navigation']//li[6]//a[1]")
    private WebElement buttonOpinion;

    @FindBy(xpath = "//header[@id='navigation']//li[7]//a[1]")
    private WebElement buttonTechnology;

    @FindBy(xpath = "//header[@id='navigation']//li[8]//a[1]")
    private WebElement buttonLifestyle;

    @FindBy(xpath = "//header[@id='navigation']//li[9]//a[1]")
    private WebElement buttonTravel;

    @FindBy(xpath = "//header[@id='navigation']//li[10]//a[1]")
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