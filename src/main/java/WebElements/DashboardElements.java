package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardElements {
    private WebDriver driver = null;
    private Wait<WebDriver> wait;


    public DashboardElements(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement userNameDisplay(){
        return driver.findElement(By.cssSelector("#userNameDisplay"));
    }
    public WebElement trainingButton(){
        return driver.findElement(By.cssSelector(".trainings"));
    }
    public WebElement logoutButton() {
        return driver.findElement(By.cssSelector(".logout"));

    }
}

