package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static utility.ConfigReader.getProperty;
import static utility.Helpers.waitForElementToAppear;
import static utility.Helpers.waitForElementToBeClickable;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "input-email")
    private WebElement usernameField;

    @FindBy(name = "Password")
    private WebElement passwordField;

    @FindBy(css = ".m-icon.m-icon--user")
    private WebElement toLoginButton;

    @FindBy(xpath = "//button[contains(.,'Anmelden')]")
    private WebElement loginButton;


    public void enterUsername(String username) {
        waitForElementToAppear(usernameField);
        usernameField.sendKeys(username);
    }

    public void enterUsername() {
        String username = getProperty("username");
        waitForElementToAppear(usernameField);
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterPassword() {
        String password = getProperty("password");
        passwordField.sendKeys(password);
    }


    public void clickToLoginButton() {
        waitForElementToBeClickable(toLoginButton);
        toLoginButton.click();
    }

    public void clickLoginButton() {
        waitForElementToAppear(loginButton);
        loginButton.click();
    }

}
