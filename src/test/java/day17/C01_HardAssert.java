package day17;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethodTestNG;

public class C01_HardAssert extends TestBaseBeforeMethodAfterMethodTestNG {

    @Test
    public void test01(){
        /*
Test Otomasyonun temel noktalarından biri Assertions’dır.
➢ Her bir test case icin bir Assertion veya Verification kullanmalıyız.
➢ TestNG ile iki cesit Asertion yapmak mumkundur.
1 ) Junit’te kullandigimiz sekilde Assert Class’indan method’lar kullanarak yapmak.
2 ) Junit’te olmayan, TestNG’ye ozel olarak kullanabilecegimiz SoftAssert Class’indan method’lar kullanarak yapmak.

==================================================================================================================
=========HARD ASSERT=========
JUnit'te Öğrendiğimiz Assertion ile aynidir. TestNG’de soft assertion da oldugundan, ayristirmak icin
bu isim kullanilmistir.
JUnit’ten bildigimiz uzere en çok kullandığımız 3 cesit hard assertion turu vardir
i. Assert.assertEquals( ) ii. Assert.assertTrue( ) iii. Assert.assertFalse( )
Hard assertion herhangi bir assertion FAILED olursa, test method’nun calismasini durdurur ve kalan kodlari yürütmez (stops execution).
Test case’in nerede FAILED olduğunu hemen anlamak ve kod’a direk mudahale etmek istenirse hard assertion tercih edilebilir.
         */
        driver.get("https://www.amazon.com");
        //assert the title
        Assert.assertTrue(driver.getTitle().contains("Amazon"),"does not include the given word");

        //search box is accesible
        WebElement searchbox= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchbox.isEnabled(),"WE is not reachable");

        //type somth
        searchbox.sendKeys("Nutella", Keys.ENTER);

        //test the search
        WebElement result=driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        Assert.assertTrue(result.isDisplayed(),"result is not able to be seen");

        //test the text in search result
        Assert.assertTrue(result.getText().contains("Nutella"),"does NOT include Nutella");
    }


}
