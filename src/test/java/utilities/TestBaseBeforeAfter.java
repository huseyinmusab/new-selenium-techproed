package utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeAfter {
    /*
●TestBase, testlerden önce ve sonra tekrar tekrarkullandığımız kodları içermektedir.
●İçerisindeki metodları kullanabilmemiz icin extends yapıyoruz. Bu sayede test class’ımızda sadece test case’ler bulunmaktadır.
● Utilities package’da TestBase’i oluşturuyoruz.
   ○ setUp method
   ○ reports (Raporlar)
   ○ tearDown method
●TestBase class’i abstract yapabiliriz (Olmasada olabilir) , extends yaparak kullanabiliriz. Ve bu class’da object create edemeyiz.
● olusturdugumuz driver’in farkli package’lardan kullanabilmek icin PROTECTED yapariz
     */

    //1)to avoid creating object from this class, we can do this class"Abstract Class" (not must, can create object too)
    //2)to reach the driver from extended class, we need a "protected" access, (can be public too)
    // so, we can just type "extends" and reach to this testbase from other classes
    protected WebDriver driver;
    protected String date;
    protected Actions actions;//we dont have to create an object every single time by using this

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);

        //for date
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YY-MM-dd-HH:mm:ss");//CREATING THE FORMAT FOR DATE
        date = dateTime.format(dateTimeFormatter);
        System.out.println(date);
    }

    @After
    public void tearDown(){
      //  driver.close();
    }

}
