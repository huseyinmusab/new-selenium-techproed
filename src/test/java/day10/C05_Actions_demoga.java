package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_Actions_demoga extends TestBaseBeforeAfter {

    @Test
    public void test01(){
        //sayfa sifre istiyor, kodlardan anlasilir
        driver.get("https://www.demoga.com/droppable");
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));

        WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));

        //Actions
        //Actions actions = new Actions(driver); ===>Instead of creating an object every single time, we can create it in TestBase
        actions.dragAndDrop(dragMe,dropHere).perform();

        //assertion
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped']")).getText());

    }



}
