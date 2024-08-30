package api_automation.stepDefinition;
import api_automation.utils.LoggingUtils;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * Hooks class manages the setup and teardown actions for each scenario.
 *
 * It initializes the {@link Scenario} object before each test and logs the
 * start and end of each test using {@link LoggingUtils}.
 */
public class Hooks {

    private static Scenario scenario;

    @Before
    public void setUp(Scenario scenario) {
        Hooks.scenario = scenario;
        LoggingUtils.log(scenario, "Test started " + scenario.getName());
    }

    public static Scenario getScenario() {
        return scenario;
    }

    @After
    public void afterTest() {
        LoggingUtils.log(scenario, "Test ended " + scenario.getName());
    }

}
