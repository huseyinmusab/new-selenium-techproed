package day18_PomStarts;
/*
1) smoketest
2) Bir Class olustur : PositiveTest
3) Bir test method olustur positiveLoginTest()
https://www.hotelmycamp.com adresine git login butonuna bas
test data username: manager ,
test data password : Manager1!
Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
 */

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCamp;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_ConfigReader_Test {

    HotelMyCamp hotelMyCamp = new HotelMyCamp();

    @Test
    public void test01(){

        //https://www.hotelmycamp.com adresine git login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));
        hotelMyCamp.loginButton.click();

        //test data username: manager ,
        hotelMyCamp.userName.sendKeys("manager");
        //test data password : Manager1!
        hotelMyCamp.password.sendKeys("Manager1!");
        hotelMyCamp.enterLogin.click();



    }


    @Test
    public void test02(){
        //WITH ACTION CLASS for clicking TAB and GET PROPERTY
        //https://www.hotelmycamp.com adresine git login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));
        hotelMyCamp.loginButton.click();

        //test data username: manager ,
        hotelMyCamp.userName.sendKeys(ConfigReader.getProperty("userName"));

        //test data password : Manager1!
        //without locate by using TAB ===> TO PASS PASSWORD TAB DIRECTLY
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).sendKeys(Keys.ENTER).perform();

        System.out.println(hotelMyCamp.displayedUsername.getText());

        Assert.assertTrue(hotelMyCamp.displayedUsername.isDisplayed());




    }

}
