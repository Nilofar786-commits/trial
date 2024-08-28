package stepDef;

import Helper.Helper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import pages.LoginInternetBankingPage;

import java.time.Duration;

public class MyHooks  {


    protected WebDriver driver;
    public Helper   hpage;
    public LoginInternetBankingPage lBakingPage;

    @Before
    public void setup(Scenario scenario) {
       String BrowserName=System.getProperty("browser");
        //String BrowserName="Chrome";
        System.out.println("Browser is**********************************"+BrowserName);


        if(BrowserName.equalsIgnoreCase("Chrome"))
        {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--REmote-allow-origins=*");
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            System.setProperty("webdriver.chrome.driver", "C://Nilofar//chromedriver.exe");
            driver = new ChromeDriver(options);


            //hpage=new Helper(scenario);
            Helper.scenario=scenario;
        }


    }
/*
@AfterStep
    public void takeScreenshotAfterEachStep(Scenario scenario)
    {
        Helper.scenario=scenario;
        hpage.captureScreenshot(driver);
        System.out.println("After each scenario screenshot captured:************************");
    }*/

    @After
    public void tearDown()
    {

        //hpage.attcheScreenshot(driver,scenario);
        //sc.attach(sr2,"image/png","Screenshot Attached");
        if (driver != null)
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.quit();
        System.out.println("Close successfully");
    }


}
