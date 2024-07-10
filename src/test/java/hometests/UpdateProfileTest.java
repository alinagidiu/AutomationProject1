package hometests;

import Pages.LoginPage;
import Pages.OverviewPage;
import Pages.UpdateContactInfoPage;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import static org.testng.Assert.assertEquals;

public class UpdateProfileTest extends BaseTest {

     @Test
    public void testUpdateProfile() {

         initTest("Update Profile Test");

         UpdateContactInfoPage updatePage = null;
         updatePage = new UpdateContactInfoPage(driver);
         OverviewPage overviewPage = null;
         overviewPage = new OverviewPage(driver);
         LoginPage loginPage = null;
         loginPage = new LoginPage(driver);



        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/updateprofile.properties");
        String firstName = configLoader.getProperty("firstname");
        String lastName = configLoader.getProperty("lastname");
        String address = configLoader.getProperty("address");
        String city = configLoader.getProperty("city");
        String state = configLoader.getProperty("state");
        String zip = configLoader.getProperty("zip");
        String phone = configLoader.getProperty("ph");
        String username= configLoader.getProperty("username");
        String pas= configLoader.getProperty("password");

         loginPage.setUserName(username);
         loginPage.setPassword(pas);
         loginPage.clickLoginButton();

        overviewPage.clickUpdateContactInfo();

        updatePage.clearText();

        updatePage.enterFirstName(firstName);
        updatePage.enterLastName(lastName);
        updatePage.enterAddress(address);
        updatePage.enterCity(city);
        updatePage.enterState(state);
        updatePage.enterZip(zip);
        updatePage.enterPhone(phone);
        updatePage.clickUpdateProfileButton();
        overviewPage.waitMethod();
        assertEquals(updatePage.getUpdateProfileText(),"Profile Updated","Update failed!");

    }
}
