package day19;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SingletonPattern {
    @Test
    public void test01(){
//        Driver obj = new Driver();
//        obj.getDriver().get(ConfigReader.getProperty("amazonUrl"));
//SingletonPattern tekli kullanim demektir,Bir class in farkli classlardan obje
//olusturarak kullanimini engeller

/*
            Singleton pattern : bir class'dan obje olusturulmasini engellemek icin kullanilan bir yontemdir
            POM'de WebDriver olarak Driver class'indaki
            getDriver()'nun kullanilmasini istiyoruz

            Driver class'inin farkli kullanilmasini engellemek icin
            POM tasarlayanlar singleton pattern kullanmistir

            singleton pattern,
            parametresiz constructor'i gorunur yapip
            access modifier'ini private yaparak
            istenen class'dan obje olusturulmasini engeller.
*/

        // amazon'a gidin

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // driver objemizi private yapip direk kullanimi engelledik
        // Driver.driver.get(ConfigReader.getProperty("amazonUrl"));

        /*
        Driver driver = new Driver();
        driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        singleton pattern kullanarak
        bu sekilde erisim durduruldu
         */

    }
}
