package day09;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C04_WindowHandles {
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
        driver.get("https://the-internet.herokuapp.com/windows");
        //assert the text
        WebElement text= driver.findElement(By.xpath("//div//h3"));
        Assert.assertTrue(text.getText().contains("Opening a new window"));

        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        //click
        driver.findElement(By.cssSelector("a[href^='/windows']")).click(); //STARTSWITH LOCATOR FOR HREF LINKS!!!

        //***********IMPORTANT***********//
        List<String>windowList= new ArrayList<String>(driver.getWindowHandles());//put the window handles as a string to a list
        driver.switchTo().window(windowList.get(1));
        //why 1 ,not 0, it is the second tab,second window
        //assert the "New Window" text
        WebElement newWindowText= driver.findElement(By.xpath("//h3"));
        System.out.println(newWindowText.getText());
        Assert.assertEquals(newWindowText.getText(),"New Window");


//eksik var ama bu uzun yol, ustteki kisa yol
//        Set<String>windowHandlesSeti = driver.getWindowHandles();
//        System.out.println(windowHandlesSeti);
//        String ikiciSayfaWndowHandleDegeri="";
//
//        for(String each:windowHandlesSeti){
//            if (!each.equals(ilkSayfaWindowHandleDegeri)){
//                ikiciSayfaWndowHandleDegeri=each;
//            }
//        }


        //
    }

    }
