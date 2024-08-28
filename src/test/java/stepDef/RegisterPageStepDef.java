package stepDef;

import Helper.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginInternetBankingPage;
import pages.LoginPage;

public class RegisterPageStepDef {

    private WebDriver driver;
    private LoginPage lpage;
    private Helper   hpage;
    private LoginInternetBankingPage lBakingPage;
    public io.cucumber.java.Scenario scenario;
    private MyHooks mhooks;

   public RegisterPageStepDef(MyHooks mhooks)
   {
       this.mhooks=mhooks;
       driver= mhooks.driver;
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
       // hpage.attcheScreenshot(driver);
       // byte[] sr2=hpage.attcheScreenshot(driver,scenario);
        //sc.attach(sr2,"image/png","Screenshot Attached");

        System.out.println("Screenshot attached to Report **************="+env);

    }


    @Given("mouseover on login tab.")
    public void mouseoverOnLoginTab() {
       lpage.selectLoginOptionsmenu(hpage);
        hpage.captureScreenshot(driver);
        //hpage.attcheScreenshot(driver);
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
        //hpage.attcheScreenshot(driver);

    }




    }


