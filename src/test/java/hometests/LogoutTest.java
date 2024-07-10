package hometests;

import Pages.LoginPage;
import Pages.OverviewPage;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class LogoutTest extends BaseTest {

    @Test
    public void testSuccessfulLogout(){
        initTest("Logout Test");
        LoginPage loginPage = null;
        OverviewPage overviewPage = null;
        overviewPage = new OverviewPage(driver);
        loginPage = new LoginPage(driver);


        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/homework.properties");
        String username= configLoader.getProperty("username");
        String pas= configLoader.getProperty("password");

        loginPage.setUserName(username);
        loginPage.setPassword(pas);
        loginPage.clickLoginButton();
        loginPage.accountsOverviewText();
        assertEquals(loginPage.accountsOverviewText(),"Accounts Overview" ,  "Login Failed");
        overviewPage.setLogout();
        overviewPage.confirmLogOut();
        overviewPage.waitMethod();
        assertEquals(overviewPage.confirmLogOut(),"Customer Login" ,  "Log Out Failed");
    }
}
