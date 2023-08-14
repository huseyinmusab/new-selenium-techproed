package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {
    //mormalde burada gizli constructor var, her class da var ama asagidaki private
    //constructoru acarak gizli ve public olan constructoru deaktive ettik,
    //boylece obj kullanarak driver kullaniminin onune gectik
    //zaten static sayesinde Driver i getDriver() diyerek kullanabiliyoruz ,object
    //ile kullanmaya gerek kalmadi ===> look at this ==> C01_SingletonPattern
    private CrossDriver(){
    }


    static WebDriver driver;//class seviyesinde olusturduk ki rahatca erisebilelim

    public static WebDriver getDriver(String browser){
        //Eger browsera bir deger atanmamissa ConfigReader ile "properties" deki browser calissin, Bir nevi B plani,garanti olsun diye
        browser=browser==null ? ConfigReader.getProperty("browser"):browser;

        //(String browser)==>Testlerimizi xml file dan farkli browserlar ile calistirabilmek icin
        // (cunku artik properties dan browseri cagirmayacagim) getDriver() methoduna parametre atamamiz gerekir
        if (driver==null){
            switch (browser){
                //CrossBrowser icin bizim gonderdigimiz browser uzerinden calismasi icin
                //buraya parametre olarak girdigimiz degeri yazdik
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
Cross Browser Testing
1. CrossBrowsertestbiruygulamayifarklibrowserlar
ile test etmek demektir
2. Testleri sirali (sequential) veya parallel olarak yapabiliriz
3. Cv’niz acisindan Cross Browser test onemlidir cunku ileri seviyeyi gosterir
4. Cross Browser testi yapabilmek icin framework’de gerekli duzenlemeleri yapmaniz gerekir.
 (Bu her tester’in sahip olacagi bir ozellik degildir, dolayisiyla size 1 adim one cikarir)
5. Herbir adimi ezbere bilmek zorunda degiliz ama mantigi anlamak ve bunu sozlu olarak ifade edebilmek zorundayiz

***********************************************************************************************************************
Cross Browser Testing

1. Crossbrowser testi icin yeni bir driver class’i olusturacagiz : DriverCross
- getDriver methoduna parameter ekleyecegiz WebDriver getDriver(String browser)
- if blogundan once bir satir kod ekleyecegiz
browser = browser == null ? ConfigReader.getProperty("browser") : browser; - switch case’deki degeri degistirelim switch(browser)
Bu class’in gorevi xml dosyasindan parameter olarak gonderilen browser’i driver olarak tanimlamaktir.
Xml dosyasindan parametre gelmezse o zaman .properties dosyasinda tanimli browser’i kullanir

2. Crossbrowser testi icin yeni bir TestBase class’i olusturacagiz
- Basa gelen parametreyi kullanmak icin @Parameters(“browser”) ekleyecegiz
- setup methodune parametre gonderecegiz setUp(@Optional String browser) burada optional yazma sebebimiz
parameter gelmese de calismasini istememiz

3. Farkli browser’lar ile calistirmak istedigimiz class’lari bir package altina toplayalim
crossBrowser ve class’lari TestBaseCross clasina extends ile child olarak tanimlayalim

4. Xml dosyasi olusturalim ve cross browser icin <test> satirinin altina browser icin
parametre gonderelim
<parameter name="browser" value="firefox"></parameter>

5. Paralel calistirmak istersek paralel calistirma kodlarini eklememiz yeterli

     */


}
