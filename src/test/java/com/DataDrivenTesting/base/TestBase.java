package com.DataDrivenTesting.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    @BeforeSuite
    public void setUp() throws IOException {
        if (driver == null) {

            fis = new FileInputStream((System.getProperty("user.dir")) + "//src//main//resources//properties//Config.properties");
            config.load(fis);

            fis = new FileInputStream((System.getProperty("user.dir")) + "//src//main//resources//properties//OR.properties");
            OR.load(fis);
        }
        if (config.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")) + "//src//main//resources//executables//chromedriver.exe");
            driver = new ChromeDriver();
        } else if (config.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "gecko.exe");
            driver = new FirefoxDriver();
        } else if (config.getProperty("browser").equals("InternetExplorer")) {
            System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir")) + "//src//main//resources//executables//IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.get(config.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
