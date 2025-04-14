package Automation.org.Shubham.Tests.VWO;

import Automation.org.Shubham.Base.CommonToAllTests;
import Automation.org.Shubham.Driver.DriverManager;
import Automation.org.Shubham.Pages.POM.VWO.LoginPage;
import Automation.org.Shubham.Utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Automation.org.Shubham.Driver.DriverManager.getDriver;

public class LoginTests extends CommonToAllTests {

    @Description("Verify login with invalid credentials: invalid username and invalid password")
    @Test
    public void loginWithInValidCredentials() {

        // Driver initialisation
        DriverManager.init();


        //Calling Login Page from Pages--->>> POM
        LoginPage loginPage = new LoginPage(getDriver());
        String error_message = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        // Assertions
        Assert.assertEquals(error_message, PropertiesReader.readKey("error_message"));
    }


}
