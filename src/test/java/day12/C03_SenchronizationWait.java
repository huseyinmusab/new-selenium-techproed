package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C03_SenchronizationWait extends TestBaseBeforeAfter {
    /*
    Synchronization - Selenium Waits
➢ Synchronization(Senkronizasyon), UI (kullanıcı arayüzü) otomasyon testi için çok çok önemlidir.
➢ Bir sayfanın uygulama sunucusu veya web sunucusu çok yavaşsa veya internet ağı çok yavaşsa, web sayfasındaki öğe (webelement) çok yavaş yüklenir.
➢ Bu durumda, komut dosyanız (test script) öğeyi bulmaya çalıştığında, öğeler yüklenmez.
➢ Bu yüzden test komut dosyası(test script) öğeyi bulamaz ve başarısız olur ve NoSuchElementExeption alırız.

Synchronization - Selenium Waits
➢ Driver ile cihaz veya internet arasinda yasanan senkronizasyon sorunlarini çözmek icin
sürücümüzü(driver) belli sartlar ile bekletmemiz(wait) gerekir.
1 ) Java tabanli wait
Thread.sleep : Javadan gelir ve kodlari yazilan sure kadar bekletir. Sure dolduktan sonra alt satirdan isleme devam eder
2 ) Selenium tabanli wait’ler
Implicitly Wait: Sayfadaki tüm öğeler için global birzaman aşımıdır(timeout).
Explicitly Wait: Çoğunlukla belirli öğeler için belirli bir koşul(expected condition) için kullanılır.


IMPLICITLY WAIT
Bir sayfanin yuklenmesi veya sayfadaki her bir öğenin locate edilebilmesi için driver’i bekletir.
Selenium tabanli wait’lerde verilen sure max. bekleme suresidir, islem daha once biterse surenin bitmesi beklenmez, kod calismaya devam eder.
Genellikle otomasyon frameworklerinde olasi senkronizasyon problemleri icin default olarak implicitly wait ile kullanilir.
Implicitly wait’i TestBase class’ımızda kullanıyoruz.
driver.manage().timeouts().implicitWait(Duration.ofsSeconds(10));
Bu kod, driver’in sayfadaki herhangi bir weblement için maximum 10 saniye beklemesini istediğimiz anlamına gelir.
Webelement 10 saniyeden kisa surede yüklenirse driver bulur ve devam eder. Örneğin, Webelement 3 saniye içinde yüklenirse, driver sadece 3 saniye bekleyecek ve bir sonraki satıra geçecektir.
Webelement 10 saniye içinde yüklenmezse, test case başarısız olur ve NoSuchElementExeption uyarisi verir


EXPLICIT WAIT
Beklenen bir durum(expected condition) olduğunda explicit wait kullanılır.
Implicitly wait ile cozulebilecek durumlar icin expilicitly wait kullanimina ihtiyac yoktur.
Nadiren karsimiza cikan ve daha fazla bekleme süresi gerektiren belirli öğeler(webelement) için explicitly wait kullanılır.
İlk olarak belirli miktarda bekleme süresi ile wait object create edilir.
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
Olusturdugumuz wait objesi sayesinde WebDriverWait class’indan until( ) method’u ile birlikte ExpectedConditions Class’ini kullanabiliriz. Ornegin WebElement’i locate etmek icin wait object’i kullanma
WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("...")));
bazi wait methodlari:
1.alertIsPresent( ) 2.elementSelectionStateToBe( ) 3.elementToBeClickable( ) 4.elementToBeSelected( ) 5.frameToBeAvaliableAndSwitchToIt( )
6.invisibilityOfTheElementLocated( ) 7.invisibilityOfElementWithText( ) 8.presenceOfAllElementsLocatedBy( ) 9.presenceOfElementLocated( )
10.textToBePresentInElement( ) 11.textToBePresentInElementLocated( )12.textToBePresentInElementValue( ) 13.titleIs( )14.titleContains( )
15.visibilityOf( ) 16.visibilityOfAllElements( ) 17.visibilityOfAllElementsLocatedBy( ) 18.visibilityOfElementLocated( )

     */

    @Test
    public void implicitWaitTest01() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //click remove
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));===>IN TestBase

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's gone!\"]")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[text()=\"It's gone!\"]")).getText());


        //click add
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's back!\"]")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[text()=\"It's back!\"]")).getText());


    }


    @Test
    public void explicitWaitTest02() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //click remove
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneWE.isDisplayed());


        //click add
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
        WebElement itsBckWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBckWE.isDisplayed());


    }


}
