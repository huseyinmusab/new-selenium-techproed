package day23;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlueRentalCarPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DataProviderEmailPassword {
    BlueRentalCarPage blueRentalCarPage=new BlueRentalCarPage();

    //multi dimensional arrays
    @DataProvider
    public static Object[][] users() {
        return new Object[][]{{"erol@gmail.com","12345"},{"evren@gmail.com","12345"},{"huseyin@gmail.com","98765"}};
    }

    @Test(dataProvider = "users")
    public void test01(String email,String password){
        Driver.getDriver().get(ConfigReader.getProperty("bcrlUrl"));
        blueRentalCarPage.login.click();

        blueRentalCarPage.userEmail.sendKeys(email);
        blueRentalCarPage.userPassword.sendKeys(password);

        blueRentalCarPage.userlogin.click();

        Assert.assertTrue(blueRentalCarPage.userlogin.isDisplayed());
        //Bu test Test raporlamada kullanilan test , TestBaseReport Class a extendi vardi, raporlu sekilde kullnilinca
        //TestBaseReport da "closeDriver()" methodu oldugu icin ilk datayi girdikten sonra driver kapaniyor ve
        //sonraki datalari giremiyoruz. o yuzden raporsuz taptik , raporlu olacak sekilde tkrar testi dizayn edebiliriz

    }


//    @Test(dependsOnMethods = "test01")
//    public void test02(){
//      Driver.closeDriver();
//    }
    @AfterClass
    public void test03(){
        Driver.closeDriver();
    }

}
