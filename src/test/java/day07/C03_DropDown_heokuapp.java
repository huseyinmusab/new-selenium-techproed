package day07;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown_heokuapp {

    //Go to https://the-internet.herokuapp.com/dropdown
//1.Create method selectByIndexTest and Select and Print Option 1 using index
//2.Create method selectByValueTest Select and Print Option 2 by value
//3.Create method selectByVisibleTextTest Select and Print Option 1 value by visible text
//4.Create method printAllTest Print all dropdown value
//5.Create method printFirstSelectedOptionTest Print first selected option
//6.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.

    WebDriver driver;
    @Before
    public void setUp(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @After
    public void tearDown(){
        driver.close();
    }



    @Test
    public void dropdDownTest() throws InterruptedException {
        //Locating the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));

        //Step 2 : Use select Class to control the dropdown object
        Select select = new Select(dropdownElement);

        //Step 3: I can now select any option by 3 different ways
       //selectByValue, selectByIndex, selectByVisibleText()

        //1.Create method selectByIndexTest and Select and Print Option 1 using index
        Thread.sleep(5000);
        select.selectByIndex(1);
        Thread.sleep(5000);




    }
    @Test
    public  void selectByValueTest() throws InterruptedException {
        //2.Create method selectByValueTest Select and Print Option 2 by value
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        Thread.sleep(5000);
        select.selectByValue("2");
        Thread.sleep(5000);
    }




    @Test
    public void selectByVisibleText() throws InterruptedException {
        //3.Create method selectByVisibleTextTest Select and Print Option 1 value by visible text
        WebElement dropdownElement= driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        Thread.sleep(5000);
        select.selectByVisibleText("Option 1");
        Thread.sleep(5000);
    }




    @Test
    public void printAll(){
        //4.Create method printAllTest Print all dropdown value
        WebElement dropdownElement= driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);

         List<WebElement> allOptions=select.getOptions();
        //getOptions() returns all options as List<WebElement>
        for (WebElement each: allOptions){
            System.out.println(each.getText());
        }
    }



    @Test
    public void printFirstSelectedOptionTest(){
        //5.Create method printFirstSelectedOptionTest Print first selected option
        WebElement dropdownElement= driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        String selectedOption=select.getFirstSelectedOption().getText();
        //getFirstSelectedOption() returns selected option as WebElement,default one
        System.out.println(selectedOption);


    }



        @Test
        public void dropdownSizeTest(){
            //6.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.
            WebElement dropdownElement= driver.findElement(By.id("dropdown"));
            Select select = new Select(dropdownElement);
            int numberOfOptions=select.getOptions().size();
            Assert.assertEquals("Expected Is Not Equal Actual",4,numberOfOptions);

        }






}
