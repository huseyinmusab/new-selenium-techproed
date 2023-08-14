package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_DataProvider {

    @Test
    public void test01(){

        AmazonPage amazonPage=new AmazonPage();

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        amazonPage.searchBox.sendKeys("Nutella",Keys.ENTER);

        String expectedWord ="Nutella";
        String actualWord =amazonPage.resultWe.getText();
        System.out.println(actualWord);

        Assert.assertTrue(actualWord.contains(expectedWord));
        Driver.closeDriver();
    }





    @DataProvider
    public static Object[][] searchedWords() {
        return new Object[][]{{"java"},{"selenium"},{"samsung"},{"iphone"}};
    }
    //when we mouse over the "@Test(dataProvider ="searchedWords")", it gives us to create a @DataProvider
    //method above,so it is useful to search multiple data in a same test case
    @Test(dataProvider ="searchedWords")
    public void test02(String words){
        //search java,selenium,samsung and iphone
        AmazonPage amazonPage=new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        amazonPage.searchBox.sendKeys(words,Keys.ENTER);
        String actualWord =amazonPage.resultWe.getText();
        System.out.println(actualWord);

        Assert.assertTrue(actualWord.contains(words));
        //Driver.closeDriver();


    }

    @Test(dependsOnMethods = "test02")
    public void test03(){
        Driver.closeDriver();
        //we created this method to close driver after using the enries with dataprovider
    }



}
