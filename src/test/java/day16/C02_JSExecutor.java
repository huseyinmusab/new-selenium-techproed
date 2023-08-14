package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_JSExecutor extends TestBaseBeforeAfter {
    /*
Selenium ile web elementlerinin kontrollerini sağlarken selenium komutları yetersiz kalabilir veya
sorunlarla karşılaşabiliriz.
Bu durumlarda alternatif olarak üstesinden gelmek için JavascriptExecutor class’ini dahil edebiliriz.
JavaScript HTML kodlara direk erişip yönetebilen bir script dili olduğundan bize çok fazla kolaylık sağlayabilir.
-------------------------------------------------------
Js Executors
1.Adim : JavascriptExecutor kullanmak icin ilk adim olarak driver’imizi JavascriptExecutor’a cast edelim
2.Adim : Kullanacagimiz WebElement’I locate edelim
3.Adim : Js driver ile executeScript method’unu calistiralim, icine parameter olarak ilgili script ve webelemnt’I yazalim
Ornegin Sell elementine click yapmak icin
-------------------------------------------------------
Js Executors ScroolIntoView Class Work
1 Yeni bir class olusturun : ScroolInto
2 hotelmycamp anasayfasina gidin
3 2 farkli test method’u olusturarak actions classi ve Js Executor kullanarak asagidaki oda turlerinden ust sira ortadaki odayi tiklayin
4 istediginizodaincelemesayfasiacildiginitest edin
     */

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        WebElement careers = driver.findElement(By.xpath("//a[text()='Careers']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",careers);
        //click on careers button with js
        js.executeScript("arguments[0].click();",careers);




    }
}
