package toDoList;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "toDoList",
//        tags = "@ToDoListActions",
        plugin = {
                "pretty",
                "html:test-output/cucumber-reports/ToDoListExecutionReport.html",
                "json:test-output/cucumber-reports/CucumberTestReport.json",
                "rerun:test-output/cucumber-reports/rerun.txt"
        }
        )

public class RunnerTest {

        private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

   @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

     @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }


}
