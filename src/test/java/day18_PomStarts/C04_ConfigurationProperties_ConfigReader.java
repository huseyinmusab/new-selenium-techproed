package day18_PomStarts;

import org.junit.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_ConfigurationProperties_ConfigReader {

    @Test
    public void test01(){
        //go to amazon and facebook
        //Driver.getDriver().get("amazonUrl"); ===> boyle sayfayi acmaz , ConfigReader classa ihtiyacimiz var

        String urlAmazon = ConfigReader.getProperty("amazonUrl");
        String urlFacebook = ConfigReader.getProperty("facebookUrl");

        Driver.getDriver().get(urlAmazon);
        Driver.getDriver().get(urlFacebook);

        Driver.closeDriver();

    }


}
