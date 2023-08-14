package day18_PomStarts;

public class TestNG_POM {
    /*
******* Java’dan Hatirlamamiz Gerekenler *******
 Baska bir Class’dan variable veya method kullanmak istersek 3 yontem kullanabiliriz:
A- inheritance (Miras)
* kullandigimiz Class’i extends anahtar kelimesi (key word) ile istedigimiz Class’in child’i yapabiliriz.
Bu durumda object olusturmaya gerek kalmadan Parent class’a ulasabilir ve oradaki variable ve methodlari kullanabiliriz. (Test Base gibi)

* Inheritance ile variable ve method kullanirken static keyword’e dikkat etmek gerekir.
Static olarak tanimlanmis bir variable veya method static olmayan method icinden kullanilamaz.

* B- Object olusturarak
Bir class’dan obje olusturarak ISTEDIGIMIZ class’a ulasabilir ve o class’daki variable ve methodlari object’imizi araciligiyla kullanabiliriz
ornek: Servis class’indan Okul class’ina ulasmak istiyorsak
- Okul class’indan bir obje olustururuz
- obje uzerinden variable veya method’lara ulasabiliriz

* C- Static Class Uyeleri :
Eger kullanacagimiz variable veya method static ise object olusturmadan direkt class ismi ile variable veya method’a ulasabiliriz.
//public class Okul{
static int ogrenciSayisi=120;
}
//public class Servis{
 System.out.println(Okul.ogrenciSayisi)
 }
 * ***********************************************---  POM  ---********************************************************
➢ Bir sirkette test framework’u olusturdugumuzda kullanici adi, sifresi, gidilecek web adresi gibi test datalari tum testler icin gecerlidir.
  Ayrica surekli kullanmamiz gereken variable ve method’lar olacaktir.

➢ Daha kullanislibirFramework olusturmak icin temel hedefimiz, tekrar tekrar yaptigimiz islemleri
ve testlerimizde kullandigimiz Test Data’larini onceden hazirladigimiz dosyalarda tutmaktir.

➢ Bu sekilde testlerimizde ihtiyac duydugumuzda bu verilere kolayca ulasabilir veya
test datalari ile ilgili bir degisiklik yapmamiz gerektiginde sadece kaynak dosyadan bir degeri degistirerek
tum test case’leri guncellemis oluruz.

* Framework design
➢ POM çok popüler bir Framework Design Pattern ‘dir. ➢ Test suitlerimizde çok fazla testimiz olduğunda, test
caseleri ve kodları korumak daha karmaşık hale gelir. Bu nedenle,
sürdürülebilir(maintainable),
yeniden kullanılabilir(reusable),
daha hızlı(faster),
anlaşılabilir( understandable)
daha iyi bir framework dizaynina ihtiyacımız vardir.
➢ Page object model ile, sayfaya özgü elementleri veya methodlari page class icinde tutar, ve bunları gerçek test classlarından uzak tutarız.
➢ POM ile ihtiyacimiz olan class uyelerini sadece bir kez create edip birçok kez kullanabiliriz.

➢ Framework un verimliliğini artırmak için core Java ve Selenium konseptini kullanarak temel olarak page classları ve test classları oluşturacağız.
➢ Bütün şirketler page object model dizaynini kullanmayabilir, ancak herkes bunu bilir ve daha da popüler hale gelmektedir.
➢ Daha iyi bir tasarım, testin yürütme süresini daha hızlı hale getirir.
➢ Bir uygulamanın(application) işlevselliği değiştiğinde, kodu düzeltmek için framework kontrol edilmesini ve gerekli duzeltmelerin yapilmasini kolaylastirir.
➢ Page Object Design daha bağımsız test senaryoları oluşturmamıza yardımcı olur, böylece test komut dosyalarında(script) hata ayıklamak daha kolay olacaktır.


Page Object Model temelde 3 package icerir
➢ Tests : Sadece testleri execute etmek icin gerekli adimlari yazacagimiz class’lar icerir. Hicbir data girisi yapmayacagiz
➢ Pages : Test yapacagimiz sayfalardaki Web Elementlerini locate etmek ve temel methodlari olusturmak icin kullanilir.
➢ Utilities : Driver,TestBase ve ConfigurationReader class’larini icerir

***********************************************************************************************************************************
Page Object Model - Basic Driver Class
Temel Hedefimiz: Test methodlarimizda kullanacagimiz WebDriver driver’i utilities altindaki Driver Class’inda
olusturmak ve testlerimizde bu class ismi uzerinden driver’a ulasip olusturma, kullanma ve kapatma islemlerini yapmak.
Su anki haliyle TestBase Class’imizla ayni olacak ama inheritance kullanmak yerine static method’lar ile driver’i kullanacagiz.
Driver class’ini daha sonra tum browser’lar ile calisacak hale getirecegiz
********************************************************************************************************************************************
public class Driver{
private static Webdriver driver;
public static getDriver(){
   if(driver==null){
     WebDriverManager.chromeDriver.setUp();
   }
}
* Test Class(driver->Driver.getDriver( ) )

*********************************************************************************************************************************
* Page Factory
Bir page class’i olusturdugumuzda ilk isimiz bir constructor olusturup, pageFactory class’indan initElements( ) method’unu kullanmak olmalidir.
1. PageFactory, page object dizayni icin önemli bir classtır.
2. Page objelerini instantiate(ilk deger atama) için page classlarında PageFactory kullanıyoruz.
3. PageFactory.initElements(driver,this ); this => page instance
driver => bizim gonderecegimiz driver
4. Aslinda PageFactory class’ina, elementlere ilk degeri atayan initElements( ) metodunu kullanmak icin ihtiyacimiz var
----PageFactory.initElements(Driver.getDriver(),page:this)---
*********************************************************************************************************************************

* @FindBy Annotation
Page class’larinda webElementleri locate etmek icin simdiye kadar kullandigimiz
driver.findElement( ) method’unu kullanmayacagiz.***
1. @FindBy notasyonu test class’larinda kullanacagimiz Web Elementlerini Page sayfasinda locate etmek icin kullanilir
2. Bunun icin kullanacagimiz Web Elementini public olarak olusturmali, sonra da @FindBy notasyonu ile locate etmeliyiz
3. Bu islemi yaptiktan sonra hangi test methodumuzda bu web elemente ihtiyac duyarsak page class’indan uretecegimiz obje uzerinden rahatlikla kullanabiliriz
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

*********************************************************************************************************************************
Driver Class
* Singleton Pattern (Tekli Kullanim)
➢ Herhangi bir Java classindan obje kullanimini sinirlayabiliriz. Buna Singleton pattern(tekli
kullanim) denir.
➢ Singleton pattern, class’ı tek bir instance ile kısıtlayan bir software dizayn kalıbıdır.
➢ Proje genelinde farkli objeler olusturulmadan tek bir instance gereksinimimiz olduğunda Singleton class kullaniriz.
➢ Sadece bir obje oluşturmalı ve buna her ihtiyac duyduğumuzda kullanmamiz performans ve bellek kullanımı için de faydalıdır.

* Tum Browserlar icin Kullanim
➢ Driver Classımızı tüm tarayıcılar(browser) için geliştireceğiz.
➢ Driver objesi create etmeden önce farklı tarayıcı koşullarını kontrol etmek için switch statement kullanıyoruz.
➢ Driver Class’i singleton pattern’e uygun dizayn ederek tum projede farkli driver uretilmesinin onune geceriz
➢ Sonra TestBasede yaptigimiz gibi “wait” koyabiliriz.
➢ Ardından driver’i kapatmak icin method olusturuyoruz.
➢ Şu andan itibaren TestBase Classını degil Driver Classını kullanacagiz.


     */


}
