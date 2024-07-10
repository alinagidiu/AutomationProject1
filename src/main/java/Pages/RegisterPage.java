package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class RegisterPage {
    private Wait<WebDriver> wait;
    private WebDriver driver;
    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By addressCustomer = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zip = By.id("customer.address.zipCode");
    private By phone = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By userName= By.id("customer.username");
    private By password = By.id("customer.password");
    private By confirmPassword = By.id("repeatedPassword");
    private By registerButton = By.cssSelector("input[type=\"submit\"].button[value=\"Register\"]");
    private By welcomeText = By.cssSelector(".title");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterFirstName(String firstname) {

        driver.findElement(firstName).sendKeys(firstname);
    }
    public void enterLastName(String lastname) {
        driver.findElement(lastName).sendKeys(lastname);

    }
    public void enterAddress(String address) {

        driver.findElement(addressCustomer).sendKeys(address);
    }
    public void enterCity(String city1) {
        driver.findElement(city).sendKeys(city1);


    }
    public void enterState(String state1) {
        driver.findElement(state).sendKeys(state1);
    }
    public void enterZip(String zip1) {
        driver.findElement(zip).sendKeys(zip1);
    }
    public void enterPhone(String ph) {
        driver.findElement(phone).sendKeys(ph);

    }
    public void enterSsn(String ssnnumber) {
        driver.findElement(ssn).sendKeys(ssnnumber);


    }
    public void enterUsername(String username) {
        driver.findElement(userName).sendKeys(username);

    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);


    }
    public void enterConfirmPassword(String pass) {
        driver.findElement(confirmPassword).sendKeys(pass);

    }
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();

    }
    public String welcomeText(){
        return driver.findElement(welcomeText).getText();
    }

}
