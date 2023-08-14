package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentalCarPage {
    public BlueRentalCarPage(){//constructor olusturup public yapmaliyiz
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Login")
    public WebElement login;

    @FindBy(id = "formBasicEmail")
    public WebElement userEmail;

    @FindBy(id = "formBasicPassword")
    public WebElement userPassword;

    @FindBy(css = ".card [type=\"submit\"]")
    public WebElement userlogin;

    @FindBy(id = "dropdown-basic-button")
    public WebElement loggedIn;

}
