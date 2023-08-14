package day18_PomStarts;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassAmazon {
    AmazonPage amazonPage = new AmazonPage();

    @Test
    public void test01(){
        Driver.getDriver().get("https://amazon.com");
        amazonPage.searchBox.sendKeys("Nutella", Keys.ENTER);
        Driver.closeDriver();
    }


}
