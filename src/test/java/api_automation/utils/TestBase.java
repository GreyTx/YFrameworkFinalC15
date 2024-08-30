package api_automation.utils;
import io.cucumber.core.api.Scenario;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Base class for setting up the test environment by loading configuration
 * properties.
 *
 * The `TestBase` class reads the `api-config.properties` file from the
 * specified path and loads its contents into a `Properties` object.
 */
public class TestBase {

	public static Properties property;


	public TestBase() {
		try {
			property = new Properties();
			String path = "src/test/resources/api-config.properties";
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);			
			property.load(fis);
		} catch (IOException e) {				
			e.printStackTrace();
		}
	}



}