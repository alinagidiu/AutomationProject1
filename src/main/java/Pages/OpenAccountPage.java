package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class OpenAccountPage {

    private WebDriver driver;
    private By typeaccount = By.id("type");
    private By existingaccount = By.id("fromAccountId");
    private By opennewaccountButton = By.cssSelector("input[type=\"button\"].button[value=\"Open New Account\"]");
    private By accountopenedText = By.xpath("//*[@id=\"openAccountResult\"]/p[1]");

    public OpenAccountPage(WebDriver driver) {
        this.driver=driver;
    }

    private Select findTypeAccountElement(){

        return new Select(driver.findElement(typeaccount));
    }
    public void selectTypeAccount(String option){
        findTypeAccountElement().selectByVisibleText(option);

    }
    public List<String> getSelectedTypeAcountOptions(){// o lista de stringuri deoarece ia toate selectedoptions, frameworkclass
        List<WebElement> selectedElements = findTypeAccountElement().getAllSelectedOptions();//trebuie sa le tinem intr-o lista de webelemente
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());

    }


    public void selectExistingAccount(String account){// metoda pentru a transfera amount
        findExistingAccountElement().selectByVisibleText(account);


    }

    public List<String> getSelectedExistingAccountOptions(){// o lista de stringuri deoarece ia toate selectedoptions, frameworkclass
        List<WebElement> selectedElements = findExistingAccountElement().getAllSelectedOptions();//trebuie sa le tinem intr-o lista de webelemente
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());

    }




    private Select findExistingAccountElement(){
        return new Select(driver.findElement(existingaccount));
    }

    public void clickOpenNewAccountButton(){
        driver.findElement(opennewaccountButton).click();

    }
    public String accountOpenedText(){
         return  driver.findElement(accountopenedText).getText();
    }

}
