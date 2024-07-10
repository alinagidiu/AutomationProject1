package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class TransferPage {

    private WebDriver driver;
    private Wait<WebDriver> wait;

    private By amountField = By.id("amount");
    private By fromAccountField= By.id("fromAccountId");
    private By toAccountField= By.id("toAccountId");
    private By transferButton = By.cssSelector("input[type=\"submit\"].button[value=\"Transfer\"]");
    private By transferText = By.xpath("//*[@id=\"showResult\"]/h1");




    public TransferPage(WebDriver driver){

        this.driver = driver;
}
    public void enterAmount(String amount) {

        driver.findElement(amountField).sendKeys(amount);
    }
    //private Select findFromAccount(){

    //    return new Select(driver.findElement(fromAccountField));
    //}
   // public void selectFromAccount(String option){
    //    findFromAccount().selectByVisibleText(option);

    //}
     public void selectFromAccount(String option){
         Select fromAccount = new Select(driver.findElement(fromAccountField));
         fromAccount.selectByVisibleText(option);
     }
    //private Select findToAccount(){

    //    return new Select(driver.findElement(toAccountField));
    //}
    //public void selectToAccount(String option){
    //    findToAccount().selectByVisibleText(option);

   // }
   public void selectToAccount(String option){
       Select toAccount = new Select(driver.findElement(toAccountField));
       toAccount.selectByVisibleText(option);
   }

    public void clickTransferButton() {
        driver.findElement(transferButton).click();

    }

    public String transferText(){
        return driver.findElement(transferText).getText();
    }



}
