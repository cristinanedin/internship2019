package internship.framework.core.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class NavigationUtils {
    private NavigationUtils() {
    }

    public static void refreshTab() {
        Driver.get().navigate().refresh();
    }

    public static void deleteCookiesAndRefresh() {
        Driver.get().manage().deleteAllCookies();
        Wait.until(() -> Driver.get().manage().getCookies().isEmpty());
        Driver.get().navigate().refresh();
    }

    public static Alert switchToAlert(int timeout) {
        new WebDriverWait(Driver.get(), timeout).until(ExpectedConditions.alertIsPresent());
        return Driver.get().switchTo().alert();
    }

    public static void dismissAlert(Alert alert) {
        alert.dismiss();
        Driver.get().switchTo().defaultContent();
    }

    public static void acceptAlert(Alert alert) {
        alert.accept();
        Driver.get().switchTo().defaultContent();
    }

    public static void setWindowSize(int newWidth, int newHeight) {
        Driver.get().manage().window().setSize(new Dimension(newWidth, newHeight));
    }

    public static String getCurrentHandle() {
        return Driver.get().getWindowHandle();
    }

    public static List<String> getListOfHandles() {
        return new ArrayList<>(Driver.get().getWindowHandles());
    }

    public static void switchToFirstTab() {
        List<String> handles = new ArrayList<>(Driver.get().getWindowHandles());
        if (handles.size() > 0) {
            switchToHandle(handles.get(0));
        }
    }

    public static void switchToHandle(String handle) {
        ProjectLogger.info("Switch to handle " + handle);
        Driver.get().switchTo().window(handle);
    }

    public static void switchToSpecificTab(int windowNumber) {
        List<String> handles = new ArrayList<>(Driver.get().getWindowHandles());
        if (handles.size() > 0) {
            switchToHandle(handles.get(windowNumber));
        }
    }

    public static void closeCurrentTab() {
        Driver.get().close();
    }
}
