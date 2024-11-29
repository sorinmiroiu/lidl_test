import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features",  // Path to your feature files
        glue = {"steps", "hooks"},
        monochrome = true,  // Path to your step definition classes
        tags = "@NegativeLogin or @PositiveLogin",
        plugin = {"pretty", "html:target/cucumber-reports"}  // Cucumber reporting
)
public class TestRunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
