package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class Driver {

    //mormalde burada gizli constructor var, her class da var ama asagidaki private
    //constructoru acarak gizli ve public olan constructoru deaktive ettik,
    //boylece obj kullanarak driver kullaniminin onune gectik
    //zaten static sayesinde Driver i getDriver() diyerek kullanabiliyoruz ,object
    //ile kullanmaya gerek kalmadi ===> look at this ==> C01_SingletonPattern
    private Driver(){
    }


    static WebDriver driver;//class seviyesinde olusturduk ki rahatca erisebilelim

    public static WebDriver getDriver(){
        if (driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    driver =new ChromeDriver();
                    break;
                case "edge":
                    driver=new EdgeDriver();
                    break;
                case "firefox":
                    driver=new FirefoxDriver();
                    break;
                case "safari":
                    driver=new SafariDriver();
                    break;
                case "headless-chrome":
                    driver= new ChromeDriver(new ChromeOptions().addArguments("--headless=new"));//for headless chrome, it is new
                    break;
                default:
                    driver=new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){ //driver a deger atanmamissa
             driver.close();
             driver=null;//kapanmadan sonra sonraki acmalari garanti altina almak icin driver i tekrar null yaptik
        }
    }

    public static void quitDriver(){
        if (driver!=null){ //driver a deger atanmamissa
            driver.quit();
            driver=null;//kapanmadan sonra sonraki acmalari garanti altina almak icin driver i tekrar null yaptik
        }
    }


    /*
***********************************************************************************************************************************
//THIS IS HOW WE CREATED driver for the first time, before adding different browser types
        public static WebDriver getDriver(){
        if (driver==null){
            driver =new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
***********************************************************************************************************************************
Page Object Model - Basic Driver Class
Temel Hedefimiz: Test methodlarimizda kullanacagimiz WebDriver driver’i utilities altindaki Driver Class’inda
olusturmak ve testlerimizde bu class ismi uzerinden driver’a ulasip olusturma, kullanma ve kapatma islemlerini yapmak.
Su anki haliyle TestBase Class’imizla ayni olacak ama inheritance kullanmak yerine static method’lar ile driver’i kullanacagiz.
Driver class’ini daha sonra tum browser’lar ile calisacak hale getirecegiz
********************************************************************************************************************************************
* HER SEFERINDE YENI DRIVER OLUSTURMAK ISTEMIYORUZ CUNKU HER DEFASINDA YENI BIR PENCERE ACIYOR,EGER DRIVER A BIR DEGER
* ATANMAMISSA YANI driver==null ISE BIR KERE DRIVER I CALISTIR DIYEREK BIR KERE if ICINI CALISTIRACAK,VE DRIVER
* BIR KERE CALISTIGI ICIN VE DEGER ATANDIGI ICIN NULL OLMAYACAK VE DIREKT return EDECEK VE DIGER TESTLERIMIZ AYNI PENCERE(driver)
* UZERINDE CALISACAK

public class Driver{
private static Webdriver driver;
public static getDriver(){
   if(driver==null){
     WebDriverManager.chromeDriver.setUp();
   }
}
* Test Class(driver->Driver.getDriver( ) )
*
*********************************************************************************************************************************
Driver Class
* Singleton Pattern (Tekli Kullanim)
➢ Herhangi bir Java classindan obje kullanimini sinirlayabiliriz. Buna Singleton pattern(tekli
kullanim) denir.
➢ Singleton pattern, class’ı tek bir instance ile kısıtlayan bir software dizayn kalıbıdır.
➢ Proje genelinde farkli objeler olusturulmadan tek bir instance gereksinimimiz olduğunda Singleton class kullaniriz.
➢ Sadece bir obje oluşturmalı ve buna her ihtiyac duyduğumuzda kullanmamiz performans ve bellek kullanımı için de faydalıdır.

* Tum Browserlar icin Kullanim
➢ Driver Classımızı tüm tarayıcılar(browser) için geliştireceğiz.
➢ Driver objesi create etmeden önce farklı tarayıcı koşullarını kontrol etmek için switch statement kullanıyoruz.
➢ Driver Class’i singleton pattern’e uygun dizayn ederek tum projede farkli driver uretilmesinin onune geceriz
➢ Sonra TestBasede yaptigimiz gibi “wait” koyabiliriz.
➢ Ardından driver’i kapatmak icin method olusturuyoruz.
➢ Şu andan itibaren TestBase Classını degil Driver Classını kullanacagiz.

 */

}
