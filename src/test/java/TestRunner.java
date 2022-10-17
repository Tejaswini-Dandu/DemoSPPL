import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "com.sppl","classpath/MyStepdefs","classpath/CreateUser"

        },
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:test-output/cucumber-report/cucumber.json",
                "html:test-output/cucumber-report/cucumber.html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true,dryRun = false,tags = ("@brokenlink")


)
@Test
public class TestRunner extends AbstractTestNGCucumberTests {


}
