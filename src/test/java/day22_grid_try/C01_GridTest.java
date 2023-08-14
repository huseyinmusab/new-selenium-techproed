package day22_grid_try;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class C01_GridTest {

     WebDriver driver;
    @Test
    public void test01() throws MalformedURLException {


        String hubUrl ="http://192.168.0.120:4444";
        driver = new RemoteWebDriver(new URL(hubUrl),new SafariOptions());
        //driver = new RemoteWebDriver(new URL(hubUrl),new FirefoxOptions());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperty("bcrlUrl"));

        String actualTitle= driver.getTitle();
        String expectedTitle ="Blue Rental Cars | Cheap, Hygienic, VIP Car Hire";
        Assert.assertEquals(actualTitle,expectedTitle);

        driver.quit();



/*
Selenium Grid testlerimizi paralel olarak farklı ortamlarda, farklı tarayıcılarda ve farklı sayılarda koşmamıza
imkan tanıyan bir sunucudur.
Test komutları bir sunucu merkezi(hub) tarafından alınır ve JSON biçimine çevrilir.
Bu JSON biçimindeki test komutları birden çok kayıtlı Grid Nod’una yönlendirilir ve buralarda çalıştırılır.

1. Adım: SeleniumServer adında Masaüstünde bir klasör oluşturuyoruz.
2. Adım: Şu adrese gidiyoruz:
3. Adım: Selenium Server son versiyonunu SeleniumServer klasörüne indiyoruz.
4. Adım: Şu adrese gidiyoruz: https://chromedriver.chromium.org/downloads
5. Adım: ChromeDriver son versiyonunu SeleniumServer klasörüne indiriyoruz.
6. Adım: Şu adrese gidiyoruz: https://github.com/mozilla/geckodriver/releases
7. Adım: GeckoDriver son versiyonunu SeleniumServer klasörüne indiyoruz.
8. Adım: Terminali açıp SeleniumServer klasörü konumuna gidiyoruz. cd C:\Users\TechPro\Desktop\SeleniumServer
9. Adım: Terminal’de şu komutu çalıştırıyoruz:
java -jar selenium-server-4.6.0.jar standalone
10. Adım: Şu adrese gidiyoruz:
Grid’in hazır va çalışır olup olmadığını kontrol ediyoruz.

WebDriver driver;                      Node Adresi
driver = new RemoteWebDriver(new URL("http://192.168.1.156:4444"), new EdgeOptions());
                                                                   Tarayıcı Tipi
 */




//ESKI
//        //1.Create Desired Capabilities Object
//        DesiredCapabilities cap = new DesiredCapabilities();
//
//        //2.Use cap to assign browser name and the operating system
//        cap.setBrowserName("safari");
//        cap.setPlatform(Platform.MAC);
//        //cap.setPlatform(Platform.MAC);
//        //cap.setPlatform(Platform.ANY);
//
//        //3.Merge the chrome with Desired Capabilities
//        SafariOptions options = new SafariOptions();
//        options.merge(cap);
//
//        //4.Create driver object using RemoteWebDriver==> cover all of them
//        //Hub URL= port url / wd / hub (Going to the application) wd=webdriver
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//
//        //5.CONFIGURATIONS ARE DONE ,WE CAN WRITE OUR JAVA CODES
//        driver.get(ConfigReader.getProperty("application_url"));
    }

}
