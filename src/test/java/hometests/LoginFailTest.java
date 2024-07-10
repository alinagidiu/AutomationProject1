package hometests;

import Pages.LoginPage;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class LoginFailTest extends BaseTest {

    @Test
    public void testFailedLogin(){
        initTest("LoginFail Test");

        LoginPage loginPage = null;
        loginPage = new LoginPage(driver);


        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/homework.properties");
        String username= configLoader.getProperty("usernamefail");
        String pas= configLoader.getProperty("passwordfail");

        loginPage.setUserName(username);
        loginPage.setPassword(pas);
        loginPage.clickLoginButton();
        loginPage.errorText();
        assertEquals(loginPage.errorText(),"The username and password could not be verified." ,  "Login Success!");
    }
}
