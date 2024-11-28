package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utility.DriverManager;
import utility.ConfigReader;

public class TestHooks {


    @Before
    public void setup() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(ConfigReader.getUrl());
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        DriverManager.quitDriver();
    }
}

