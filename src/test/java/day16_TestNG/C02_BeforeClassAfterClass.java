package day16_TestNG;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeAfterClassTestNG;

public class C02_BeforeClassAfterClass extends TestBaseBeforeAfterClassTestNG {
    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com");

    }

    @Test
    public void bestBuyTest(){
        driver.get("https://www.bestbuy.com");

    }

    @Test
    public void techpro(){
        driver.get("https://www.techproeducation.com");

    }

}
