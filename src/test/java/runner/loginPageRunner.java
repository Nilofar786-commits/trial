package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@io.cucumber.testng.CucumberOptions(
        features = "src/test/resorces/features",
        glue ={"stepDef","MyHooks"},
        //plugin ={"pretty","html:target/cucumber-report-html","json:target/cucumber.json"},
        plugin ={"json:target/cucumber.json"},
       // tags = "@NegativeTest",

        monochrome = true,
        publish = true
       )

@Test
public class loginPageRunner extends AbstractTestNGCucumberTests
{


}
