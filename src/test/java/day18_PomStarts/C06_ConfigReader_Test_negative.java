package day18_PomStarts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCamp;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_ConfigReader_Test_negative {
    HotelMyCamp hotelMyCamp = new HotelMyCamp();
    @Test
    public void test02(){
        //WITH ACTION CLASS for clicking TAB and GET PROPERTY
        //https://www.hotelmycamp.com adresine git login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));
        hotelMyCamp.loginButton.click();

        //test data username: manager ,
        hotelMyCamp.userName.sendKeys(ConfigReader.getProperty("hmcWrongName"));

        //test data password : Manager1!
        //without locate by using TAB ===> TO PASS PASSWORD TAB DIRECTLY
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongPassword")).sendKeys(Keys.ENTER).perform();


        System.out.println(hotelMyCamp.wrongLoginMessage.getText());

        Assert.assertTrue(hotelMyCamp.wrongLoginMessage.getText().contains(ConfigReader.getProperty("hmcWrongLoginMessage")));
        Driver.closeDriver();


    }

}
