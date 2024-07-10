package hometests;

import Pages.LoginPage;
import Pages.OverviewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import java.time.Duration;


public class TransactionsTest extends BaseTest {

    @Test
    public void testTransactions(){


        initTest("Transactions Test");
        LoginPage loginPage = null;
        loginPage = new LoginPage(driver);
        OverviewPage overviewPage = null;
        overviewPage = new OverviewPage(driver);


        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/homework.properties");
        String username = configLoader.getProperty("username");
        String pas = configLoader.getProperty("password");
        ConfigLoader configLoader1 = new ConfigLoader("src/test/resources/proprietati/transfer.properties");
        String accountnumber= configLoader1.getProperty("fromaccount");


        loginPage.setUserName(username);
        loginPage.setPassword(pas);
        loginPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Accounts Overview")));

        overviewPage.clickAccountsOverview();


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountTable")));

        overviewPage.verifyTransactions(driver,accountnumber);






    }
}
