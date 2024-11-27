package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utility.Helpers.waitForElementToDisappear;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptNotificationButton;

    public void clickAcceptNotificationButton() {
        acceptNotificationButton.click();
        waitForElementToDisappear(acceptNotificationButton);
    }
}

