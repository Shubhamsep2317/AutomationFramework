package Automation.org.Shubham.Listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static Automation.org.Shubham.Driver.DriverManager.getDriver;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = getDriver();

        if (driver != null) {
            // Get test method name
            String methodName = result.getName();

            // Get current date and time
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");

            // Capture screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define screenshot path
            String screenshotPath = System.getProperty("user.dir") + "/FailTests-Screenshots/" +
                    methodName + "_" + simpleDateFormat.format(calendar.getTime()) + ".png";

            try {
                // Save screenshot
                FileUtils.copyFile(srcFile, new File(screenshotPath));

                // Log link to screenshot in report
                Reporter.log("<br><a href='file://" + screenshotPath + "' target='_blank'>"
                        + "Click to view screenshot</a><br>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
