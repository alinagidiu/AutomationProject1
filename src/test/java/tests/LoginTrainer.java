package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import org.openqa.selenium.By;
import utile.ConfigLoader;

import java.time.Duration;

public class LoginTrainer extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    @Test
    public void loginTrainer(){


        initTest("Login trainer");// ce pune in raport//initializare raport
        login = new Login(driver);//obiect de tip Login
        dashboard = new Dashboard(driver);



        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");//se face instanta de ConfigLoader
        String email= configLoader.getProperty("email");
        String pas= configLoader.getProperty("password");


        login.enterUserName(email);//se apeleaza metodele
        login.enterPassword(pas);
        login.clickSubmitButton();

       // WebDriverWait waitTime = new WebDriverWait(driver, Duration.ofSeconds(10));
        //waitTime.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='navigation__link userName']")));

        if(login.errorForbiddenAccess()){
            login.clickRegisterButton();
            register.registerUser (true);
        }
        Assert.assertTrue(dashboard.getUserEmailFromDashBoard().equalsIgnoreCase("email"));
    }
}
