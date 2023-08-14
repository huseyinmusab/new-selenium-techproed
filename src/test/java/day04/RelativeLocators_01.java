package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class RelativeLocators_01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
//       ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--remote-allow-origins=*");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        WebElement NYCWE =driver.findElement(By.id("pid3_thumb"));
        WebElement ByAreaWE =driver.findElement(By.id("pid8_thumb"));
        WebElement BerlinWE = driver.findElement(RelativeLocator.with(By.tagName("img")).below(NYCWE).toLeftOf(ByAreaWE) );
        //OR
        //WebElement BerlinWE = driver.findElement(RelativeLocator.with(By.className("ui-li-thumb")).below(NYCWE).toLeftOf(ByAreaWE) );

        BerlinWE.click();
    }

}
