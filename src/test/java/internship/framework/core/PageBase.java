package internship.framework.core;

import internship.framework.core.runner.GlobalProperties;
import internship.framework.core.utility.Driver;
import internship.framework.core.utility.NavigationUtils;
import internship.framework.core.utility.PageUrl;
import internship.framework.pages.Homepage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {
    private String pageUrl;
    private String baseUrl;

    public PageBase(boolean shouldBeDisplayed) {

        PageFactory.initElements(Driver.get(), this);
        if (this.getClass().getAnnotation(PageUrl.class) != null) {
            this.setPageUrl(this.getClass().getAnnotation(PageUrl.class).value());
        } else {
            this.setPageUrl(StringUtils.EMPTY);
        }
        this.baseUrl = GlobalProperties.BASE_URL;
    }

    public PageBase() {

        this(false);
    }

    private void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public final String getPageUrl() {
        return this.pageUrl;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getUrl() {
        return this.buildUrl();
    }

    private String buildUrl() {
        return baseUrl + pageUrl;
    }

    public <T extends PageBase> T  openPage() {
        this.open();
        NavigationUtils.deleteCookiesAndRefresh();
        return (T)this;
    }

    private void open() {
        Driver.get().get(getUrl());
        WebDriverWait wait = new WebDriverWait(Driver.get(), 30);
        wait.until(ExpectedConditions.urlContains(getUrl()));
        Driver.get().switchTo().defaultContent();
    }
}