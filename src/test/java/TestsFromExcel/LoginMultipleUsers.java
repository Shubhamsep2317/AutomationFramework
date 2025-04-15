package TestsFromExcel;

import Automation.org.Shubham.Base.CommonToAllTests;
import Automation.org.Shubham.Listeners.RetryAnalyser;
import Automation.org.Shubham.Listeners.ScreenshotListener;
import Automation.org.Shubham.Pages.POM.VWO.LoginPage;
import Automation.org.Shubham.Utils.PropertiesReader;
import UtilExcel.UtilExcel;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Automation.org.Shubham.Driver.DriverManager.getDriver;

@Listeners(ScreenshotListener.class)
public class LoginMultipleUsers extends CommonToAllTests {

    Logger logger=LogManager.getLogger(LoginMultipleUsers.class);

    @Owner("Shubham")
    @Description("Verify login via multiple sets of username and password")
    @Test(dataProvider = "getData",retryAnalyzer = RetryAnalyser.class)
    public void verifyLoginWithValidInvalidCredentials(String username, String password) {


        LoginPage loginPage = new LoginPage(getDriver());
        logger.info("Test case execution with multiple users starts");
        String error_message = loginPage.loginToVWOLoginInvalidCreds(username, password);
        logger.info("Checking expected error to actual error message");
        Assert.assertEquals(error_message, PropertiesReader.readKey("error_message"));
        logger.info("Test case execution ends");

    }

    @DataProvider
    public Object[][] getData() {
        return UtilExcel.getExcelDataUtil("Sheet1");
    }
}
