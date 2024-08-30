package api_automation.utils;

import io.cucumber.core.api.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Utility class for logging messages to both Cucumber reports and log files.
 *
 * Provides methods to log responses, HTTP status codes, and general messages
 * during test execution.
 */
public class LoggingUtils {

      static final Logger logger = LoggerFactory.getLogger(LoggingUtils.class);


    public static void logResponse(Scenario scenario, String response) {
        scenario.write("The response body is \n" + response);
        logger.info("Logged response to Cucumber report: " + response);
    }

    public static void log(Scenario scenario, String message) {
        scenario.write(message);
        logger.info(message);
    }

    public static void logHttpCOde(Scenario scenario, int message) {
        scenario.write("The http status code " + message);
        logger.info("http code " + message);
    }

    public static void logMessageLogfile(String message) {
        logger.info( message);
    }
}
