package Automation.org.Shubham.Base;

import Automation.org.Shubham.Utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Automation.org.Shubham.Driver.DriverManager.getDriver;

public class CommonToAllPages {
    public CommonToAllPages() {
        // If you want to call something before every Page Object Class call, Put your Code here");
        // Open File, Open Data Base Connection You can write code here
    }

    public void openVWOUrl(){
        getDriver().get(PropertiesReader.readKey("url"));
    }
    public void openOrangeHRMUrl(){
        getDriver().get(PropertiesReader.readKey("ohr_url"));
    }


    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }
    public void clickElement(WebElement by) {
        by.click();
    }

    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by, String key) {
        by.sendKeys(key);
    }

    public String getText(By by){
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by){
        return by.getText();
    }

}
