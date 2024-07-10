package hometests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class RegisterTest extends BaseTest {


    @Test
    public void testSuccessfulRegister(){
        initTest("Register Test");

        RegisterPage registerPage = null;
        HomePage homePage = null;
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/homework.properties");
        String firstName= configLoader.getProperty("firstname");
        String lastName= configLoader.getProperty("lastname");
        String address= configLoader.getProperty("address");
        String city= configLoader.getProperty("city");
        String state= configLoader.getProperty("state");
        String zip= configLoader.getProperty("zip");
        String phone= configLoader.getProperty("ph");
        String ssn= configLoader.getProperty("ssn");
        String username= configLoader.getProperty("username");
        String pas= configLoader.getProperty("password");


        homePage.clickRegister();

        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterAddress(address);
        registerPage.enterCity(city);
        registerPage.enterState(state);
        registerPage.enterZip(zip);
        registerPage.enterPhone(phone);
        registerPage.enterSsn(ssn);
        registerPage.enterUsername(username);
        registerPage.enterPassword(pas);
        registerPage.enterConfirmPassword(pas);
        registerPage.clickRegisterButton();
        assertEquals(registerPage.welcomeText(),"Welcome" + " " + username,  "Register failed!");

    }
}
