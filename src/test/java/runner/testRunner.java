package runner;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue={ "stepDefinition","com.common"},
        plugin = { "json:target/cucumber.json" },
        monochrome = true
)
public class testRunner  {

}
