package day18_PomStarts;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverFirstTest {
    //instead of extend now we started to use Driver class by calling getDriver() static method

    @Test
    public void test01(){
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get("https://www.bestbuy.com");
        Driver.getDriver().get("https://www.hepsiburada.com");
        Driver.closeDriver();
    }

}
