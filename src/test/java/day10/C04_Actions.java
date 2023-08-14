package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfterClass;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfterClass {

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement areaWithLine =driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(areaWithLine).perform(); //right click

        String alertMessage= driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage,"You selected a context menu");

        //ok to close the alert
        driver.switchTo().alert().accept();

        //click and assert elemental Link
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //it opens a new window, so leads to opened new window
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        Assert.assertEquals("Make sure your code lands",driver.findElement(By.xpath("//h1")).getText());



    }

}
