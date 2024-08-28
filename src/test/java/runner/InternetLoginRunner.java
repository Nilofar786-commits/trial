package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resorces/features",
        glue={"LoginPageStepDef"},
        monochrome = true,
        plugin = {"json:target/cucumber.json"},
        publish = true
)

@Test
public class InternetLoginRunner extends AbstractTestNGCucumberTests
{

}
