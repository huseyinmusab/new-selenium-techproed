package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_ActionClass_amazon extends TestBaseBeforeAfter {
    /*
➢ 1.Adım: Actions class’ta bir object oluşturulur. Actions actions= new Actions(driver);
Actions Class
➢ 2. Adım: Üzerinde çalışmak istediğiniz WebElement öğesini bulunur.
WebElement element = driver.findElement(By.id("ID"));
➢ 3.Adim : Ardından bu webelement üzerinde action gerçekleştirilir. Örneğin tıklamak için.
actions.click(element).perform( );
NOT : Action Class’ini her kullanmak istedigimizde yeniden obje olusturmamiz gerekmez.
action objesi’ni bir kere olusturunca, istediginiz kadar action. ile baslayan komut yazar ve calismasi
icin sonuna perform( ) yazariz.
action objesi kullanilarak baslayan her komut, calismak icin perform( ) bekler.
=========================================================
Mouse Base Actions Mouse Aksiyonlari
➢ doubleClick ( ): WebElement’e çift tıklama yapar
➢ clickAndHold ( ): WebElement uzerinde click yapili olarak bizden komut bekler.
➢ dragAndDrop ( ): WebElement’i bir noktadan diğerine sürükler ve bırakır
➢ moveToElement ( ): Mouse’u istedigimiz WebElement’in uzerinde tutar
➢ contextClick ( ): Mouse ile istedigimiz WebElement’e sag tiklama yapar.
     */

    @Test
    public void testo1(){
        driver.get("https://www.amazon.com");
        WebElement accounList = driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        //action class for hover
        Actions actions =new Actions(driver);
        actions.moveToElement(accounList).perform();

        WebElement createElement = driver.findElement(By.xpath("//*[text()='Create a List']"));
        createElement.click();


    }


}
