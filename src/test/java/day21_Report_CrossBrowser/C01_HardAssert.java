package day21_Report_CrossBrowser;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C01_HardAssert extends TestBaseCross {

    @Test
    public void test01(){

        driver.get("https://www.amazon.com");
        //assert the title
        Assert.assertTrue(driver.getTitle().contains("Amazon"),"does not include the given word");

        //search box is accesible
        WebElement searchbox= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchbox.isEnabled(),"WE is not reachable");
        ReusableMethods.waitFor(3);

        //type somth
        searchbox.sendKeys("Nutella", Keys.ENTER);
        ReusableMethods.waitFor(3);

        //test the search
        WebElement result=driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        Assert.assertTrue(result.isDisplayed(),"result is not able to be seen");

        //test the text in search result
        Assert.assertTrue(result.getText().contains("Nutella"),"does NOT include Nutella");
    }


}
