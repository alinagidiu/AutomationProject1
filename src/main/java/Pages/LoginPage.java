package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;// trebuie sa avem un obiect care e de tipul clasei
    private By userNameField = By.cssSelector("input[name=\"username\"][type=\"text\"]");
    private By passwordField = By.cssSelector("input[name=\"password\"][type=\"password\"]");
    private By loginButton = By.cssSelector("input[type=\"submit\"].button[value=\"Log In\"]");
    private By overviewText = By.cssSelector(".title");
    private By errorText = By.cssSelector(".error");




    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String username){

        driver.findElement(userNameField).sendKeys(username);
    }
    public void setPassword(String password){

        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton(){
         driver.findElement(loginButton).click();
    }

    public String accountsOverviewText(){
        return driver.findElement(overviewText).getText();
    }
    public String errorText(){
        return driver.findElement(errorText).getText();
    }





}
