package day09;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WimdowHandle_amazon {
    /*
    Handle Windows
● Bazen bir butona tıkladığımızda, başka bir sekmede(tab) yeni bir pencere açılır.
● Birden fazla pencereyle calişirken driver’a pencereler arasında gecis yaptirmamiz gerekir.
● Pencereler arasında gecis yapmak icin window handle degerini kullaniriz.
●window handle : Selenium WebDriver’in, WebDriver objesi başlatıldığında her pencereye verdigi unique alfanumerik kimlik degeridir.
1 ) Icinde oldugumuz sayfanin windowhandle degerinialma
driver.getWindowHandle();
2 ) Pencereler arasında geçiş yapma(switch)
driver.switchTo().window(sayfa1HandleDegeri);
3 ) Yeni tab olusturup geçiş yapma(switch)
driver.switchTo().newWindow(WindowType.TAB);
4 ) Yeni window olusturup geçiş yapma(switch)
driver.switchTo().newWindow(WindowType.WINDOW);
5 ) Acik olan pencerelerin window handle degerlerini alma
driver.getWindowHandles();
Method’un sonundaki “s” den anlasilacagi uzere birdenfazla window handle return eder
Birden fazla window handle degeri oldugu icin collection return etmelidir, method Set return edecek sekilde yazilmistir.
Set’de tum window handle degerleri olacaktir. Biz icinde oldugumuz ilk sayfanin handle degerini kaydedersek, set’te olan 2 window handle degerinden, ilk sayfa handle degerine esit olmayan ikinci handle degeridir.

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
    public void iFrameTest() throws InterruptedException {
        driver.get("https://amazon.com");
        String amazonWindowHandle =driver.getWindowHandle();
        System.out.println("amazonWindowHandle: "+amazonWindowHandle);


        String expectedUrl ="amazon";
        String actualUrl=driver.getCurrentUrl();
        System.out.println("actualUrl: "+actualUrl);
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        Thread.sleep(3000);

        //open a new window and go to bestbuy page=======
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle =driver.getWindowHandle();
        System.out.println("bestBuyWindowHandle: "+bestBuyWindowHandle);

        //assert title of Best Buy
        String expectedTitle ="Best Buy";
        String bestBuyActualTitle  =driver.getTitle();
        System.out.println("bestBuyActualTitle: "+bestBuyActualTitle);
        Assert.assertTrue(bestBuyActualTitle.contains(expectedTitle));

        Thread.sleep(3000);

        //come back to Amazon page(first domain)
        driver.switchTo().window(amazonWindowHandle);
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java", Keys.ENTER);
        //assert
        WebElement result= driver.findElement(By.xpath("//h1//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(result.getText());
        Assert.assertTrue(result.getText().contains("java"));

        Thread.sleep(3000);

        //go to bestbuy again
        driver.switchTo().window(bestBuyWindowHandle);
        //ASSERT SOMETHING ON THIS PAGE
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.switchTo().window(bestBuyWindowHandle);
//        Thread.sleep(3000);

        //SEARCH IT!!!!!---FROM THE DOCUMENTATION
//        //Store the ID of the original window
//        String originalWindow = driver.getWindowHandle();
//
//        //Check we don't have other windows open already
//        assert driver.getWindowHandles().size() == 1;
//
//        //Click the link which opens in a new window
//        driver.findElement(By.linkText("new window")).click();
//
//        //Wait for the new window or tab
//        wait.until(numberOfWindowsToBe(2));
//
//        //Loop through until we find a new window handle
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!originalWindow.contentEquals(windowHandle)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
//
//        //Wait for the new tab to finish loading content
//        wait.until(titleIs("Selenium documentation"));




    }
}
