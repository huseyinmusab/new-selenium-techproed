package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

public class C03_Fake_CreateFacebookAccount extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        driver.get("https://www.facebook.com");
        Faker faker=new Faker();
        //pass cookies
        driver.findElement(By.cssSelector("[title=\"Allow all cookies\"]")).click();

        //click create button
        driver.findElement(By.xpath("//a[text()=\"Create new account\"]")).click();

        //first name
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());
        //last name
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
        //last name
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(faker.internet().emailAddress());
        //last name
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(faker.internet().password(3,54));//dropdown
        //last name
        driver.findElement(By.cssSelector("[name=\"birthday_day\"]")).sendKeys(faker.number().digits(2));//dropdown
        //last name
        //driver.findElement(By.cssSelector("[name=\"birthday_month\"]")).sendKeys(faker.date().past()
        //TRY WITH DIFFERENT VARIATIONS!!


    }
}
