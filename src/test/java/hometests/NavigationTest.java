package hometests;

import Pages.LoginPage;
import Pages.OverviewPage;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class NavigationTest extends BaseTest {

    @Test
    public void testNavigationMenu(){

        initTest("Navigation Test");

        LoginPage loginPage = null;
        loginPage = new LoginPage(driver);
        OverviewPage overviewPage = null;
        overviewPage = new OverviewPage(driver);


        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/homework.properties");
        String username= configLoader.getProperty("username");
        String pas= configLoader.getProperty("password");

        loginPage.setUserName(username);
        loginPage.setPassword(pas);
        loginPage.clickLoginButton();

        overviewPage.clickOpenNewAccount();
        assertEquals(overviewPage.confirmOpenNewAccount(),"Open New Account" ,  "Error:  did not navigate to the expected page.");
        overviewPage.clickAccountsOverview();
        assertEquals(overviewPage.confirmAccountsOverview(),"Accounts Overview" ,  "Error:  did not navigate to the expected page.");
        overviewPage.clickTransferfunds();
        assertEquals(overviewPage.confirmTransferFunds(),"Transfer Funds" ,  "Error:  did not navigate to the expected page.");
        overviewPage.clickBillPay();
        assertEquals(overviewPage.confirmBillPay(),"Bill Payment Service" ,  "Error:  did not navigate to the expected page.");
        overviewPage.clickFindTransactions();
        assertEquals(overviewPage.confirmFindTransactions(),"Find Transactions" ,  "Error:  did not navigate to the expected page.");
        overviewPage.clickUpdateContactInfo();
        assertEquals(overviewPage.confirmUpdateContactInfo(),"Update Profile" ,  "Error:  did not navigate to the expected page.");
        overviewPage.clickRequestLoan();
        assertEquals(overviewPage.confirmRequestLoan(),"Apply for a Loan" ,  "Error:  did not navigate to the expected page.");
        overviewPage.setLogout();
        assertEquals(overviewPage.confirmLogOut(),"Customer Login" ,  "Error:  did not navigate to the expected page.");




    }
}
