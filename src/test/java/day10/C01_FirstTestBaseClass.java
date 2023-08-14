package day10;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class C01_FirstTestBaseClass extends TestBaseBeforeAfter {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

    }
}
