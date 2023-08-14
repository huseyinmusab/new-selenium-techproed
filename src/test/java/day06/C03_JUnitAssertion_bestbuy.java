package day06;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_JUnitAssertion_bestbuy {
    static WebDriver driver;
    //@BeforeClass @AfterClass annotationlar icin methodlar static olmali
    @BeforeClass
    public static void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void assertTheUrl() throws InterruptedException {
        String expectedUrl ="https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        Thread.sleep(2000);

    }

    @Test
    public void assertLinksNameWithArray() throws InterruptedException {
        //check links name
        String arr[] = {"English","Français","Español"};
        List<WebElement>links = driver.findElements(By.cssSelector("ul li"));
        for (int i = 0; i < links.size() ; i++) {
            System.out.println(i+":"+ links.get(i).getText());
            Assert.assertEquals(links.get(i).getText(),arr[i]);
            Thread.sleep(2000);
        }
        //check active links one by one      ======>>>>>   WORK FOR IT!!!!!!!
    }

    @Test
    public void assertTheLogo() throws InterruptedException {
        WebElement logo= driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
        Thread.sleep(2000);
    }


}
