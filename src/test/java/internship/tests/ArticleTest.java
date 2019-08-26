package internship.tests;

import internship.framework.core.TestBase;
import internship.framework.pages.ArticlePage;
import org.testng.annotations.Test;

public class ArticleTest extends TestBase {

    @Test(testName = "Article Test", description = "Testing article functionality")
    public void checkArticleFunctionality()
    {
        ArticlePage articlePage = new ArticlePage().openPage();
        softAssert.get().assertTrue(articlePage.isChannelLinkDisplayed(), "Channel link is not displayed.");
        softAssert.get().assertTrue(articlePage.isHeadlineTextDisplayed(), "Headline text is not displayed.");
        softAssert.get().assertTrue(articlePage.isImageLeadAssetDisplayed(), "Image lead asset is not displayed.");
        softAssert.get().assertTrue(articlePage.isAuthorNameTextDisplayed(), "Author name text is not displayed.");
        softAssert.get().assertTrue(articlePage.isArticleDatePublishedDisplayed(), "Article date published is not displayed.");
        softAssert.get().assertTrue(articlePage.isBodyTextSectionDisplayed(), "Body text selection is not displayed.");
        softAssert.get().assertTrue(articlePage.isShareFacebookLinkDisplayed(), "Facebook share link is not displayed.");
        softAssert.get().assertTrue(articlePage.isShareTwitterLinkDisplayed(), "Twitter share link is not displayed.");
        softAssert.get().assertTrue(articlePage.isShareEmailLinkDisplayed(), "Email share link is not displayed.");
        softAssert.get().assertTrue(articlePage.isFollowFacebookLinkDisplayed(), "Facebook follow link is not displayed.");
        softAssert.get().assertTrue(articlePage.isFollowTwitterLinkDisplayed(), "Twitter follow link is not displayed.");
        softAssert.get().assertTrue(articlePage.isFollowInstagramLinkDisplayed(), "Instagram follow link is not displayed.");
        softAssert.get().assertTrue(articlePage.isFollowLinkedInLinkDisplayed(), "LinkedIn follow link is not displayed.");
        softAssert.get().assertAll();
    }
}
