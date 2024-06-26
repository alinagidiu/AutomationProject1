package tests;

import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class RegisterUser extends BaseTest {
    private Login login = null;
    private Register register = null;

    @Test
    public void registerUser() {

        initTest("Register User");
        driver.get("http://apptest.go.ro:9999/login");
        login = new Login(driver);
        register = new Register(driver);
        login.clickRegisterButton();

        register.setFirstname("Alina");
        register.setLastname("Gidiu");
        register.setEmail("mirsidan.alina@gmail.com");
        register.setPassword("1234");
        register.setPhoneNumber("0752163593");
        register.setCity("Cluj");
        register.trainer();
        register.clickSubmitButton();



        Assert.assertTrue(register.getSingUpText().equalsIgnoreCase("Sign Up"));
    }


}
