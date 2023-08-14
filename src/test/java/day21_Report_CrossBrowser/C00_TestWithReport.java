package day21_Report_CrossBrowser;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCarPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C00_TestWithReport extends TestBaseReport {
    BlueRentalCarPage blueRentalCarPage=new BlueRentalCarPage();

    @Test
    public void test01(){
        extentTest=extentReports.createTest("Positive Test Case","Log in with Valid Credentials");
        Driver.getDriver().get(ConfigReader.getProperty("bcrlUrl"));
        blueRentalCarPage.login.click();
        extentTest.info("User clicks on login");

        blueRentalCarPage.userEmail.sendKeys(ConfigReader.getProperty("userEmail"));
        blueRentalCarPage.userPassword.sendKeys(ConfigReader.getProperty("pass"));
        extentTest.info("User enters the credentials");

        blueRentalCarPage.userlogin.click();
        extentTest.info("User clicks on login");

        System.out.println(blueRentalCarPage.loggedIn.getText());
        Assert.assertEquals(blueRentalCarPage.loggedIn.getText(),"John Walkt");
        extentTest.info("User asserts his/her username");
        extentTest.pass("User logs in successfully");




    }



}
