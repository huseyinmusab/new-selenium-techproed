package day05;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_JunitCheckBox {
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
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        if (!checbox1.isSelected()){
            checbox1.click();
        }
        Thread.sleep(3000);


        if (!checbox2.isSelected()){
            checbox2.click();
        }

    }



}
