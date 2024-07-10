package Actions;

import WebElements.LoginElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class Login {
    private LoginElements element; // trebuie sa avem un obiect care e de tipul clasei LoginElements
    private Wait<WebDriver> wait;


    public Login(WebDriver driver) {
        this.element = new LoginElements(driver);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickRegisterButton(){
        element.registerButton().click();
    }

    public void enterUserName(String userEmail){
        element.userEmail().sendKeys(userEmail);
    }
    public void enterPassword(String password){

        element.userPassword().sendKeys(password);
    }
    public void clickSubmitButton(){
        wait.until(d -> element.submitButton().isDisplayed());
        element.submitButton().click();
    }
    public boolean errorForbiddenAccess(){
        try {
            wait.until(d -> element.errorForbiddenAccess().isDisplayed());
            return element.errorForbiddenAccess().isDisplayed();
        }catch(Exception e) {
            return false;
        }

        }

    }



