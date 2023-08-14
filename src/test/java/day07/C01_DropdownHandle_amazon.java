package day07;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_DropdownHandle_amazon {


    WebDriver driver;
    @Before
    public void setUp(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void displayTheDropDownTextsAndAsserNumberOfDropDown() throws InterruptedException {
        List<WebElement>dropdowns =driver.findElements(By.xpath("//option"));
        for (int i = 0; i <dropdowns.size() ; i++) {
            System.out.println(i+" :"+ dropdowns.get(i).getText());
        }
        Assert.assertEquals(dropdowns.size(),28);

//OR FOREACH LOOP
//        for (WebElement w:dropdowns) {
//            System.out.println(w.getText());
//        }

    }

    @Test
    public void selectBookFromDropDown() throws InterruptedException {
        List<WebElement>dropdowns =driver.findElements(By.xpath("//option"));
        for (int i = 0; i <dropdowns.size() ; i++) {
            System.out.println(i+" :"+ dropdowns.get(i).getText());
        }
        Assert.assertEquals(dropdowns.size(),28);


    }


}
