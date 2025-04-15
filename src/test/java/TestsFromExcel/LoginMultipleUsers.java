package TestsFromExcel;

import Automation.org.Shubham.Base.CommonToAllTests;
import Automation.org.Shubham.Driver.DriverManager;
import Automation.org.Shubham.Pages.POM.VWO.DashBoardPage;
import Automation.org.Shubham.Pages.POM.VWO.LoginPage;
import Automation.org.Shubham.Utils.PropertiesReader;
import UtilExcel.UtilExcel;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Automation.org.Shubham.Driver.DriverManager.getDriver;

public class LoginMultipleUsers extends CommonToAllTests {

    @Owner("Shubham")
    @Description("Verify login via multiple sets of username and password")
    @Test(dataProvider = "getData")
    public void verifyLoginWithValidInvalidCredentials(String username, String password){

        DriverManager.init();

        getDriver().navigate().to(PropertiesReader.readKey("url"));

        LoginPage loginPage=new LoginPage(getDriver());
        String error_message=loginPage.loginToVWOLoginInvalidCreds(username, password);

        Assert.assertEquals(error_message, PropertiesReader.readKey("error_message"));



    }

    @DataProvider
    public Object[][] getData(){
       return UtilExcel.getExcelDataUtil("Sheet1");
    }
}
