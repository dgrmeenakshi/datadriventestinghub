package com.DataDrivenTesting.testcases;

import com.DataDrivenTesting.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
    @Test
    public void loginAsManager() throws InterruptedException {
        log.debug("Inside Login Test");
        driver.findElement(By.cssSelector(OR.getProperty("bml"))).click();
        Thread.sleep(1000);
        log.debug("Logged in Successfully");
    }
}
