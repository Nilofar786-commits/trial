package pages;

import Helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    private WebDriver driver;


    //Locators
    By loginoptionsmenu=By.xpath("//span[text()=\"Login\"]");
    //By loginOptions=By.xpath("//a[text()=\"Personal \"]");
    By loginOptions=By.xpath("//a[contains(@data-mob-href,'/') and @data-linktype=\"dropdown link\"]");
    Actions a;

  public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        a=new Actions(driver);
    }

    public void selectLoginOptionsmenu()
    {

        WebElement loptiosmenu=driver.findElement(loginoptionsmenu);
        a.moveToElement(loptiosmenu).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    public void selectloginoption(Helper hpage)
    {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));


       // WebElement loptions=driver.findElement(loginOptions);
        List<WebElement> listOfOptions=driver.findElements(loginOptions);
        for(int i=0;i< listOfOptions.size();i++)
        {
            WebElement el=listOfOptions.get(i);
            String testToClick=el.getAttribute("text");

            System.out.println("Optionssssssssssssssssssssss"+el.getAttribute("text"));
            if(testToClick.equalsIgnoreCase("Personal "))
            {
                System.out.println("Clikinnggggg");

                el.click();
                hpage.captureScreenshot(driver);
                break;

            }
        }

        //loptions.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));

    }
    public String navigatetoLoginPage()
    {
        String title= driver.getTitle();
        System.out.println("title of navigated page is :"+title);
        return title;
    }
}

