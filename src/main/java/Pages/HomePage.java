package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class HomePage {

    private Wait<WebDriver> wait;
    private WebDriver driver;// trebuie sa avem un obiect care e de tipul clasei

    private By registerLink = By.linkText("Register");
    private By forgotpasswordLink = By.linkText("Forgot login info?");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPage clickRegister() {
        driver.findElement(registerLink).click();
        return new RegisterPage(driver);

    }

    public LookupPage clickForgotPassword(){
        driver.findElement(forgotpasswordLink).click();
        return new LookupPage(driver);
    }





}
