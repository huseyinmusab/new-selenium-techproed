package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.List;
import java.util.Set;

public class C01_Cookies extends TestBaseBeforeAfter {
    /*
    Cookies
Çerezler, belirli kullanıcıları tanımlamak ve bu kullanıcıların göz atma deneyimini iyileştirmek için kullanıcının bilgisayarı ile web sunucusu arasında takas edilen,
 kullanıcı adı ve parola gibi küçük veri parçalarını içeren dosyalardır.
İnternette gezinirken ziyaret ettiğiniz web sayfaları, bilgisayarınıza ve telefonunuza küçük bilgi dosyaları kaydeder.
Bu dosyalar telefon veya bilgisayarınızın hafızasında saklanır.
Daha sonra aynı siteleri ziyaret ettiğinizde bu kayıtlı bilgi dosyaları sayesinde siteler sizi tanıyabilir.
Bilgileriniz bu dosyalara yazıldığından dolayı tekrar aynı web sayfalarını ziyaret ettiğinizde bilgilerinizi yeniden girmeye gerek duymazsınız.
Cookies, kişisel bilgiler de dahil olmak üzere birçok bilgiyi içerebilir.
 Web siteleri, ancak sizin izin verdiğiniz bilgilere erişebilir.
  Bu web sayfaları, sizin vermediğiniz bilgilere erişemez ya da bilgisayarınızdaki diğer dosyaları görüntüleyemez.
  Birkaç farklılıkla, siber dünyadaki çerezlerin oturum
çerezi ve kalıcı çerez olmak üzere iki çeşidi vardır.

Oturum çerezleri yalnızca bir web sitesinde gezinirken kullanılır. Bunlar rastgele erişimli bellekte saklanır ve hiçbir zaman sabit sürücüye yazılmaz.
Oturum sona erdiğinde oturum çerezleri otomatik olarak silinir.
Kalıcı çerezler bir bilgisayarda sonsuza kadar kalır ancak birçoğunun bir son kullanma tarihi olup bu tarihe gelindiğinde otomatik olarak kaldırılırlar.

Üçüncü taraf çerezler daha sıkıntılıdır.
Bunlar, genellikle kullanıcıların halihazırda gezindiği web sayfalarındaki reklamlarla bağlantılı olduklarından bu sayfalardan farklı web siteleri tarafından oluşturulur.
*****************************************************************************
Selenium ile cookies otomasyonu yapabiliriz.
Driver.manage( ). method’u ile cookie’leri
- listeleyebilir
- Isim ile cagirabilir
- Yeni cookie ekleyebilir
- Var olanlari ismi silebilir
- Var olan tum cookie’leri silebiliriz
******************************************************************************
Cookies Class Work Yeni bir class olusturun : cookiesAutomation
1-Amazon anasayfaya gidin
2-tum cookie’leri listeleyin
3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
6-eklediginiz cookie’nin sayfaya eklendigini test edin
7-ismi skin olan cookie’yi silin ve silindigini test edin
8-tum cookie’leri silin ve silindigini test edin
     */

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

        //tum cookie’leri listeleyin
        Set<Cookie> allCookies =driver.manage().getCookies(); //Sets are not like Lists and arrays
        //System.out.println(allCookies);
//        for (int i = 0; i < allCookies.size(); i++) {
//            System.out.println(allCookies.toString());
//        }
        int count=1;
        for (Cookie w:allCookies) {
            System.out.println(count+".cookie: " +w);
            System.out.println(count+".name: "   +w.getName());
            System.out.println(count+".value: "  +w.getValue());
            count++;
        }
        System.out.println("***********************************************************************");
        //Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieNumber=allCookies.size();
        Assert.assertTrue(cookieNumber>5);
        //ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w:allCookies) {
            if (w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }
        }

        //ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie newCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(newCookie);

        allCookies =driver.manage().getCookies(); //Sets are not like Lists and arrays,copy-paste and get rid off extras like==> Set<Cookie> allCookies
        count=1;
        for (Cookie w:allCookies) {
            System.out.println(count+".cookie: " +w);
            System.out.println(count+".name: "   +w.getName());
            System.out.println(count+".value: "  +w.getValue());
            count++;
        }
        System.out.println("***********************************************************************");

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(allCookies.contains(newCookie));

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");//DELETE

        allCookies =driver.manage().getCookies(); //Sets are not like Lists and arrays,copy-paste and get rid off extras like==> Set<Cookie> allCookies
        count=1;
        for (Cookie w:allCookies) {
            System.out.println(count+".cookie: " +w);
            System.out.println(count+".name: "   +w.getName());
            System.out.println(count+".value: "  +w.getValue());
            count++;
        }
        Assert.assertFalse(allCookies.contains("skin"));

        System.out.println("***********************************************************************");

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//ALL DELETE

        allCookies =driver.manage().getCookies(); //Sets are not like Lists and arrays,copy-paste and get rid off extras like==> Set<Cookie> allCookies
        count=1;
        for (Cookie w:allCookies) {
            System.out.println(count+".cookie: " +w);
            System.out.println(count+".name: "   +w.getName());
            System.out.println(count+".value: "  +w.getValue());
            count++;
        }

        System.out.println(allCookies.size());//0
        Assert.assertEquals(allCookies.size(),0);
        Assert.assertTrue(allCookies.isEmpty());

        System.out.println("***********************************************************************");



    }
}
