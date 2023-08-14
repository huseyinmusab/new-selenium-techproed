package day08;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    /*
    Handle Allerts
Alert kullanıcıya bir tür bilgi vermek veya belirli bir işlemi gerçekleştirme izni istemek için ekran
bildirimi görüntüleyen küçük bir mesaj kutusudur. Uyarı amacıyla da kullanılabilir.
HTML Alerts:
Bir alert ciktiginda sag click ile inspect yapabiliyorsak html alert’dir ve extra bir isleme gerek yoktur.
Js Alerts:
Js alerts inspect yapilamaz, ekstra isleme ihtiyac vardir.
1.Simple Alert : Bu basit alert ekranda bazı bilgiler veya uyarılar görüntüler. Ok denilerek kapatilir
2.Confirmation Alert : Bu onay uyarısı bir tür işlem yapma izni ister. Alert onaylaniyorsa OK, onaylanmiyorsa Cancel butonuna basilir.
3.Prompt Alert : Bu Prompt Uyarısı kullanıcıdan bazı girdilerin girilmesini ister ve selenium webdriver metni sendkeys ("input....") kullanarak girebilir.
Alert Nedir?
 https://the-internet.herokuapp.com/javascript_alerts
 ===================================================================
 Handle Allert Methods
● accept( ) => Bir uyarıda(alert) OK'ı tıklamakla aynı.driver.switchTo( ).alert( ).accept( );

● dismiss() => Bir uyarıda(alert) Cancel'ı tıklamakla aynı. driver.switchTo( ).alert( ).dismiss( );

● getText() => Uyarıdaki(alert) mesajı almak için. driver.switchTo( ).alert( ).getText( );

● sendKeys(“Text”) => Uyarı(alert) text kutusuna text göndermek için driver.switchTo( ).alert( ) .sendKeys("Text");


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
       driver.close();
    }



    @Test
    public void dropdDownTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click(); //DIFFERENT TYPE OF XPATH, USE IT ONLY FOR TEXT
        //<button onclick="jsAlert()">Click for JS Alert</button>   ======>              //DIFFERENT TYPE OF XPATH, USE IT ONLY FOR TEXT
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

    }

}
