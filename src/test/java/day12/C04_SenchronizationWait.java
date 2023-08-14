package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C04_SenchronizationWait extends TestBaseBeforeAfter {
    /*
    1. Bir class olusturun : EnableTest
2. Bir metod olusturun : isEnabled()
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin. 4. Textbox’in etkin olmadigini(enabled) dogrulayın
5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
7. Textbox’in etkin oldugunu(enabled) dogrulayın.
     */
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls ");
        WebElement textBox= driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());

        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(9));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
        Assert.assertTrue(textBox.isEnabled());

    }


}
