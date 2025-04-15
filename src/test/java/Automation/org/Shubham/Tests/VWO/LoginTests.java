package Automation.org.Shubham.Tests.VWO;

import Automation.org.Shubham.Base.CommonToAllTests;
import Automation.org.Shubham.Driver.DriverManager;
import Automation.org.Shubham.Pages.POM.VWO.DashBoardPage;
import Automation.org.Shubham.Pages.POM.VWO.LoginPage;
import Automation.org.Shubham.Utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Automation.org.Shubham.Driver.DriverManager.getDriver;

public class LoginTests extends CommonToAllTests {

    @Description("Verify login with invalid credentials: invalid username and invalid password")
    @Test(priority = 1)
    public void loginWithInValidCredentials() {

        //Calling Login Page from Pages--->>> POM
        LoginPage loginPage = new LoginPage(getDriver());
        String error_message = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        // Assertions
        Assert.assertEquals(error_message, PropertiesReader.readKey("error_message"));
    }

    @Description("Verify login with valid credentials: Valid username and password")
    @Test(priority = 2)
    public void loginWithValidCredentials(){

        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage=new DashBoardPage(getDriver());
        String username=dashBoardPage.loggedInUserName();

        Assert.assertEquals(username,PropertiesReader.readKey("expected_username"));

    }


}
