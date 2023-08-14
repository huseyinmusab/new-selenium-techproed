package day10;

import org.junit.Test;
import utilities.TestBaseBeforeAfterClass;

public class C02_FirstTestBaseClass extends TestBaseBeforeAfterClass {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }
}
