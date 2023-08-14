package day06;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton_facebook {

    /*
    Genelde 3 bilesen de kullanilir, Ancak bazen daha az bilesen yazmak da yeterli olabilir.
Sadece tag name kullanarak xpath yazmak icin driver.findElement(By.xpath(“//input” ));
Tag name farketmeksizin attribute ismi ve attribute value kullanarak xpath yazmak icin driver.findElement(By.xpath(“// * [@type=‘text’]” ));
Attribute name farketmeksizin tag name ve attribute value kullanarak xpath yazmak icin driver.findElement(By.xpath(“//input[@ *=‘text’]” ));
Attribute value farketmeksizin tag name ve attribute ismi kullanarak xpath yazmak icin driver.findElement(By.xpath(“//input[@type]” ));

Bazen de attribute’e bagli olmadan sadece web element icinde bulunan text kullanilabilir.
Exact Text(Belirli bir text) ile element bulma: driver.findElement(By.xpath(“//tagname[.='text name']” ));
driver.findElement(By.xpath(“//*[.='text name'] ” )); driver.findElement(By.xpath(“//*[text( )='exact text with extra space and all'] ” ));
Belirli bir metni içeren bir öğeyi bulmak için şunları kullanabiliriz: driver.findElement(By.xpath(“//*[contains(text(),'piece of text')]” ));
❖ Tek attribute ile unique bir sonuca ulasamazsak birden fazla attribute yazabiliriz driver.findElement(By.xpath(“//div[@id='logo' or class='flex-col logo’ ] ”));
driver.findElement(By.xpath(“//div[@id='logo’ and class='flex-col logo’ ] ”));


 8- By.cssSelector( ) Method
Css selector xpath'e benzer. Üç ana tip kullanılır
1) css = tagName[attribute name= 'value’ ];
driver.findElement(By.cssSelector("input[name='session[password]']"));
2 ) css="tagName#idValue" veya sadece css="#idValue" =>yalnızca id value ile çalışır
driver.findElement(By.cssSelector("input#session_password"));
3 ) css="tagName.classValue" veya sadece css=".classValue"=>yalnızca class value ile çalışır
driver.findElement(By.cssSelector(".form-control"));
     */




    WebDriver driver;
    @Before
    public void setUp(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://ww.facebook.com");

//        WebElement checbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
//        WebElement checbox2 = driver

        WebElement allowCookies = driver.findElement(By.cssSelector("[title=\"Allow all cookies\"]"));
        allowCookies.click();
        //double Locator
        WebElement createButton = driver.findElement(By.xpath("//a[@role='button' and @data-testid='open-registration-form-button']"));
        createButton.click();

        WebElement maleButton = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement femaleButton = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customButton = driver.findElement(By.xpath("//input[@value='-1']"));




        if (!maleButton.isSelected()){
            maleButton.click();
        }
        Thread.sleep(3000);
        femaleButton.click();
        Thread.sleep(3000);
        customButton.click();
        Thread.sleep(3000);



    }


}
