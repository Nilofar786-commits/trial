package stepDef;
import Helper.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginInternetBankingPage;

import java.time.Duration;

public class PersonalLoginPageStepDef {

    private LoginInternetBankingPage lBakingPage;
    private WebDriver driver;
    private Helper hpage;
    private MyHooks mhooks;
    private WebDriverWait wait;


    public PersonalLoginPageStepDef(MyHooks mhooks) {
        this.mhooks = mhooks;
        driver = mhooks.driver;
    }

    @Given("I am on internet banking personal login page")
    public void i_am_on_internet_banking_personal_login_page() {

        // System.out.println("Test Env is **************="+env);
        //.get(env);
        driver.get("https://infinity.icicibank.com/corp/AuthenticationController?FORMSGROUP_ID__=AuthenticationFG&__START_TRAN_FLAG__=Y&FG_BUTTONS__=LOAD&ACTION.LOAD=Y&AuthenticationFG.LOGIN_FLAG=1&BANK_ID=ICI&ITM=nli_personalb_personal_login_btn&_gl=1*30xkeg*_ga*MTgzMDcxOTY5Ni4xNjIwMDM5NDU0*_ga_SKB78GHTFV*MTYyODIzNDM4NC43Ny4xLjE2MjgyMzQ1MDQuMjc.&_ga=2.92094746.1084279428.1697432242-1973315115.1690798212&_gac=1.213008672.1697523963.EAIaIQobChMI-7jpvrn8gQMVt6lmAh1nywMHEAAYASAAEgKBxfD_BwE?ITM=nli_personalb_personal_login_btn");
        // driver.get("https://infinity.icicibank.com/corp/AuthenticationController?FORMSGROUP_ID__=AuthenticationFG&__START_TRAN_FLAG__=Y&FG_BUTTONS__=LOAD&ACTION.LOAD=Y&AuthenticationFG.LOGIN_FLAG=1&BANK_ID=ICI&ITM=nli_personalb_personal_login_btn&_gl=1*30xkeg*_ga*MTgzMDcxOTY5Ni4xNjIwMDM5NDU0*_ga_SKB78GHTFV*MTYyODIzNDM4NC43Ny4xLjE2MjgyMzQ1MDQuMjc.&_ga=2.92094746.1084279428.1697432242-1973315115.1690798212&_gac=1.213008672.1697523963.EAIaIQobChMI-7jpvrn8gQMVt6lmAh1nywMHEAAYASAAEgKBxfD_BwE?ITM=nli_personalb_personal_login_btn")
        driver.manage().window().maximize();
        lBakingPage = new LoginInternetBankingPage(driver);
        hpage.captureScreenshot(driver);


    }

    @Given("Click on login with userId and Password tab")
    public void click_on_login_with_userid_and_Password_tab() {

        lBakingPage.loginWithUserNameAndPass();

    }

    @Given("Enter valid Username {string}")
    public void enter_valid_username(String uname) {

        lBakingPage.enterUserName(uname);

    }

    @Given("Enter valid Password {string}")
    public void enter_valid_password(String Password) {
        lBakingPage.enterPassword(Password);
    }

    @Given("Select valid StartIn_options {string}")
    public void select_valid_start_in_options(String option) {
        System.out.println("Statin option as *************" + option);
        lBakingPage.selectStartInOption(option);
    }

    @Given("Click on Remember_User_Id checkbox")
    public void click_on_remember_user_id_checkbox() {
        lBakingPage.rememberUserIdChkbox();
    }

    @When("Click on Login button")
    public void click_on_login_button() {
        hpage.captureScreenshot(driver);
        lBakingPage.clickonLoginBtn();
    }

    @Then("Successfully navigated to internet banking.")
    public void successfully_navigated_to_internet_banking() {
        // String ExpactedURL="https://infinity.icicibank.com/corp/AuthenticationController;jsessionid=00004f98wXjtU-t60ASz-L9ZnT1:R16p8fqpd?bwayparam=4Ggppn79uiWcoUzoRkVltw%3D%3D";
        String ExpactedTitle = "Bank Accounts";
        String ActualURL = lBakingPage.navigatedtobankingPage();
        Assert.assertEquals(ExpactedTitle, ActualURL);
    }


    @And("Enter Username {string}")
    public void enterUsername(String uname) {
        lBakingPage.enterUserName(uname);

    }

    @And("Enter Password {string}")
    public void enterEmptyPassword(String Password) {
        lBakingPage.enterPassword(Password);
    }

    @And("Select StartIn_options {string}")
    public void selectStartIn_options(String option) {
        System.out.println("Statin option as *************" + option);
        lBakingPage.selectStartInOption(option);
    }

    @Then("Received error msg as {string}")
    public void receivedErrorMsgAs(String ErrorMsg) {
        String ExpectedErrorMsg = ErrorMsg;
        System.out.println("Expected Error Msg************************" + ExpectedErrorMsg);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            if (wait.until(ExpectedConditions.alertIsPresent()) != null)
            {
                String actualErrorMsg = driver.switchTo().alert().getText();
                System.out.println("Actual Error Msg************************" + actualErrorMsg);
                Assert.assertEquals(ExpectedErrorMsg, actualErrorMsg);
                driver.switchTo().alert().accept();
                //hpage.captureScreenshot(driver);

            }
        }
        catch (Exception exception)
        {
            System.out.println("Exception is**************888:"+exception);
            String ActualMsg = lBakingPage.checkErrormsg();
            System.out.println("In Then Block**********************");
            Assert.assertEquals(ActualMsg, ExpectedErrorMsg);
            //hpage.captureScreenshot(driver);

        }

    }
}