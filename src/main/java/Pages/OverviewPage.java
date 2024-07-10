package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utile.ConfigLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OverviewPage {
    private WebDriver driver;
    private By logoutLink = By.linkText("Log Out");
    private By loginButton = By.cssSelector("input[type=\"submit\"].button[value=\"Log In\"]");
    private By confirmLogOut = By.xpath("//*[@id=\"leftPanel\"]/h2");
    private By confirmRequestLoan = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/h1");
    private By confirmUpdateContactInfo = By.xpath("//*[@id=\"updateProfileForm\"]/h1");
    private By confirmFinTransactions = By.xpath("//*[@id=\"formContainer\"]/h1");
    private By confirmBillPay = By.xpath("//*[@id=\"billpayForm\"]/h1");
    private By confirmTransferFunds = By.xpath("//*[@id=\"showForm\"]/h1");
    private By confirmAccountsOverview = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/h1");
    private By confirmOpenNewAccount = By.xpath("//*[@id=\"openAccountForm\"]/h1");



    ConfigLoader configLoader1 = new ConfigLoader("src/test/resources/proprietati/transfer.properties");
    Double amount = Double.valueOf(configLoader1.getProperty("amount"));
    String fromaccount = configLoader1.getProperty("fromaccount");
    String toaccount = configLoader1.getProperty("toaccount");
    String accountnumber = configLoader1.getProperty("fromaccount");


    public OverviewPage(WebDriver driver) {
        this.driver = driver;

    }

    private void clickLink(String linkText)
    {// metoda generate pentru a da click pe un anumit text
        driver.findElement(By.linkText(linkText)).click();
    }

    public void setLogout() {//metoda care nu apeleaza functia de click link

        driver.findElement(logoutLink).click();
    }

    public String confirmLogOut() {
        return driver.findElement(confirmLogOut).getText();

    }

    public TransferPage clickTransferfunds() {//apeleaza click link
        clickLink("Transfer Funds");
        return new TransferPage(driver);
    }

    public OpenAccountPage clickOpenNewAccount() {
        clickLink("Open New Account");
        return new OpenAccountPage(driver);
    }

    public UpdateContactInfoPage clickUpdateContactInfo() {
        clickLink("Update Contact Info");
        return new UpdateContactInfoPage(driver);
    }

    public BillPayPage clickBillPay() {
        clickLink("Bill Pay");
        return new BillPayPage(driver);
    }

    public OverviewPage clickAccountsOverview() {
        clickLink("Accounts Overview");
        return new OverviewPage(driver);
    }

    public FindTransactionsPage clickFindTransactions(){
        clickLink("Find Transactions");
        return new FindTransactionsPage(driver);
    }
    public RequestLoanPage clickRequestLoan(){
        clickLink("Request Loan");
        return new RequestLoanPage(driver);
    }

    public String confirmOpenNewAccount() {
        return driver.findElement(confirmOpenNewAccount).getText();


    }
    public String confirmAccountsOverview() {
        return driver.findElement(confirmAccountsOverview).getText();


    }
    public String confirmTransferFunds() {
        return driver.findElement(confirmTransferFunds).getText();


    }
    public String confirmBillPay() {
        return driver.findElement(confirmBillPay).getText();


    }
    public String confirmFindTransactions() {
        return driver.findElement(confirmFinTransactions).getText();


    }
    public String confirmUpdateContactInfo() {
        return driver.findElement(confirmUpdateContactInfo).getText();


    }
    public String confirmRequestLoan() {
        return driver.findElement(confirmRequestLoan).getText();


    }



    public void waitMethod() {
        try {
            for (int i = 0; i < 5; i++) {

                // it will sleep the main thread for 1 sec
                // ,each time the for loop runs
                Thread.sleep(1000);

                // printing the value of the variable
                System.out.println(i);
            }
        } catch (Exception e) {

            // catching the exception
            System.out.println(e);
        }
    }




    public static Map<String, Double> getAccountBalances(WebDriver driver, String fromaccount, String toaccount) {

        Map<String, Double> balances = new HashMap<>();

        // Find the table rows in the accounts overview

        WebElement accountsTable = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/table/tbody"));

        for (WebElement row : accountsTable.findElements(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/table/tbody/tr[1]"))) {
            WebElement accountNumberElement = row.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]"));
            WebElement balanceElement = row.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[2]"));
            WebElement accountNumberElement2 = row.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[2]/td[1]"));
            WebElement balanceElement2 = row.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[2]/td[2]"));


            String accountNumber = accountNumberElement.getText();
            String balanceText = balanceElement.getText().replace("$", "").replace(",", "");
            String accountNumber2 = accountNumberElement2.getText();
            String balanceText2 = balanceElement2.getText().replace("$", "").replace(",", "");

            // Debug: Print found account details
            System.out.println("Found First Account: " + accountNumber + " with Balance Text: " + balanceText);
            System.out.println("Found Second Account: " + accountNumber2 + " with Balance Text: " + balanceText2);

            if (accountNumber.equals(fromaccount) || accountNumber.equals(toaccount)) {
                try {
                    double balance = Double.parseDouble(balanceText);
                    balances.put(accountNumber, balance);
                } catch (NumberFormatException e) {
                    System.out.println("Failed to parse balance for account: " + accountNumber2 + " with Balance Text: " + balanceText2);
                }

            }
            if (accountNumber2.equals(fromaccount) || accountNumber2.equals(toaccount)) {
                try {
                    double balance2 = Double.parseDouble(balanceText2);
                    balances.put(accountNumber2, balance2);
                } catch (NumberFormatException e) {
                    System.out.println("Failed to parse balance for account: " + accountNumber + " with Balance Text: " + balanceText);
                }

            }
        }

        return balances;
    }



    public static void verifyTransactions(WebDriver driver, String accountNumber) {

        // Găsește tabelul de conturi
        WebElement accountsTable = driver.findElement(By.xpath("//table[@id='accountTable']//tbody"));
        List<WebElement> rows = accountsTable.findElements(By.xpath("//*[@id=\"accountTable\"]/thead/tr"));

        for (WebElement row : rows) {
            WebElement accountNumberElement = row.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]"));
            String accountText = accountNumberElement.getText();

            if (accountText.equals(accountNumber)) {
                // Apasă pe linkul contului pentru a vizualiza detaliile
                accountNumberElement.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/table/tbody/tr[1]/td[1]/a")).click();
                break;
            }
        }


        //WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/table")));

        WebElement transactionTable = driver.findElement(By.xpath("//*[@id=\"transactionTable\"]"));
        List<WebElement> transactionRows = transactionTable.findElements(By.xpath("//*[@id=\"transactionTable\"]/thead/tr"));


        // Afișează detalii despre tranzacții pentru debugging
        System.out.println("Number of transactions found: " + transactionRows.size());
        for (WebElement transactionRow : transactionRows) {
            List<WebElement> cells = transactionRow.findElements(By.xpath("//*[@id=\"transactionTable\"]/tbody/tr[1]/td[2]"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " | ");
            }
            System.out.println();
        }

        // Poți adăuga verificări suplimentare aici, de exemplu, să te asiguri că există tranzacții, că detaliile sunt corecte etc.
        if (transactionRows.size() == 0) {
            System.out.println("No transactions found for account: " + accountNumber);
        }
    }



}







