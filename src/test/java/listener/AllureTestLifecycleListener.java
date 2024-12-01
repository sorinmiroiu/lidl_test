package listener;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utility.DriverManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.qameta.allure.model.Status.BROKEN;
import static io.qameta.allure.model.Status.FAILED;

public class AllureTestLifecycleListener implements TestLifecycleListener {
    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        if (driver == null) {
            System.err.println("WebDriver instance is null. Cannot capture screenshot.");
            return null;
        }

        // Capture screenshot as bytes
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        // Save the screenshot locally
        try {
            String screenshotDir = "screenshots";
            File directory = new File(screenshotDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String screenshotPath = screenshotDir + "/" + System.currentTimeMillis() + "_screenshot.png";
            File screenshotFile = new File(screenshotPath);
            FileOutputStream fos = new FileOutputStream(screenshotFile);
            fos.write(screenshotBytes);
            fos.close();

            System.out.println("Screenshot saved at: " + screenshotFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save screenshot locally: " + e.getMessage());
        }

        // Return the screenshot bytes for Allure attachment
        return screenshotBytes;
    }



    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    private static String getTestMethodName(TestResult result) {
        return result.getName();
    }

    @Override
    public void beforeTestStop(TestResult result) {
//        if (FAILED == result.getStatus() || BROKEN == result.getStatus()) {
            System.out.println("Test failed or broken: " + getTestMethodName(result));

            // Capture screenshot and attach it to Allure
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                System.out.println("Capturing screenshot for Allure...");
                saveScreenshot(driver); // Attach screenshot to Allure
            } else {
                System.out.println("WebDriver is null. Screenshot not captured.");
            }

            // Add additional logs
            saveTextLog(getTestMethodName(result) + " failed.");
//        }
    }


}
