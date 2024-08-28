package stepDef;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resorces/features",
        glue ={"stepDef"},
        //plugin ={"pretty","html:target/cucumber-report-html","json:target/cucumber.json"},
        plugin ={"json:target/cucumber.json"},
        //tags = "@RunOnly",

        monochrome = true,
        publish = true

)

public class ParallelRun extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}
