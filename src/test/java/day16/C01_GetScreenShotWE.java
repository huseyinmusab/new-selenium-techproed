package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenShotWE extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        driver.get("https://www.amazon.com");
        //search nutella
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        //screenshot the search result text
        WebElement searchResult = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaSearchResult = searchResult.getScreenshotAs(OutputType.FILE);

        //ONLY SHOT THE WEB ELEMENT.SO NO NEED TakeScreenShot  ********!!!!
        //put the located element to a temporary file,copy with FileUtils and arrange the path
        FileUtils.copyFile(nutellaSearchResult,new File("target/screenshotsWE/WebESS "+date +".jpeg"));



    }

}
