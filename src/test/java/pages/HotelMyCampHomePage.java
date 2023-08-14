package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HotelMyCampHomePage {
    public HotelMyCampHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "menuHotels")
    public WebElement hotelManagement;

    @FindBy(css = ".sub-menu [href$=\"Admin\"]")
    public List<WebElement> allLeftHeaders;

    @FindBy(css = ".sub-menu [href$=\"Admin\"]")
    public List<WebElement> allLeftHeaders3;

    //css = "[href$=\"/admin/RoomReservationAdmin/Create\"]
    @FindBy(css = "[href$=\"/admin/RoomReservationAdmin/Create\"]")
    public WebElement addRoomReserv;

    @FindBy(css = "[title=\"Select User\"]")
    public WebElement userDropdown;




}
