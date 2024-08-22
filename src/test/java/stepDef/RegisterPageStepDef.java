package stepDef;

import Helper.Helper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import pages.LoginPage;

import java.time.Duration;

public class RegisterPageStepDef {

    private WebDriver driver;
    private LoginPage lpage;
    private Helper   hpage;


    @Before
    public void setup() {
         String BrowserName=System.getProperty("browser");
         System.out.println("Browser is**********************************"+BrowserName);

         if(BrowserName.equalsIgnoreCase("Chrome"))
        {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--REmote-allow-origins=*");
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            //System.setProperty("webDriver.chrome.driver", "C://Nilofar//chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "C://Nilofar//chromedriver.exe");
            driver = new ChromeDriver(options);
        }
    }

    @After
    public void tearDown() {
        if (driver != null)
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
            driver.quit();
        System.out.println("Open successfully");
    }

    @Given("I am on banking website")
    public void i_am_on_banking_website() {
       String env= System.getProperty("testEnv");
        System.out.println("Test Env is **************="+env);
        driver.get(env);
        //driver.get("https://www.icicibank.com/online-services/generate-password-personal?ITM=nli_personalb_new_user_desktop_login_btn");
        driver.manage().window().maximize();
        lpage=new LoginPage(driver);
        hpage.captureScreenshot(driver);
    }


    @Given("mouseover on login tab.")
    public void mouseoverOnLoginTab() {
       lpage.selectLoginOptionsmenu();
        hpage.captureScreenshot(driver);

    }

    @When("click on personal link")
    public void clickOnPersonalLink()
    {
           lpage.selectloginoption(hpage);

    }

    @Then("nagivate to Internet banking login page")
    public void nagivateToInternetBankingLoginPage()
    {
        String ExpectedTitle="Log in to Internet Banking";
        String actualtitle=lpage.navigatetoLoginPage();
        Assert.assertEquals(actualtitle,ExpectedTitle);
        System.out.println("Navigated successfully");
        hpage.captureScreenshot(driver);

    }
}