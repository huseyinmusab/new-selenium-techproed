package day08;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04IFrame {
    /*
Handle Iframe
● Bir sayfada iframe varsa, Selenium bir iframe içindeki elementleri doğrudan göremez
● switchTo( ) mettod’u ile iframe’e gecmenin 3 yolu vardir;
 1 ) index ile :
driver.switchTo( ).frame(index of the iframe);//index 0’dan baslar

2 ) id veya name value ile
driver.switchTo( ).frame("id of the iframe");

3 ) WebElement ile
driver.switchTo( ).frame(WebElement of the iframe);
========================================================================================
Iframe’den cikmak icin 2 komut vardir:
driver.switchTo( ).parentFrame( ); 1 ust seviyedeki frame’e cikartir
driver.switchTo( ).defaultContent( ); En ustteki frame’e cikmak icin kullanilir
Birden fazla iframe varsa gecislerde dikkatli olmak lazim. Gecisler her zaman basit olamayabilir
https://html.com/tags/iframe/

 */
    WebDriver driver;
    @Before
    public void setUp(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
     //   driver.close();
    }

    @Test
    public void iFrameTest() throws InterruptedException {
        driver.get("https://html.com/tags/iframe");

        //SWITCHING THE YOUTUBE FRAME AND CLICK
        WebElement frame = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        System.out.println(frame);
        driver.switchTo().frame(frame);
        WebElement playButton = driver.findElement(By.xpath("//button[@aria-label=\"Play\"]"));
        playButton.click();

    }

    @Test
    public void iframeList() throws InterruptedException {
        driver.get("https://html.com/tags/iframe");

        //put all frames in an Array list

        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("*//iframe")));
        System.out.println(iframeList.size());
        driver.switchTo().frame(iframeList.get(0));
        Thread.sleep(2000);
        WebElement playButton = driver.findElement(By.xpath("//button[@aria-label=\"Play\"]"));
        playButton.click();

    }


}
