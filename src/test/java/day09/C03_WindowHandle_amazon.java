package day09;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WindowHandle_amazon {
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
        String amazonWindowHandle = driver.getWindowHandle();

        //assert the amazon title
        String actualTitle = driver.getTitle();
        System.out.println("AmazonTitle: "+actualTitle);
        Assert.assertTrue(actualTitle.contains("Amazon"));

        //open a new TAB and go to techproed
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        System.out.println("Techpro title :" +driver.getTitle());

        //assert title of techproed
        Assert.assertTrue(driver.getTitle().contains("TechPro"));

        //create a new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

        //go back to first window (Amazon)
        driver.switchTo().window(amazonWindowHandle);
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //close all opened drivers  TRY!!!!!!
//        System.out.println(driver.getWindowHandles());
//
//        System.out.println(driver.getWindowHandles().size());
//        driver.getWindowHandles()
//        //Loop through until we find a new window handle
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!originalWindow.contentEquals(windowHandle)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }



    }

}
