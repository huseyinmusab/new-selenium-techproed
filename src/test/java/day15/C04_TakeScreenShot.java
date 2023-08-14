package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_TakeScreenShot extends TestBaseBeforeAfter {
    /*
Get Screenshot / Tum Sayfa
Selenium 3 ile tum sayfanin fotografini alabiliyorduk, Selenium 4 ile gelen guzel ozelliklerden bir tanesi de
istedigimiz WebElement’in fotografini almamiza imkan tanimasi
1.Adim : Bir TakeScreenhot objesi olusturup driver’imizi TakeScreenhot’a cast yapalim
2.Adim : kaydettigimiz ekran goruntusunu projede istedigimiz yere kaydedebilmek icin path ile yeni bir File olusturalim
3.Adim : Takescreenshot objesini kullanarak getScreenshotAs( ) methodunu calistiralim ve gelen resmi gecici bir file’a assign edelim
4.Adim : Kaydettigimiz goruntuyu, saklamak istedigimiz dosyaya kopyalayalim

=======================================================================================
Get Screenshot / Spesific Webelement
1.Adim : Webelementi locate edelim:
2.Adim : kaydettigimiz ekran goruntusunu projede istedigimiz yere kaydedebilmek icin path ile yeni bir File olusturalim
3.Adim : Webelement uzerinden getScreenshotAs( ) methodunu calistiralim ve gelen resmi olusturdugumuz gecici file’a assign edelim
4.Adim : Gecici resmi, saklamak istedigimiz dosyaya kopyalayalim

Yeni bir class olusturun : amazonNutellaSearch
1-amazon anasayfaya gidin
2-amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
3- Nutella icin arama yapin
4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
     */


    @Test
    public void test01() throws IOException {
        driver.get("https://www.amazon.com");

        TakesScreenshot ts = (TakesScreenshot) driver;//only write driver first , then Casting

//PUT THIS TO EXTENDED TestBase Class
//        LocalDateTime dateTime=LocalDateTime.now();
//        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("YY-MM-dd-HH:mm:ss");//CREATING THE FORMAT FOR DATE
//        String date=dateTime.format(dateTimeFormatter);
//        System.out.println(date);
//        //System.out.println(dateTime);====>2023-07-26T18:45:26.369389==. this format we dont want,thats why we do formatter


        File allPageShot =ts.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(allPageShot,new File("target/screenshots/allPageShot.jpeg"));//under the target file
        FileUtils.copyFile(allPageShot,new File("target/screenshots/allPageShot "+date +".jpeg"));//under the target file and with "date" PERFECT!!!



    }




}
