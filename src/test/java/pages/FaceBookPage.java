package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FaceBookPage {
    public FaceBookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "[title=\"Allow all cookies\"]")
    public WebElement allowCookies;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "pass")
    public WebElement passwordBox;

    @FindBy(css = "button[name='login']")
    public WebElement login;


}
