package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;


    static {//herseyden once calissin diye static block olusturulur
        String filePath="configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(filePath);//ilk once bunu yaz, hata verir, sonuna nokta koyup try-catch blogunun icine koy
            properties = new Properties();//properties objeme deger atiyorum
            properties.load(fis);//IO exception verir ilk kerede,onceki exceptionu kapatir,kapsar(IO Exception en buyuktur) ===> fis in okudugu bilgileri properties objesine yukler
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}




/*
    *********************************************************************************************************************************

Properties File
● configuration.properties Test datalarini tuttugumuz .properties uzantılı bir dosyadır.
● Bu dosya , projeyi temiz ve dinamik hale getirir. Test datalarini dinamik hale getirebiliriz.
Örneğin :
driver.get(“https://www.google.com”)
yazmak yerine configuration dosyamiza url’i tanimlayip test classinda sadece
driver.get(url) kullaniriz.
● Temel olarak key(anahtar) ve value(değer) çiftlerini kullanırız ve ihtiyaç duyduğumuzda key kullanarak value cagirirız(url,credentials,browser,environments,...)
○ url=https://www.fhctrip.com/
○ browser=chrome
○ username=manager
○ password=Man1ager2!
○ name=Ali

 ➢ configuration.properties file Olusturmak icin project’imize sag click yapin New =>File => isim : configuration.properties
➢ Dosya olustururken bizim icin onemli olan ismi degil, uzantisidir (.properties)
➢ Bu uzanti sayesinde Properties Class’ini kullanabilir, olusturacagimiz obje yardimiyla configuration.properties dosyasindaki key- value ikililerine ulasabiliriz
➢ properties file test datalari saklar.
➢ Bu dosyayı kullanmanın amacı, kodu sabit(hard coded) değil, dinamik yapmaktır. Bu dosya sayesinde tum kullanicilar verilere kolayca ulasabilir ve update edebilir.

* ConfigurationReader Class
ConfigurationReader class test method’larimiz ile Configuration.properties arasinda iletisimi saglar.
Bu class’da test class’larindan kolayca ulasmak icin static method bulunur.
Method static oldugundan method icerisinden cagiracagimiz variable da static olmalidir.
Kullanacagimiz static variable’a ilk degeri atamak icin(instantiate) de static block kullaniriz.

public static String getProperty(String key){
    return properties.getProperty(key)
 }
1 ) Test method’undan “amazon_url” key’e ait value’yu kullanmak istedigimizde
2 ) ConfigReader Class’indan getProperty( )method’unu kullaniriz.
3 ) getProperty( ) method’u configuration.properties dosyasina gidip istedigimiz key’e ait value’yu bize dondurur.
Not: Properties dosyasında olmayan bir anahtar(key) alirsak, null degeri döndürür .
Örn: getProperty (“country”) dosyada ülke yok, bu nedenle null değerini döndürür

     */

