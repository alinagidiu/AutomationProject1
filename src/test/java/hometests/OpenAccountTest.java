package hometests;

import Pages.LoginPage;
import Pages.OpenAccountPage;
import Pages.OverviewPage;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OpenAccountTest extends BaseTest {

    @Test
    public void testOpenAccountOption(){
        initTest("Open Acount Test");
         LoginPage loginPage = null;
         loginPage = new LoginPage(driver);


        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/homework.properties");
        String username= configLoader.getProperty("username");
        String pas= configLoader.getProperty("password");
        String option = configLoader.getProperty("option");
        String account = configLoader.getProperty("account");

        loginPage.setUserName(username);
        loginPage.setPassword(pas);
        loginPage.clickLoginButton();

        var openAccountPage = overviewPage.clickOpenNewAccount();
        openAccountPage.selectTypeAccount(option);
        var selectedOptions = openAccountPage.getSelectedTypeAcountOptions();
        assertEquals(selectedOptions.size(),1,"Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");
        openAccountPage.selectExistingAccount(account);
        var accountOptions = openAccountPage.getSelectedExistingAccountOptions();
        assertEquals(accountOptions.size(),1,"Incorrect number of selections");
        assertTrue(accountOptions.contains(account), "Option not selected");
        openAccountPage.clickOpenNewAccountButton();
        overviewPage.waitMethod();
        assertEquals(openAccountPage.accountOpenedText(),"Congratulations, your account is now open." ,  "Open Account Failed");









    }


}
