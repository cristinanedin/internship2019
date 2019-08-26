package internship.framework.pages;

import internship.framework.core.PageBase;
import internship.framework.core.utility.PageUrl;
import internship.framework.core.utility.ProjectLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static internship.framework.core.utility.ElementUtils.doesAppear;

@PageUrl("news/2019/08/15/homeowners-told-prepare-flooding-england-could-see-months-worth/")
public class ArticlePage extends PageBase {

    @FindBy(xpath = "//a[@class='breadcrumbs__item-content'][contains(text(),'News')]")
    private WebElement channelLink;

    @FindBy(xpath = "//h1[@class='headline__heading']")
    private WebElement headlineText;

    @FindBy(xpath = "//img[@class='responsive lead-asset__image']")
    private WebElement imageLeadAsset;

    @FindBy(xpath = "//a[contains(text(),'Lizzie Roberts')]")
    private WebElement authorNameText;

    @FindBy(xpath = "//time[@class='article-date-published']")
    private WebElement articleDatePublished;

    @FindBy(xpath = "//div[contains(@class,'js-article-inner')]//article")
    private WebElement bodyTextSection;

    @FindBy(xpath = "//aside[contains(@class,'social-block block-heading')]//li[contains(@class,'social-share__item social-share__facebook')]//a[contains(@class,'social-share__button')]")
    private WebElement shareFacebookLink;

    @FindBy(xpath = "//aside[contains(@class,'social-block block-heading')]//li[contains(@class,'social-share__item social-share__twitter')]//a[contains(@class,'social-share__button')]")
    private WebElement shareTwitterLink;

    @FindBy(xpath = "//aside[contains(@class,'social-block block-heading')]//li[contains(@class,'social-share__item social-share__email')]//a[contains(@class,'social-share__button')]")
    private WebElement shareEmailLink;

    @FindBy(xpath = "//div[@class='component-content']//li[@class='social-follow__item social-follow__facebook']//a[@class='social-follow__link']")
    private WebElement followFacebookLink;

    @FindBy(xpath = "//div[@class='component-content']//li[@class='social-follow__item social-follow__twitter']//a[@class='social-follow__link']")
    private WebElement followTwitterLink;

    @FindBy(xpath = "//div[@class='component-content']//li[@class='social-follow__item social-follow__instagram']//a[@class='social-follow__link']")
    private WebElement followInstagramLink;

    @FindBy(xpath = "//div[@class='component-content']//li[@class='social-follow__item social-follow__linkedin']//a[@class='social-follow__link']")
    private WebElement followLinkedInLink;

    public boolean isChannelLinkDisplayed()
    {
        ProjectLogger.info("Check if channel link is displayed.");
        return doesAppear(channelLink);
    }

    public boolean isHeadlineTextDisplayed()
    {
        ProjectLogger.info("Check if headline text is displayed.");
        return doesAppear(headlineText);
    }

    public boolean isImageLeadAssetDisplayed()
    {
        ProjectLogger.info("Check if image lead asset is displayed.");
        return doesAppear(imageLeadAsset);
    }

    public boolean isAuthorNameTextDisplayed()
    {
        ProjectLogger.info("Check if author name text is displayed.");
        return doesAppear(authorNameText);
    }

    public boolean isArticleDatePublishedDisplayed()
    {
        ProjectLogger.info("Check if article date published is displayed.");
        return doesAppear(articleDatePublished);
    }

    public boolean isBodyTextSectionDisplayed()
    {
        ProjectLogger.info("Check if body text section is displayed.");
        return doesAppear(bodyTextSection);
    }

    public boolean isShareFacebookLinkDisplayed()
    {
        ProjectLogger.info("Check if Facebook share link is displayed.");
        return doesAppear(shareFacebookLink);
    }

    public boolean isShareTwitterLinkDisplayed()
    {
        ProjectLogger.info("Check if Twitter share link is displayed.");
        return doesAppear(shareTwitterLink);
    }

    public boolean isShareEmailLinkDisplayed()
    {
        ProjectLogger.info("Check if Email share link is displayed.");
        return doesAppear(shareEmailLink);
    }

    public boolean isFollowFacebookLinkDisplayed()
    {
        ProjectLogger.info("Check if Facebook follow link is displayed.");
        return doesAppear(followFacebookLink);
    }

    public boolean isFollowTwitterLinkDisplayed()
    {
        ProjectLogger.info("Check if Twitter follow link is displayed.");
        return doesAppear(followTwitterLink);
    }

    public boolean isFollowInstagramLinkDisplayed()
    {
        ProjectLogger.info("Check if Instagram follow link is displayed.");
        return doesAppear(followInstagramLink);
    }

    public boolean isFollowLinkedInLinkDisplayed()
    {
        ProjectLogger.info("Check if LinkedIn follow link is displayed.");
        return doesAppear(followLinkedInLink);
    }

}
