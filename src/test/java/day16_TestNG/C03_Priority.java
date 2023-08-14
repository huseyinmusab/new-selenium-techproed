package day16_TestNG;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBaseBeforeMethodAfterMethodTestNG;

public class C03_Priority extends TestBaseBeforeMethodAfterMethodTestNG {
    /*
➢ TestNG (default) olarak @Test methodlarıni alfabetik sıraya göre run eder. (Yukardan asagi degil!)
➢ priority annotation Testlere öncelik vermek için kullanılır. Kucuk olan Numara daha once calisir
➢ priority yazmayan Test method’u varsa priority= 0 kabul edilir, siralama buna gore yapilir
     */
    @Test(priority = 1,groups = "group2")
    public void amazonTest(){
        driver.get("https://www.amazon.com");
    }


    @Test(priority = 3)
    public void bestBuyTest(){
        driver.get("https://www.bestbuy.com");

    }

    @Test(priority = 2,groups = "group2")
    public void techpro(){
        driver.get("https://www.techproeducation.com");

    }

}
