package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeAfter;

public class C02_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01(){
        driver.get("https://www.facebook.com");
        //pass cookies
        driver.findElement(By.cssSelector("[title=\"Allow all cookies\"]")).click();

        //click create button
        driver.findElement(By.xpath("//a[text()=\"Create new account\"]")).click();

        //first name
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Erol");
        actions.sendKeys(Keys.TAB)//clicking TAB button to pass next one(sirname)
                .sendKeys("Evren")
                .sendKeys(Keys.TAB)
                .sendKeys("evreng@GMAIL.COM")
                .sendKeys(Keys.TAB)
                .sendKeys("1233456").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("1").sendKeys(Keys.TAB).sendKeys("Tem").perform();//it goes like that. try later




    }
}
