package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateContactInfoPage {

   // private Wait<WebDriver> wait;
    private WebDriver driver;
    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By addressCustomer = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zip = By.id("customer.address.zipCode");
    private By phone = By.id("customer.phoneNumber");
    private By updateprofileButton = By.cssSelector("input[type=\"button\"].button[value=\"Update Profile\"]");
    private By updateText = By.xpath("//*[@id=\"updateProfileResult\"]/h1");
    String [] clearList ={"customer.firstName","customer.lastName","customer.address.street","customer.address.city","customer.address.state","customer.address.zipCode","customer.phoneNumber"};




    public UpdateContactInfoPage(WebDriver driver) {
        this.driver = driver;


    }

    public void clearText() {

        try {
            for (int i = 0; i < 5; i++) {

                // it will sleep the main thread for 1 sec
                // ,each time the for loop runs
                Thread.sleep(1000);

                // printing the value of the variable
                System.out.println(i);
            }
        }
        catch (Exception e) {

            // catching the exception
            System.out.println(e);
        }

        for (int i=0; i<7;i++) {
            WebElement toClear = driver.findElement(By.id(clearList[i]));
            toClear.sendKeys(Keys.CONTROL + "a");
            toClear.sendKeys(Keys.DELETE);
        }
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

    public void clickUpdateProfileButton(){
        driver.findElement(updateprofileButton).click();
    }

    public String getUpdateProfileText(){
        return driver.findElement(updateText).getText();
    }



}
