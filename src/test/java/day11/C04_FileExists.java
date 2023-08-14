package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExists {
    /*
    File Exist
● Selenium ile windows uygulamalarını test edemiyoruz. Ama test etmek için JAVA kullanabiliriz.
● Bilgisayarımızda bir dosya olup olmadığını(exist) kontrol etmek için Java'yı kullanabiliriz
○System.getProperty ( "user.dir"); icinde bulunulan klasörün yolunu (Path) verir
○System.getProperty ( "user.home"); bilgisayarimizda bulunan user klasörünü verir
○Files.exists (Paths.get (filePath)); Bilgisayarınızda dosyanın olup olmadığını kontrol eder
● İndirilen bir dosyanın indirme klasörümüzde olup olmadığını kontrol etmek için bu Java konseptini kullanabiliriz
     */

    @Test
    public void test01(){
//        System.out.println(System.getProperty("user.dir"));//   /Users/hueseyin.kocal/Desktop/new-selenium-techproed. ==>the path that i am on
//
//        System.out.println(System.getProperty("user.home"));//  /Users/hueseyin.kocal ==>Ana dizin
//
//        String farkliBolum = System.getProperty("user.home");
//        //  /Users/hueseyin.kocal/Desktop/presentation\ BANKA.pdf===>masaustundeki dosyanin yolu, kendine gore ayarla baska bir dosyayi alarak
//        //presentation ile BANKA arasinda bosluk var dikkat
//
//        String ortakBolum = "/Desktop/presentation BANKA.pdf";
//
//        String masaUstuYolu =farkliBolum+ortakBolum;
//        System.out.println(masaUstuYolu);
//
//        //ASSERTION:
//        Assert.assertTrue(Files.exists(Path.of(masaUstuYolu)));
//

        //================================================================
        String FilePath ="/Users/hueseyin.kocal/Desktop/presentation BANKA.pdf";
        System.out.println(Files.exists(Paths.get(FilePath)));//true
        Assert.assertTrue(Files.exists(Paths.get(FilePath)));


    }
}
