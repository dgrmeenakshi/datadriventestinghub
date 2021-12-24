package com.DataDrivenTesting.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/* Parent class for all the testcases where we'll initiallize
WebDriver, Properties , DB, reports, Excel
**/
public class TestBase {

    public static WebDriver driver = null;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");

    @BeforeSuite
    public void setUp() throws IOException {
        if (driver == null) {

            fis = new FileInputStream((System.getProperty("user.dir")) + "//src//main//resources//properties//Config.properties");
            config.load(fis);
            log.debug("Config File loaded !!");

            fis = new FileInputStream((System.getProperty("user.dir")) + "//src//main//resources//properties//OR.properties");
            OR.load(fis);
            log.debug("Object Repo File loaded !!");
        }
        if (config.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")) + "//src//main//resources//executables//chromedriver.exe");
            driver = new ChromeDriver();
            log.debug("chrome launched !!");
        } else if (config.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "gecko.exe");
            driver = new FirefoxDriver();
        } else if (config.getProperty("browser").equals("InternetExplorer")) {
            System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir")) + "//src//main//resources//executables//IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.get(config.getProperty("url"));
        log.debug("Navigate to "+ config.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.debug("Test execution completed !!!");
        }
    }
}
