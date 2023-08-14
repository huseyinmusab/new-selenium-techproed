package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethodTestNG;

public class C02_SoftAssert extends TestBaseBeforeMethodAfterMethodTestNG {

    @Test
    public void testSoft(){
/*
 =====SOFT ASSERT-Verification==============
SoftAssert doğrulama (verification) olarak dabilinir.
softAssert kullandigimizda, assert FAILED olsa bile test method’unun istediginiz kismini durdurmaz ve yürütmeye devam eder.
 İf else statement’da olduğu gibi.
Test method’unun istedigimiz bolumde yapilan tum testleri raporlar
Eger assertion’lardan FAILED olan varsa raporlama yapilan satirdan sonrasini calistirmaz.
SoftAssert class’indaki method’lari kullanmak icin kullanabilmemiz için object olusturmamiz gerekir

• 1.Adım: SoftAssert objesi olusturalim
SoftAssert softAssert = new SoftAssert( );

2.Adım: Istedigimiz sayida verification’lari yapalim softAssert.assertTrue( );
softAssert.assertFalse( ); ....

3.Adım: SoftAssert’in durumu raporlamasini isteyelim softAssert.assertAll();
======================================================
****SOFT AND HARD ASSERT****
● Ortak ozellikleri
SoftAssert ve HardAssert method’ları TestNG’den gelmektedir.
Kullanma amaçları farklı olsa da method’lar aynıdır.

● Farklari
•Hard Assertion fail olursa test method’larının execute etmesi durur. Ve FAILED olarak tanımlanır.
•Eğer softAssert FAIL olursa test method’ları execute etmeye devam eder. assertAll dedigimizde FAILED olan assertion varsa execution durur.

 */

        SoftAssert softAssert=new SoftAssert();
        driver.get("https://www.amazon.com");
        //assert the title
        softAssert.assertTrue(driver.getTitle().contains("AmazonXX"),"does NOT include the given word");

        //search box is accesible
        WebElement searchbox= driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(searchbox.isEnabled(),"WE is not reachable");

        //type somth
        searchbox.sendKeys("NutellaXX", Keys.ENTER);

        //test the search
        WebElement result=driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        softAssert.assertTrue(result.isDisplayed(),"result is not able to be seen");

        //test the text in search result
        softAssert.assertTrue(result.getText().contains("NutellaXXX"),"does NOT include Nutella");
        //softAssert.assertAll();

        //



    }


}
