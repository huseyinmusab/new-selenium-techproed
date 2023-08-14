package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExists extends TestBaseBeforeAfter {
    /*
1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
2. https://the-internet.herokuapp.com/download adresine gidelim.
3. text.txt dosyasını indirelim
4. Dosyanın başarıyla indirilip indirilmediğini test edelim
     */
     @Test
    public void test01(){
         driver.get("https://the-internet.herokuapp.com/download");

         //download the file
         driver.findElement(By.xpath("//*[text()='text.txt']")).click();

         String filePath = "/Users/hueseyin.kocal/Downloads";  //===>text.txt yi alinca olmuyor
         System.out.println(filePath);

         System.out.println(Files.exists(Paths.get(filePath)));
         Assert.assertTrue(Files.exists(Paths.get(filePath)));


     }

}
