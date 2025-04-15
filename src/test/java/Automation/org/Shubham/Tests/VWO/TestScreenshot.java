package Automation.org.Shubham.Tests.VWO;

import Automation.org.Shubham.Base.CommonToAllTests;
import Automation.org.Shubham.Listeners.RetryAnalyser;
import Automation.org.Shubham.Listeners.ScreenshotListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ScreenshotListener.class)
public class TestScreenshot extends CommonToAllTests {

    @Test(retryAnalyzer = RetryAnalyser.class)
    public void testScreenshot(){
        Assert.assertTrue(false);
    }
}
