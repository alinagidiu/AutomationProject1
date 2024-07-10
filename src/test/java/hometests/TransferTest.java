package hometests;

import Pages.LoginPage;
import Pages.OverviewPage;
import Pages.TransferPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import java.util.Map;

import static Pages.OverviewPage.getAccountBalances;
import static org.testng.Assert.assertEquals;


public class TransferTest extends BaseTest {

    @Test
    public void testTransferFunds() {
        initTest("Transfer Test");
        LoginPage loginPage = null;
        loginPage = new LoginPage(driver);
        OverviewPage overviewPage = null;
        overviewPage = new OverviewPage(driver);
        TransferPage transferPage = null;
        transferPage = new TransferPage(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/homework.properties");
        String username = configLoader.getProperty("username");
        String pas = configLoader.getProperty("password");
        ConfigLoader configLoader1 = new ConfigLoader("src/test/resources/proprietati/transfer.properties");
        Double amount = Double.valueOf(configLoader1.getProperty("amount"));
        String fromaccount = configLoader1.getProperty("fromaccount");
        String toaccount = configLoader1.getProperty("toaccount");

        loginPage.setUserName(username);
        loginPage.setPassword(pas);
        loginPage.clickLoginButton();

        overviewPage.waitMethod();
        Map<String, Double> initialBalances = getAccountBalances(driver, fromaccount, toaccount);

        // Debug: Print the initial balances
        System.out.println("Initial balances:");
        System.out.println("From Account (" + fromaccount + "): " + initialBalances.get(fromaccount));
        System.out.println("To Account (" + toaccount + "): " + initialBalances.get(toaccount));


        overviewPage.clickTransferfunds();
        transferPage.enterAmount(String.valueOf(amount));
        transferPage.selectFromAccount(fromaccount);
        transferPage.selectToAccount(toaccount);
        transferPage.clickTransferButton();

        overviewPage.waitMethod();
        assertEquals(transferPage.transferText(), "Transfer Complete!", "Transfer failed!");

        overviewPage.clickAccountsOverview();
        overviewPage.waitMethod();

        Map<String, Double> updatedBalances = getAccountBalances(driver, fromaccount, toaccount);

        // Debug: Print the updated balances
        System.out.println("Updated balances:");
        System.out.println("From Account (" + fromaccount + "): " + updatedBalances.get(fromaccount));
        System.out.println("To Account (" + toaccount + "): " + updatedBalances.get(toaccount));

        overviewPage.waitMethod();

        double expectedFromAccountBalance = (initialBalances.get(fromaccount) - amount);
        double expectedToAccountBalance =  (initialBalances.get(toaccount) + amount);

        if (Math.abs(updatedBalances.get(fromaccount) - expectedFromAccountBalance) < 0.01 &&
                Math.abs(updatedBalances.get(toaccount) - expectedToAccountBalance) < 0.01) {
            System.out.println("Balanțele conturilor sunt actualizate corect.");
        } else {
            System.out.println("Eroare în actualizarea balanțelor.");
        }



    }
}