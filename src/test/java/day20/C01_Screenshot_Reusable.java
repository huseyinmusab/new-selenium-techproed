package day20;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_Screenshot_Reusable {
    @Test
    public void test01_allPageScreenShot() throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("hepsiBuradaUrl"));
        ReusableMethods.getScreenshot("hepsiburada");
        Driver.closeDriver();
    }

    @Test
    public void test02_WebElementScreenShot() throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.searchBox.sendKeys("Nutellla", Keys.ENTER);
        ReusableMethods.getScreenshotWE("SearchBoxResult", amazonPage.resultWe);
        Driver.closeDriver();
    }
}
