package utile;

import Pages.HomePage;
import Pages.OverviewPage;
import Pages.RegisterPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import hometests.LoginTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public WebDriver driver;
    protected HomePage homePage;
    protected OverviewPage overviewPage;
    protected RegisterPage registerPage;
    protected LoginTests loginTest;
    private ExtentTest extentTest;
    private ScreenshotUtils screenshotUtils;


    @BeforeClass
    public void setupClass() {
        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/url.properties");//se face instanta de ConfigLoader
        String url= configLoader.getProperty("url");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//nu mergea selectia de dropdown fara
        screenshotUtils = new ScreenshotUtils(driver);

        driver.get(url);

        homePage = new HomePage(driver);
        overviewPage = new OverviewPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * This method creates the test result
     *
     * @param result
     */
    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureAndSaveFailureScreenshot(result.getMethod().getMethodName());
        }
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test case failed: " + result.getName(), ExtentColor.RED));
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel("Test case passed: " + result.getName(), ExtentColor.GREEN));
        } else {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel("Test case skipped: " + result.getName(), ExtentColor.YELLOW));
        }
    }

    public void initTest(String testName) {
        extentTest = ReportManager.createTest(testName);
    }

    private void captureAndSaveFailureScreenshot(String testName) {
        //We create a new folder, if it doesn't exist
        File screenshotDirectory = new File("screenshots");
        if (!screenshotDirectory.exists()) {
            screenshotDirectory.mkdir();
        }
        // Capture and save screenshot
        screenshotUtils.captureAndSaveScreenshot(testName);
    }

    @AfterSuite
    public void compileReport(){
        ReportManager.getInstance().flush();
    }
    public void initTest1(String testName1) {
        extentTest = ReportManager.createTest(testName1);
    }
}