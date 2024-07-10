package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;



public class BillPayPage {

    private Wait<WebDriver> wait;
    private WebDriver driver;
    private By payeeName = By.className("payee.name");
    private By address = By.className("payee.address.street");
    private By city = By.className("payee.address.city");
    private By state = By.className("payee.address.state");
    private By zip = By.className("payee.address.zipCode");
    private By phone = By.className("payee.phoneNumber");
    private By account = By.className("payee.accountNumber");
    private By verifyAccount= By.className("verifyAccount");
    private By amount = By.className("amount");
    private By fromAccount = By.className("fromAccountId");
    private By sendPaymentButton = By.cssSelector("input[type=\"button\"].button[value=\"Send Payment\"]");
    private By billPaymentText = By.cssSelector("h1.title");

    public BillPayPage (WebDriver driver) {
        this.driver = driver;
    }
    public void enterPayeeName(String name) {

        driver.findElement(payeeName).sendKeys(name);
    }

    public void enterAddress(String adr) {

        driver.findElement(address).sendKeys(adr);
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

    public void enterAccount (String a) {
        driver.findElement(account).sendKeys(a);

    }

    public void enterVerifyAccount(String account) {
        driver.findElement(verifyAccount).sendKeys(account);


    }
    public void enterAmount(String amount1) {
        driver.findElement(amount).sendKeys(amount1);

    }
    public void enterFromAcount(String account) {
        driver.findElement(fromAccount).sendKeys(account);

    }
    public void clickSendPaymentButton() {
        driver.findElement(sendPaymentButton).click();

    }
    public String billPaymentText(){
        return driver.findElement(billPaymentText).getText();
    }

}



