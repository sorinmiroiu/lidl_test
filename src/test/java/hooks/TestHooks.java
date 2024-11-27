package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utility.DriverManager;
import utility.ConfigReader;

public class TestHooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.getUrl());
        System.out.println("WebDriver initialized");
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

