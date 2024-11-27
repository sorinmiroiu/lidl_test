package steps;

import hooks.TestHooks;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.BasePage;
import pages.LoginPage;

public class LoginSteps {
    private final BasePage basePage ;
    private final LoginPage loginPage;

    public LoginSteps() {
        WebDriver driver = TestHooks.getDriver();
        this.loginPage = new LoginPage(driver);
        this.basePage = new BasePage(driver);
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        basePage.clickAcceptNotificationButton();
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.enterUsername();
        loginPage.enterPassword();
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        String expectedUrl = "https://example.com/dashboard";
//        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}
