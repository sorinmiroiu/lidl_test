package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
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
    public void tearDown() {
        DriverManager.quitDriver();
    }
}

