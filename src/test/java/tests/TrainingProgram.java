package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import Actions.Training;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class TrainingProgram extends BaseTest {
    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private RegisterUser registerUser = null; // creeam obiectul
    private Training training;

    @Test
    public void openTrainingTab(){
        initTest("Training Program");
        login= new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        registerUser = new RegisterUser();//instantiere de obiect
        training = new Training(driver);

        login();

    }

    private void login() {
        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String email= configLoader.getProperty("email");
        String pas= configLoader.getProperty("password");


        login.enterUserName(email);
        login.enterPassword(pas);
        login.clickSubmitButton();

        dashboard.clickTrainingButton();
        training.clickGenerateProgramButton();


        dashboard.clickLogoutButton();





    }




}

