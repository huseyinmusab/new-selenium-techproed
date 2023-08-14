package day16_TestNG;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethodTestNG;

public class C01_BeforeMethodAfterMethod extends TestBaseBeforeMethodAfterMethodTestNG {

    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com");

    }

    @Test(groups = "group1") //===>this is for xml files for "executeDefinedGroups"
    public void bestBuyTest(){
        driver.get("https://www.bestbuy.com");
    }


    @Test(groups = "group1") //===>this is for xml files for "executeDefinedGroups"
    public void techpro(){
        driver.get("https://www.techproeducation.com");
    }
}
