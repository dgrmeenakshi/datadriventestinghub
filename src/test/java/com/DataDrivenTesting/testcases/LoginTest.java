package com.DataDrivenTesting.testcases;

import com.DataDrivenTesting.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
    @Test
    public void loginAsManager() throws InterruptedException {
        driver.findElement(By.cssSelector(OR.getProperty("bml"))).click();
        Thread.sleep(9000);
    }
}
