package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCamp;
import pages.HotelMyCampHomePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class C02_E2ETestForHotelRoom {
    /*
1. Tests packagenin altına class olusturun: CreateHotel
2. Bir metod olusturun: createHotel
3. https://www.hotelmycamp.com adresine git.
4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri
a. Username : manager
b. Password : Manager1! 5. Login butonuna tıklayın.
6. Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
8. Save butonuna tıklayın.
9. “RoomReservation was inserted successfully” textinin göründüğünü test edin. 10. OK butonuna tıklayın.
     */


    HotelMyCamp hotelMyCamp=new HotelMyCamp();
    HotelMyCampHomePage hotelMyCampHomePage= new HotelMyCampHomePage();


    @Test
    public void test02() {

        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));
        hotelMyCamp.loginButton.click();

        //test data username: manager ,
        hotelMyCamp.userName.sendKeys(ConfigReader.getProperty("userName"));

        //test data password : Manager1!
        //without locate by using TAB ===> TO PASS PASSWORD TAB DIRECTLY
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).sendKeys(Keys.ENTER).perform();

        System.out.println(hotelMyCamp.displayedUsername.getText());

        Assert.assertTrue(hotelMyCamp.displayedUsername.isDisplayed());

        //6. Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
        hotelMyCampHomePage.hotelManagement.click();
       //hotelMyCampHomePage.allLeftHeaders ASSERT LEFT HEADERS
        for (int i = 0; i < hotelMyCampHomePage.allLeftHeaders.size(); i++) {
            System.out.println( i+" : "+hotelMyCampHomePage.allLeftHeaders.get(i).getText());
        }
        Assert.assertTrue(hotelMyCampHomePage.allLeftHeaders.get(1).getText().contains("Hotel List"));
        Assert.assertTrue(hotelMyCampHomePage.allLeftHeaders.get(2).getText().contains("Hotel Rooms"));
        Assert.assertTrue(hotelMyCampHomePage.allLeftHeaders.get(3).getText().contains("Room reservations"));
        System.out.println("*****************************************************");

        //6. Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
        hotelMyCampHomePage.allLeftHeaders3.get(3).click();
        hotelMyCampHomePage.addRoomReserv.click();

        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        //CONTINUE WIT TAB actions and Fake class

        WebElement dropdown= hotelMyCampHomePage.userDropdown;
        Select select=new Select(dropdown);

        List<WebElement> dropDownList=select.getOptions();
        for (int i = 0; i < dropDownList.size(); i++) {
            System.out.println(i+": "+dropDownList.get(i).getText());
        }

        
        System.out.println("*****************************************************");
        System.out.println(dropDownList.size());
        System.out.println("*****************************************************");
        select.selectByVisibleText("manager");
        actions.sendKeys(Keys.TAB).sendKeys("Happy Hotel")
                .sendKeys(Keys.TAB).sendKeys("1500$")
                .sendKeys(Keys.TAB).sendKeys("15/10/2023").perform();

        //go further later
        Driver.closeDriver();



    }
}
