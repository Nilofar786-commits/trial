package Helper;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    //screenshort/frame/windows/alerts/sync issue/java scipt executor

 public static Scenario scenario;
 public Helper(Scenario scenario)
 {
     this.scenario=scenario;
 }

        public static String captureScreenshot(WebDriver driver)
        {

            TakesScreenshot tr=(TakesScreenshot)driver;
            String filepath=System.getProperty("user.dir")+"/Screenshots/Banking_"+getCurrentTime()+".png";
            File sr=  tr.getScreenshotAs(OutputType.FILE);
            byte[] sr1=tr.getScreenshotAs(OutputType.BYTES);
            try {
                FileHandler.copy(sr,new File(filepath));
                System.out.println("Screenshot captured successfully");

            } catch (Exception e) {
                System.out.println("While taking screenshot file is not found:"+e.getMessage());
            }


            scenario.attach(sr1,"image/png","Screenshot Attached");
            return filepath;

        }

      /*  public void attcheScreenshot(WebDriver driver)
        {
            TakesScreenshot tr=(TakesScreenshot)driver;
            String filepath=System.getProperty("user.dir")+"/Screenshots/Banking_"+getCurrentTime()+".png";
           // File sr=  tr.getScreenshotAs(OutputType.FILE);
            byte[] sr1=tr.getScreenshotAs(OutputType.BYTES);
            scenario.attach(sr1,"image/png","Screenshot Attached");

        }*/

        public static String getCurrentTime()
        {
            DateFormat df = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
            Date d = new Date();
            return df.format(d);
        }

}

