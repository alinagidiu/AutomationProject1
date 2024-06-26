package Actions;

import WebElements.LoginElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    private LoginElements element;
    public Login(WebDriver driver) {
        this.element = new LoginElements(driver);
    }

    public void clickRegisterButton(){
        element.registerButton().click();
    }


}
