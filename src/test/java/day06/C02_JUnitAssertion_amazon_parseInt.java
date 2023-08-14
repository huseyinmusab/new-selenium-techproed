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

public class C02_JUnitAssertion_amazon_parseInt {
    static WebDriver driver;
    //@BeforeClass @AfterClass annotationlar icin methodlar static olmali
    @BeforeClass
    public static void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void method1() throws InterruptedException {
        String expectedUrl ="amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        Thread.sleep(2000);
    }

    @Test
    public void method2() throws InterruptedException {
        String expectedUrl ="facebook";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertFalse(actualUrl.contains(expectedUrl));
        Thread.sleep(2000);
    }

    @Test
    public void method3() throws InterruptedException {
        //Assert the shoppinng box is empty
        WebElement box = driver.findElement(By.cssSelector("#nav-cart #nav-cart-count"));//PERFECT
        //System.out.println(box.getText());

        int actualNumberInBasket =Integer.parseInt(box.getText());
        System.out.println(actualNumberInBasket);//0

        int expectedNumberInBasket=0;
        System.out.println(expectedNumberInBasket);//0

        Assert.assertEquals(actualNumberInBasket,expectedNumberInBasket);
        Thread.sleep(2000);
    }

    @Test
    public void method4() throws InterruptedException {
        //Assert the amazon logo
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));//PERFECT
        Assert.assertTrue(logo.isDisplayed());
        Thread.sleep(2000);

    }

    @Test
    public void method5() throws InterruptedException {
        //Assert the textbox is enabled
        WebElement amazonTextBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(amazonTextBox.isEnabled());
        Thread.sleep(2000);

    }


}
