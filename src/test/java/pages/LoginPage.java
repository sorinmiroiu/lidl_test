package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

import static utility.ConfigReader.getProperty;
import static utility.Helpers.waitForElementToAppear;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (name = "input-email")
    private WebElement usernameField;

    @FindBy(name = "Password")
    private WebElement passwordField;

    @FindBy(css = ".m-icon.m-icon--user")
    private WebElement loginButton;


//    @FindBy(xpath = "//ul/li[contains(., 'Use next credentials to execute Login')]")
//    private WebElement credentialsElement;

    // Method that accepts parameters for entering username
//    public void enterUsername(String username) {
//        usernameField.sendKeys(username);
//    }

    // Method that uses extracted credentials from the page for username
    public void enterUsername() {
        String username = getProperty("username");
        waitForElementToAppear(usernameField);
        usernameField.sendKeys(username);
    }
//
//    // Method that accepts parameters for entering password
//    public void enterPassword(String password) {
//        passwordField.sendKeys(password);
//    }
//
    // Method that uses extracted credentials from the page for password
    public void enterPassword() {
        String password = getProperty("password");
        passwordField.sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        waitForElementToAppear(loginButton);
        loginButton.click();
    }

    // Method to extract credentials from the web page
//    public HashMap<String, String> extractCredentials() {
//        // Create a new HashMap to store the username and password
//        HashMap<String, String> credentialsMap = new HashMap<>();
//
//        // Extract text from the credentials element
//        String credentialsText = credentialsElement.getText();
//
//        // Split the text into lines (assuming each credential is on a new line)
//        String[] lines = credentialsText.split("\n");
//
//        // Iterate through the lines to find and extract the username and password
//        for (String line : lines) {
//            if (line.contains("Username")) {
//                String valueUsername = line.split(":")[1].trim(); // Extract username value
//                credentialsMap.put("username", valueUsername); // Store in map
//            }
//            if (line.contains("Password")) {
//                String valuePassword = line.split(":")[1].trim(); // Extract password value
//                credentialsMap.put("password", valuePassword); // Store in map
//            }
//        }
//        return credentialsMap;
//    }
}
