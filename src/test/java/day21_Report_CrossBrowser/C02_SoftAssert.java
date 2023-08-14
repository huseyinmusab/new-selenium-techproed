package day21_Report_CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseCross;

public class C02_SoftAssert extends TestBaseCross {

    @Test
    public void testSoft(){


        SoftAssert softAssert=new SoftAssert();
        driver.get("https://www.amazon.com");
        //assert the title
        softAssert.assertTrue(driver.getTitle().contains("AmazonXX"),"does NOT include the given word");

        //search box is accesible
        WebElement searchbox= driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(searchbox.isEnabled(),"WE is not reachable");

        //type somth
        searchbox.sendKeys("NutellaXX", Keys.ENTER);

        //test the search
        WebElement result=driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        softAssert.assertTrue(result.isDisplayed(),"result is not able to be seen");

        //test the text in search result
        softAssert.assertTrue(result.getText().contains("NutellaXXX"),"does NOT include Nutella");
        //softAssert.assertAll();

        //



    }


}
