package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@io.cucumber.testng.CucumberOptions(
        features = "src/test/resorces/features",
        glue ={"stepDef"},
        //        plugin ={"pretty","html:target/cucumber-report-html","json:target/cucumber.json"},
        plugin ={"json:target/cucumber.json"},
        monochrome = true,
        publish = true)

@Test
public class loginPageRunner extends AbstractTestNGCucumberTests
{

}
