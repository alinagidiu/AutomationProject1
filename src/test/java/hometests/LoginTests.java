package hometests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest {




    @Test
    public void testSuccessfulLogin(){
        initTest("Login Test");

        LoginPage loginPage = null;
        loginPage = new LoginPage(driver);


        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/homework.properties");
        String username= configLoader.getProperty("username");
        String pas= configLoader.getProperty("password");

        loginPage.setUserName(username);
        loginPage.setPassword(pas);
        loginPage.clickLoginButton();
        loginPage.accountsOverviewText();
        assertEquals(loginPage.accountsOverviewText(),"Accounts Overview" ,  "Login Failed");

    }
    @Test
    public void testLogin() {


    }



}
