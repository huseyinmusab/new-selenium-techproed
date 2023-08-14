package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExistsUpload extends TestBaseBeforeAfter {

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/upload");

        //upload a file
        WebElement selectFolder = driver.findElement(By.xpath("//*[@id='file-upload']"));

        String filePath = "/Users/hueseyin.kocal/Downloads/text.txt";

        selectFolder.sendKeys(filePath);

        System.out.println(Files.exists(Paths.get(filePath)));///true
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

        driver.findElement(By.id("file-submit")).click();//click upload button

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());



    }
}
