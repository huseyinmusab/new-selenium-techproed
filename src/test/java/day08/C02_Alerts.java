package day08;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class C02_Alerts {

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
    public void dropdDownTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click(); //DIFFERENT TYPE OF XPATH, USE IT ONLY FOR TEXT
        //<button onclick="jsAlert()">Click for JS Alert</button>   ======>              //DIFFERENT TYPE OF XPATH, USE IT ONLY FOR TEXT
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement message =driver.findElement(By.xpath("//*[@id='result']"));
        String actualMessage=message.getText();
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage,expectedMessage);

    }


    //dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
    //click on the second alert

    @Test
    public void dissmissAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement secondButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        //click on the first alert
        secondButton.click();
        //        verify text "I am a JS Confirm"
        String alertText = driver.switchTo().alert().getText();
        assertEquals(alertText, "I am a JS Confirm");

        //click cancel
        driver.switchTo().alert().dismiss();

        //Verify "You clicked: Cancel"
        String result = driver.findElement(By.id("result")).getText();
         assertEquals(result, "You clicked: Cancel");

    }

    //  sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello Word”, click OK, and Verify “You entered: Hello Word”
    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // click on the third alert
        WebElement thirdAlert=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        thirdAlert.click();

        //verify text “I am a JS prompt”
        String alertText = driver.switchTo().alert().getText();
        org.testng.Assert.assertEquals(alertText, "I am a JS prompt");

        //type “Hello Word”
        driver.switchTo().alert().sendKeys("Hello Word");

        //click OK
        driver.switchTo().alert().accept();

        //Verify “You entered: Hello Word”
        String result = driver.findElement(By.id("result")).getText();
        assertEquals(result, "You entered: Hello Word");
    }



}
