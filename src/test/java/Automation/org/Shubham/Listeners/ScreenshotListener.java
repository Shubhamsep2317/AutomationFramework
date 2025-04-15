package Automation.org.Shubham.Listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static Automation.org.Shubham.Driver.DriverManager.getDriver;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = getDriver();

        String methodName = result.getName();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY:HH-MM-SS");

        if (driver != null) {
            File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String screenshotPath = "FailTests-Screenshots/" + methodName + "_" +
                        simpleDateFormat.format(calendar.getTime()) + ".png";
                FileUtils.copyFile(scr, new File(screenshotPath));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
