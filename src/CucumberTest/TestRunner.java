package CucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/StepDefinition/firstTest.feature"
        ,glue={"src/StepDefinition"}
)

public class TestRunner {
}
