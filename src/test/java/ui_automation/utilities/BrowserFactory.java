package ui_automation.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserFactory {
        public static WebDriver createInstance() {

            WebDriver driver = null;

            try {
                if (driver == null) {
                    if(System.getProperty("browser")==null){
                        driver = new ChromeDriver();
                        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                        chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\Downloads");
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--ignore-ssl-errors=yes");
                        options.addArguments("--ignore-certificate-errors");
                        options.setExperimentalOption("prefs", chromePrefs);
                        driver = new ChromeDriver(options);
                    }
                    else {
                        switch (System.getProperty("browser")) {
                            case "chrome-headless":

                                driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
                                break;
                            case "chromeRemote":
                                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                                chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\Downloads");
                                ChromeOptions chrOptions = new ChromeOptions();
                                chrOptions.addArguments("--ignore-ssl-errors=yes");
                                chrOptions.addArguments("--ignore-certificate-errors");
                                chrOptions.setExperimentalOption("prefs", chromePrefs);
                                try {
                                    driver = new RemoteWebDriver(new URL("http://54.224.48.204:4444/wd/hub"), chrOptions);
                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case "firefox":
                                driver = new FirefoxDriver();
                                break;
                            case "firefox-headless":
                                driver = new FirefoxDriver(new FirefoxOptions().addArguments("--headless"));
                                break;
                            case "firefoxRemote":
                                FirefoxOptions firOptions = new FirefoxOptions();
                                try {
                                    driver = new RemoteWebDriver(new URL("http://54.224.48.204:4444/wd/hub"), firOptions);
                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case "ie":
                                if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                                    throw new WebDriverException("Your operating system does not support the requested browser");
                                }

                                driver = new InternetExplorerDriver();
                                break;

                            case "edge":
                                if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                                    throw new WebDriverException("Your operating system does not support the requested browser");
                                }
                                driver = new EdgeDriver();
                                break;

                            case "safari":
                                if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                                    throw new WebDriverException("Your operating system does not support the requested browser");
                                }
                                driver = new SafariDriver();
                                break;
                            default:
                                driver = new ChromeDriver();
                                break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return driver;
        }
    }