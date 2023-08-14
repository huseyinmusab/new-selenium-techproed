package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        //use action methods to write samsung a71 and click enter
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(searchBox).sendKeys("s")
                .sendKeys("a")
                .sendKeys("m")
                .sendKeys("s")
                .sendKeys("u")
                .sendKeys("n")
                .sendKeys("g")
                .sendKeys(" ")
                .keyDown(Keys.SHIFT)//clicking shift button
                .sendKeys("a")
                .keyUp(Keys.SHIFT)//shift tusundan cikmak icin kullanilir
                .sendKeys("1")
                .perform();


    }

}
