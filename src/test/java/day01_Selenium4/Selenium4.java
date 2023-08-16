package day01_Selenium4;

public class Selenium4 {
    /*
    1. SELENIUM
Selenium, geliştiriciler için zorlu bir araç takımıdır

2000’lerin başında; Mercury Interactive adındaki bir şirket, Astra Quick Test adlı test aracı ile test otomasyon dünyasına hükmediyordu. Geniş bir dünyaya hükmetmesine karşın aslen çok başarılı olmayan bu test aracı ile yalnızca Windows üzerinde test yapılabilmekte, sınırlı sayıda tarayıcı desteklenmekte ve VBScript adında tek bir programlama dili kullanılabilmekteydi.

2004 yılında Jason Huggins devrim niteliğinde bir fikir ortaya attı. Astra Quick Test aracının ve Mercury Interactive firmasının yetersizliğine ve bu yetersizliğe rağmen artan popülaritesine tepki olarak, geliştirdiği araca “Merkür Zehirlenmesi” hastalığının tedavisinde kullanılan Selenium elementinin ismini verdi. Selenium Test Kütüphanesinin doğuşu bu şekilde ortaya çıktı.

•Selenium, test otomasyon dünyasının önemli ürünlerinden biri haline gelen, açık kaynaklı, yazılım test otomasyon kütüphanesidir. Bilinenin aksine tek bir araç değil, paketlerin oluşturduğu bir kütüphanedir. Bu sebeple Selenium Suite olarak adlandırılır.
•Selenium, birçok işletim sistemini, tarayıcıyı ve yazılım dilini desteklemektedir. Netflix, Google, HubSpot gibi büyük şirketlerde aktif olarak kullanılmaktadır. Suite’e ait paketler, farklı test problemleri ve farklı ihtiyaçlar için çeşitli çözümler sunmaktadır. Yazının devamında tüm paketler ayrıntılı bir şekilde işlenecektir.
•Desteklenen İşletim Sistemleri : Windows, MacOS, Linux, Unix
•Desteklenen Tarayıcılar : IE, Firefox, Chrome, Opera, Safari
•Desteklenen Programlama Dilleri : Java, Python, C#, PHP, Ruby, Perl, JavaScript


Avantajları

  Test Otomasyon dünyasında önemli bir konuma sahip olan Selenium Suite, geliştiricilere çok büyük avantajlar sağlamaktadır. Bunlardan kısaca bahsetmek gerekirse:

Açık Kaynak Olması

  Selenium’un en büyük avantajı, ücretsiz ve taşınabilir (portable) bir kütüphane olmasıdır. Doğrudan bir maliyete sahip değildir. Kütüphane ücretsiz olarak indirilebilir ve kullanılabilir. Halihazırda yazılmış olan kodlar, herhangi bir ücret ödemeden kullanılabilir ve değiştirilebilir.

Çoklu OS Desteği

  Selenium, Windows, MacOS, Linux, UNIX, vb. birçok İşletim Sisteminde (OS) çalışabilir ve bu sistemlerde geliştirilen senaryoları destekleyebilir. Örneğin, Windows işletim sistemi kullanarak test senaryoları oluşturabilir ve bu senaryoyu Linux tabanlı bir sistemde kolaylıkla çalıştırabiliriz.

Çoklu Tarayıcı Desteği

  Selenium; Internet Explorer, Chrome, Firefox, Opera, Safari, vb. birçok tarayıcıda destek sağlar. Bu sayede, testleri yürütürken aynı kod parçası ile birçok tarayıcıyı test etme imkanı sunar.

Paralel Test Yürütme

  Bir web uygulamasını test ederken, uygulamanın farklı tarayıcılarda test edilmesi gerekebilir. Selenium WebDriver ve TestNG kullanarak bunu başarabiliriz. Yürütülecek fazla sayıda komut dosyası varsa ve bunları her bir tarayıcıda sırayla yürütmek gerekiyorsa, bu işlem hem zaman alıcı olur hem de tekrara düştüğü için sıkıcı hale gelir. Bu sorun, Selenium’un Paralel Test Yürütme fonksiyonu ile önlenebilir.

Framework Desteği

  Selenium açık kaynak kodlu bir yazılım kütüphanesi olduğu için, piyasada bulunan Framework’ler tarafından rahatlıkla entegre edilebilir haldedir. Bu özelliği sayesinde yazılım geliştirme ve test dünyasında kullanılan önemli frameworkler (JUnit, TestNG, RobotFramework, NUnit vb) Selenium tarafından desteklenmekte ve gün geçtikçe yenileri, desteklenen frameworkler listesine eklenmektedir.




Dezavantajları


Yalnızca Web Testi Yapılabilmesi

  Selenium, yalnızca web tabanlı uygulamaları desteklemektedir. Bu durum bazı kurumsal test otomasyon araçlarının karşısında Selenium’u geriye atmaktadır. Selenium kullanarak herhangi bir işletim sistemi ve tarayıcıda testler yapılabilir, ancak yalnızca Selenium kullanarak mobil testler yapılamamaktadır. Bunun için ek bir çözüm olarak WebDriver protokolünü kullanarak iOS ve Android mobil ve karma uygulamalar için Appium geliştirilmiştir. Ek olarak Windows tabanlı uygulamaların otomatize edilmesi için yine Selenium tabanlı (WebDriver)bir geliştirme olan Winium kullanılabilmektedir.

API Test Desteği Olmaması

  Test senaryolarının otomatize edilmesinde Kullanıcı Arayüzü (UI) testleri ne kadar önemliyse, API testleri de aynı derecede öneme sahiptir. Çeşitli otomasyon araçlarında bulunan bu özellik Selenium tarafından desteklenmemekte, yalnızca ek çözümler getirilerek API testleri yapılabilmektedir.

Resmi Kontak Olmayışı

  Firmalar, test senaryolarını otomatize etmek için kullandığı uygulamalara belirli bir yatırım yapmaktadır. Bu yatırımın karşılığında, iletişime geçilecek resmi (official) bir kontağın olmayışı sorunlara yol açabilmektedir. Selenium açık kaynak bir paket olması sebebiyle gönüllü çalışma prensibine sahiptir.

Yalnızca Community (Topluluk) Desteği

  Selenium ile ilgili araştırmaya ihtiyaç duyulan durumlar, tecrübesiz kişileri zor durumda bırakabilmektedir. Aslında yardımının alınabileceği çok sayıda ders, soru, cevap bağlantıları bulunmaktadır ancak doğrudan ürün destek ekibinden değil de topluluktan yardım istemek negatif bir özellik olarak sayılabilir.

Selenium WebDriver

Selenium WebDriver, test case oluşturmak ve yürütmek için tasarlanmış bir framework’tür. Case’ler WebDriver metotlarındaki element locator’lar aracılığı ile oluşturulur ve yürütülür. Selenium WebDriver bir IDE değil, programlama kütüphanesidir. Her tarayıcı için bir tarayıcı driver’ı bulunmaktadır (Chrome Driver, GeckoDriver vb). Bu sayede her bir tarayıcı ile kendi driver’ı üzerinden doğrudan iletişime geçilir.

Selenium WebDriver ile;

•Daha fazla programlama dili, işletim sistemi ve web tarayıcısı için destek verilmektedir.
•Selenium 1’in dosya yükleme, indirme, pop-up’lar ve iletişim engeli gibi sınırlamalarının üstesinden gelinmiştir.
•Toplu test, çapraz platform (cross platform) tarayıcı testi ve Data Driven Test için destek sağlamaktadır.
     */
}
