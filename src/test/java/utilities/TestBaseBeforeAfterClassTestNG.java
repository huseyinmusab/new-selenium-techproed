package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestBaseBeforeAfterClassTestNG {
/*
        ==========================================================================================================
        @BeforeMethod   ===>INSTEAD OF Before
        @AfterMethod    ===>INSTEAD OF After
        TestNG       INSTEAD OF     Junit
        ==========================================================================================================

 */


    //difference than BeforeAfter class is "static" here, we dont need to do this with static
    protected static WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public void tearDown(){
        // driver.close();
    }
}
