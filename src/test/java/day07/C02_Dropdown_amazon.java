package day07;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown_amazon {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void sizeOfDropDown() throws InterruptedException {
        WebElement dropdown= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(dropdown);

        List<WebElement>dropDownList=select.getOptions();
        System.out.println(dropDownList.size());//28

    }

    @Test
    public void selectBook() throws InterruptedException {
        WebElement dropdown= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(dropdown);
        //1)Books
        // select book with different ways
        //2)Books
        // select.selectByVisibleText("Books");
        //3)Books
        //select.selectByIndex(5);
        select.selectByValue("search-alias=stripbooks-intl-ship");

        System.out.println(select.getFirstSelectedOption().getText());//Books ===> it is for seeinfg the selected value in dropdown


        //write java to text box
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        Thread.sleep(3000);


        //Assert the result text
        WebElement result= driver.findElement(By.xpath("//h1//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(result.getText());
        Assert.assertTrue(result.getText().contains("Java"));
        Thread.sleep(3000);
        Assert.assertTrue(result.getText().contains("1-16 of over 20,000"));

//NO NEED BECAUSE HERE JAVA CAN SEE THAT THE WHOLE TEXT IS A STRING EVEN THERE IS SOME INTEGER IN IT
//        int resultIncludesNumber =Integer.parseInt(driver.findElement(By.xpath("//h1//div[@class='a-section a-spacing-small a-spacing-top-small']//span")).getText());
//        System.out.println(resultIncludesNumber);



    }
}
