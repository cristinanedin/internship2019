package internship.framework.core.utility;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static internship.framework.core.utility.Constants.TEN_SECONDS_TIMEOUT;
import static internship.framework.core.utility.Constants.THIRTY_SECONDS_TIMEOUT;
import static internship.framework.core.utility.Constants.VALUE_ATTRIBUTE;

public class ElementUtils {

    private ElementUtils() {
    }

    public static void clickOn(WebElement element) {
        if (doesAppear(element)) {
            waitForBeClickable(element, THIRTY_SECONDS_TIMEOUT);
            element.click();
        } else {
            throw new NoSuchElementException("Element Not visible");
        }
    }

    public static void clickOnWithJs(WebElement element) {
        waitForBeClickable(element, THIRTY_SECONDS_TIMEOUT);
        (Driver.get()).executeScript("arguments[0].click();", element);
    }

    public static void moveMouseToRightCorner() {
        Actions action = new Actions(Driver.get());
        action.moveByOffset(0, 0).build().perform();
    }

    public static void mouseHover(WebElement element) {
        waitFor(element);
        Actions action = new Actions(Driver.get());
        action.moveToElement(element).build().perform();
    }

    public static void scrollToElement(WebElement elementToScroll) {
        waitFor(elementToScroll);
        (Driver.get()).executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
    }

    public static void clearField(WebElement inputField) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].value=\"\";", inputField);
    }

    public static void setFieldValue(WebElement inputField, String value) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[1].value = arguments[0]; ", value, inputField);
    }

    public static void fillInWithValue(WebElement element, String value) {
        waitFor(element);
        element.clear();
        element.sendKeys(value);
    }

    public static void clearFieldUsingBackSpace(WebElement element) {
        int textLength = element.getAttribute(VALUE_ATTRIBUTE).length();
        for (int i = 0; i < textLength; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public static boolean doesAppear(WebElement element) {
        return doesAppear(element, THIRTY_SECONDS_TIMEOUT);
    }

    public static boolean doesAppear(WebElement element, long timeOutInSeconds) {
        return doesAppear(ExpectedConditions.visibilityOf(element), timeOutInSeconds);
    }

    private static boolean doesAppear(ExpectedCondition<WebElement> expectedCondition, long timeOutInSeconds) {
        setImplicitWaitTime(0);
        FluentWait<RemoteWebDriver> wait = createFluentWait(timeOutInSeconds);
        try {
            wait.until(expectedCondition);
            return true;
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        } finally {
            setImplicitWaitTime(1);
        }
        return false;
    }

    public static List<String> getElementsText(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();
        for (WebElement elem : elements) {
            texts.add(elem.getText());
        }
        return texts;
    }

    public static String getElementInputText(WebElement element) {
        if (doesAppear(element, TEN_SECONDS_TIMEOUT)) {
            waitForAttribute(element, TEN_SECONDS_TIMEOUT);
            return element.getAttribute(VALUE_ATTRIBUTE);
        }
        return StringUtils.EMPTY;
    }

    public static String getElementText(WebElement element) {
        if (doesAppear(element, TEN_SECONDS_TIMEOUT)) {
            return element.getText();
        }
        return StringUtils.EMPTY;
    }

    private static FluentWait<RemoteWebDriver> createFluentWait(long timeOutInSeconds) {
        return new FluentWait<>(Driver.get())
            .withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
            .pollingEvery(500, TimeUnit.MILLISECONDS)
            .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    private static void setImplicitWaitTime(double seconds) {
        int milliseconds = (int) (seconds * 1000);
        Driver.get().manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
    }

    public static void waitFor(WebElement element) {
        waitFor(element, THIRTY_SECONDS_TIMEOUT);
    }

    public static void waitFor(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), (long) timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean hasAttribute(WebElement elem, String attribute) {
        return elem.getAttribute("innerHTML").contains(" " + attribute);
    }

    public static void waitForBeClickable(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), (long) timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForAttribute(WebElement element, String attributeValue, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), (long) timeOutInSeconds);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attributeValue));
    }

    private static void waitForAttribute(WebElement element, int timeOutInSeconds) {
        waitForAttribute(element, VALUE_ATTRIBUTE, timeOutInSeconds);
    }

    public static WebElement getWebElementByXpath(String xpath) {
        return Driver.get().findElement(By.xpath(xpath));
    }

    public static List<WebElement> getWebElementsByXpath(String xpath) {
        return Driver.get().findElements(By.xpath(xpath));
    }

    public static WebElement getWebElementById(String id) {
        return Driver.get().findElement(By.id(id));
    }
}