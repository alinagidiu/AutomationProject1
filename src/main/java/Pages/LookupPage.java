package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LookupPage {
    private WebDriver driver;
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By addressCustomer = By.id("address.street");
    private By city = By.id("address.city");
    private By state = By.id("address.state");
    private By zip = By.id("address.zipCode");
    private By ssn = By.id("ssn");
    private By findmyloginButton = By.xpath("//*[@id=\"lookupForm\"]/table/tbody/tr[8]/td[2]/input");
    private By lookupText = By.xpath("//*[@id=\"rightPanel\"]/p[1]");



    public LookupPage(WebDriver driver) {
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

    public void enterSsn(String ssnnumber) {
        driver.findElement(ssn).sendKeys(ssnnumber);
    }

    public void clickFindmyloginButton() {
        driver.findElement(findmyloginButton).click();

    }

    public String lookupText(){
        return driver.findElement(lookupText).getText();
    }
}


