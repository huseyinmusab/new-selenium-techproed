package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBaseReport {

    protected static ExtentReports extentReports; //the first assignment to extenT report
    protected static ExtentTest extentTest; //this records when the tests fail or pass.also for Screenshots
    protected static ExtentHtmlReporter extentHtmlReporter; //set the HTML report

    //Before starting all test Process,(not only test methods)
    @BeforeTest(alwaysRun = true) //alwaysRun = true===> run always
    public void setUpTest(){
        extentReports= new ExtentReports(); //starting to report
        //Rapor olustuktan sonra raporunuz nereye eklensin istiyorsaniz buraya yaziyorsunuz
        String date = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());//ust uste rapor olusmasin diye
        String filePath= System.getProperty("user.dir") + "/target/Report/report"+date+".html";
        //olusturmak istedigimiz raporu html formatinda baslatiyoruz,filePath ile dosya yolunu belirliyoruz
        extentHtmlReporter =new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);

        //you can add the wished infos to here such as:
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser",ConfigReader.getProperty("browser"));//whatever is in congig.properties
        extentReports.setSystemInfo("Test Automation Engineer","Huseyin");
        extentHtmlReporter.config().setDocumentTitle("Report");
        extentHtmlReporter.config().setReportName("TestNG Reports");
    }

    //Her test methodundan sonra eger testte hata varsa ,ekran goruntusu alip rapora ekliyor
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.FAILURE){//eger test fail ise
            String screenshotLocation =ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        }else if(result.getStatus()==ITestResult.SKIP) { //eger test calistirilmadan gecilmez ise
            extentTest.skip("Test Case is skipped:" + result.getName()); //ignore olanlar
        }
        //Driver.closeDriver();
    }

    //For finishing the reporting
    @AfterTest(alwaysRun = true)
    public void tearDownTest(){
        extentReports.flush();
    }

////   ACIKLAMA:

/*

TESTNG rapor hazırlamaz. Eğer testimiz ile ilgili rapor hazırlamak istersek, farklı kütüphanelerden yardım almamız gerekir.
Pom.xml dosyamiza aventstack dependency’sini ekliyoruz.
<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
<dependency> <groupId>com.aventstack</groupId
<artifactId>extentreports</artifactId>
<version>4.0.9</version> </dependency>
*****************************************************************************************
                  Html Reports
  Extends Reports:
HTML raporlama aracıdır. Bize Html raporları verir. Test adımlarını
kaydetmemize yardımcı olur. Ayrıca ekran görüntüleri ekleyebiliriz. 3 tane obje olusturup kullaniriz:
1. ExtentReports extendReports;Raporlamayıbaşlatmakiçin ExtentReports'a ihtiyacımız var.
flush() metodunu için ExtentReports kullanıyoruz.

2. ExtentHtmlReporter extentHtmlReporter; Bu, özel raporlara ve raporların yapılandırmasına sahip olmamıza yardımcı olur,
html raporlarını oluşturur. Bunu raporun oluşturulacağı yolu ayarlamak için de kullanıyoruz.

3.ExtentTest extentTest; Bilgi eklemek için. Test adımlarını eklemek için (açıklama). Günlükleri(logs) ekliyoruz.
extentTest.info ("URL'yi Açma"); bilgi sadece adım eklemek içindir

Testimize rapor olusturma adimlari
1-Test class’ini extends ile TestBaseRapor Class’ina child yapalim
2-extentTest=extentReports.createTest(“Test ismi”, “Tanim”); rapor olusturalim
3-Gerekli/istedigimiz satirlara extentTest.info(“Aciklama”) ekleyelim
4-Assert olan satirda aciklamayi extentTest.pass ile yapabiliriz

Html Reports
Testimiz bittikten sonra olusturulan raporu “open in browser” ile acabiliriz.
Eger test basarisiz ise Screenshots klasorunden resmine de ulasabiliriz

 */



}
