package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utility.ConfigReader.getProperty;
import static utility.ConfigReader.getTimeToWait;

public class Helpers {
    private static final Duration timeToWait =  getTimeToWait();

    public static void waitForElementToDisappear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeToWait);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForElementToAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeToWait);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
