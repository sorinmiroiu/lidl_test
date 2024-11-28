package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.BasePage;
import pages.LoginPage;
import utility.DriverManager;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotSame;
import static utility.Helpers.waitForPageLoad;

public class LoginSteps {
    private final BasePage basePage;
    private final LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage(DriverManager.getDriver());
        basePage = new BasePage(DriverManager.getDriver());
    }

    @Given("the user is on the main page")
    public void the_user_is_on_the_login_page() {
        basePage.clickAcceptNotificationButton();
    }

    @When("the user enters credentials")
    public void the_user_enters_credentials() {
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
    }

    @When("the user enters specific credentials {word} and {word}")
    public void the_user_enters_specific_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @When("the user goes to login page")
    public void the_user_clicks_the_login_button() {
        loginPage.clickToLoginButton();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        String expectedUrl = "https://www.lidl.de/mla/";
        waitForPageLoad(expectedUrl);
        assertEquals(basePage.getCurrentPage(), expectedUrl);
    }

    @Then("the user should not be redirected to the dashboard")
    public void the_user_should_not_be_redirected_to_the_dashboard() {
        String expectedUrl = "https://www.lidl.de/mla/";
        assertNotSame(basePage.getCurrentPage(), expectedUrl);
    }
}
