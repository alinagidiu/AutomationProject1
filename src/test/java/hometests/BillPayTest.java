package hometests;

import Pages.*;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class BillPayTest extends BaseTest {


    @Test
    public void testBillPay(){

        initTest("BillPay Test");
        BillPayPage billpayPage = null;
        LoginPage loginPage = null;
        loginPage = new LoginPage(driver);
        billpayPage = new BillPayPage(driver);
        OverviewPage overviewPage = null;
        overviewPage = new OverviewPage(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/billpay.properties");
        String payeeName= configLoader.getProperty("payeeName");
        String address= configLoader.getProperty("address");
        String city= configLoader.getProperty("city");
        String state= configLoader.getProperty("state");
        String zip= configLoader.getProperty("zip");
        String phone= configLoader.getProperty("ph");
        String account= configLoader.getProperty("account");
        String verifyAccount= configLoader.getProperty("verifyAccount");
        String amount= configLoader.getProperty("amount");
        String fromAccount= configLoader.getProperty("fromAccount");

        ConfigLoader configLoader1 = new ConfigLoader("src/test/resources/proprietati/homework.properties");
        String username= configLoader1.getProperty("username");
        String pas= configLoader1.getProperty("password");


        loginPage.setUserName(username);
        loginPage.setPassword(pas);
        loginPage.clickLoginButton();

        overviewPage.clickBillPay();

        billpayPage.enterPayeeName(payeeName);

        billpayPage.enterAddress(address);
        billpayPage.enterState(state);
        billpayPage.enterCity(city);
        billpayPage.enterZip(zip);
        billpayPage.enterPhone(phone);
        billpayPage.enterAccount(account);
        billpayPage.enterVerifyAccount(verifyAccount);
        billpayPage.enterFromAcount(fromAccount);
        billpayPage.enterAmount(amount);
        billpayPage.clickSendPaymentButton();
        assertEquals(billpayPage.billPaymentText(),"Bill Payment Complete",  "Payment failed!");

    }
    }

