package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class LoginInternetBankingPage
{
    WebDriver driver;
    By loginUsingUserId=By.xpath("//input[contains(@title,\"Login using\")]");
    By userId=By.xpath("//input[@title=\"User Id\"]");
    By passWord=By.xpath("//input[@class=\"login-input-password\"]");
    //By startInOption=By.xpath("//select[@id=\"AuthenticationFG.MENU_ID\"]"]");
    By selectoption=By.xpath("//select[@id=\"AuthenticationFG.MENU_ID\"]");
    By remCheckbox=By.xpath("//input[@type=\"checkbox\"][contains(@title,\"Remember\")]");
    By loginBtn=By.xpath(" //input[@type=\"submit\" or @value=\"Login\"]");
    By userIDLoginOption=By.xpath("//img[@id=\"user-id-goahead\"][@onclick=\"goUserId();\"]");
    By errorMSg=By.xpath("//div[@role=\"alert\"]");


   public LoginInternetBankingPage(WebDriver driver)
    {
      this.driver=driver;
    }


    public void loginWithUserNameAndPass()
    {
        driver.findElement(userIDLoginOption).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }
    public void enterUserName(String username)
    {


       // driver.findElement(loginUsingUserId).sendKeys(username);
        driver.findElement(userId).sendKeys(username);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    public void enterPassword(String pass)
    {
        driver.findElement(passWord).sendKeys(pass);
        System.out.println("Password entered as&&&&&&&&&&&&&&&&&&&&&&&&&&&"+pass);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    public void selectStartInOption(String opt)
    {
        WebElement dropdown=driver.findElement(selectoption);
        String js = "arguments[0].style.display='block'";
        ((JavascriptExecutor) driver).executeScript(js, dropdown);
        Select startInOptions=new Select(dropdown);
        startInOptions.selectByVisibleText(opt);
        System.out.println("Option is as********************************");
    }

    public void rememberUserIdChkbox()
    {
        driver.findElement(remCheckbox).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    public void  clickonLoginBtn()
    {
        driver.findElement(loginBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));

    }

    public String navigatedtobankingPage()
    {
       // String internetPageURL=driver.getCurrentUrl();
        String internetPageTitle=driver.getTitle();
        System.out.println("Inter net Page Title is****************"+internetPageTitle);
        return  internetPageTitle;
    }
   public String checkErrormsg()
   {

       String ActualMsg=driver.findElement(errorMSg).getText();
       System.out.println("Actual Error Msg is*************************"+ActualMsg);
       return ActualMsg;
   }


}
