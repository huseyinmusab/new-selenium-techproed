package day18_PomStarts;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.FaceBookPage;
import utilities.Driver;

public class C03_PageClassFacebookTest {

    FaceBookPage faceBookPage= new FaceBookPage();
    Faker faker=new Faker();
    @Test
    public void test01(){
        Driver.getDriver().get("https:www.facebook.com");
        faceBookPage.allowCookies.click();

        faceBookPage.emailBox.sendKeys(faker.internet().emailAddress());
        faceBookPage.passwordBox.sendKeys(faker.internet().password());

        faceBookPage.login.click();
        Driver.closeDriver();

    }



}
