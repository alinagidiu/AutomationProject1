package hometests;

import Pages.HomePage;
import Pages.LookupPage;
import Pages.RegisterPage;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTest extends BaseTest {

    @Test
    public void testForgotPassword() {


        initTest("Forgot Password Test");

        LookupPage lookupPage = null;
        HomePage homePage = null;
        homePage = new HomePage(driver);
        lookupPage = new LookupPage(driver);


        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/homework.properties");
        String firstName = configLoader.getProperty("firstname");
        String lastName = configLoader.getProperty("lastname");
        String address = configLoader.getProperty("address");
        String city = configLoader.getProperty("city");
        String state = configLoader.getProperty("state");
        String zip = configLoader.getProperty("zip");
        String ssn = configLoader.getProperty("ssn");


        homePage.clickForgotPassword();
        lookupPage.enterFirstName(firstName);
        lookupPage.enterLastName(lastName);
        lookupPage.enterAddress(address);
        lookupPage.enterCity(city);
        lookupPage.enterState(state);
        lookupPage.enterZip(zip);
        lookupPage.enterSsn(ssn);
        lookupPage.clickFindmyloginButton();

        lookupPage.lookupText();
        assertEquals(lookupPage.lookupText(), "Your login information was located successfully. You are now logged in.", " Error!");

    }
}
