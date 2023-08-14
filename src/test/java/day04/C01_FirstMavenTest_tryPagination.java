package day04;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class C01_FirstMavenTest_tryPagination {

    public static void main(String[] args) throws InterruptedException {
        //WebDriverManager.chromedriver().setup(); ===> when i add boni garcia dependency , it fails, so i deleted it
        WebDriver driver =new ChromeDriver();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--remote-allow-origins=*");
//        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);
        Thread.sleep(2000);



        //paginations ADD THIS LATER DO NOT FORGET!!!!!
//        List<WebElement> elements = driver.findElements(By.cssSelector(".s-pagination-strip > a"));
//                for (int i = 0; i < elements.size(); i++) {
//            String title = elements.get(i).getAttribute("aria-disabled");
//            if (title.equals("true")) {
//                elements.get(i).click();
//                break;
//            }
//        }


        int count =0;
        int numberOfNoSamsungName =0;
        List<WebElement> productsExplanations =  driver.findElements(By.cssSelector(".a-section .sg-row > div h2 span"));
        for (int i = 0; i < productsExplanations.size(); i++) {
            //System.out.println(i +": "+productsExplanations.get(i).getText());
            if (productsExplanations.get(i).getText().contains("SAMSUNG")||
                (productsExplanations.get(i).getText().contains("Samsung"))||
                (productsExplanations.get(i).getText().contains("samsung"))){
                count++;

            }else {
                numberOfNoSamsungName++;
                System.out.println(i +": "+productsExplanations.get(i).getText());
            }
        }
        //do the assertion tha you want
        //assertEquals(productsExplanations.size(),count);
        System.out.println(productsExplanations.size());
        System.out.println(count);
        System.out.println(numberOfNoSamsungName);

        //ASSERT THE RESULT TEXT
        WebElement resulText = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(resulText.getText());
        Assert.assertTrue(resulText.getText().contains("results"));


    }
}
