package day20;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;

public class C02_WindowHandlesReusable {

    @Test
    public void test01(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();
        ArrayList<String>windows=new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windows.get(1));

        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="New Window";
        Assert.assertEquals(expectedTitle,actualTitle);
        Driver.closeDriver();
    }

    @Test
    public void test02() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        ReusableMethods.waitFor(3);
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();
        ReusableMethods.switchToWindow("New Window");

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "New Window";
        Assert.assertEquals(expectedTitle, actualTitle);
        Driver.closeDriver();

    }

}
