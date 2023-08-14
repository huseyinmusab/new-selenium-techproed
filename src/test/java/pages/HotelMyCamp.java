package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCamp {

    public HotelMyCamp(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()=\"Log in\"]")
    public WebElement loginButton;

    @FindBy(id = "UserName")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(css = "[value=\"Log in\"]")
    public WebElement enterLogin;

    @FindBy(className = "username")
    public WebElement displayedUsername;

    @FindBy(id = "divMessageResult")
    public WebElement wrongLoginMessage;




}
