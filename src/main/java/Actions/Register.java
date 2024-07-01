package Actions;

import WebElements.RegisterElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;

public class Register {

    private RegisterElements elements;
    private Wait<WebDriver> wait;

    public Register(WebDriver driver) {
        elements = new RegisterElements(driver);
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public String getSingUpText(){
        return elements.signUpText().getText();
    }

    public void setFirstname(String username){
        wait.until(d->elements.firstName().isDisplayed());
        elements.firstName().sendKeys(username);
    }
    public void setLastname(String lastname) {
        elements.lastName().sendKeys(lastname);
    }
    public void setPhoneNumber(String phoneNumber) {
        elements.phoneNumber().sendKeys(phoneNumber);
    }
    public void setEmail(String email) {
        elements.email().sendKeys(email);
    }
    public void setPassword(String password) {
        elements.password().sendKeys(password);
    }
    public void setCity(String city) {
        elements.city().sendKeys(city);
    }
    public void customer(){
        elements.customer().click();
    }
    public void trainer(){
        elements.trainer().click();
    }

    public void clickSubmitButton() {
        elements.submit().click();
    }

    public void registerUser (boolean isTrainer){
        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String firstName= configLoader.getProperty("firstname");
        String lastName= configLoader.getProperty("lastname");
        String email= configLoader.getProperty("email");
        String pas= configLoader.getProperty("password");
        String phone= configLoader.getProperty("phoneNumber");
        String city= configLoader.getProperty("city");


        setFirstname(firstName);
        setLastname(lastName);
        setEmail(email);
        setPassword(pas);
        setPhoneNumber(phone);
        setCity(city);

        if(isTrainer){
        trainer();

    }else {
        customer();
    }
        clickSubmitButton();
        }

}
