package com.DataDrivenTesting.testcases;

import com.DataDrivenTesting.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BankManagerLoginTest extends TestBase {
    @Test
    public void loginAsManager() throws InterruptedException {
        log.debug("Inside Login Test");
        driver.findElement(By.cssSelector(OR.getProperty("bml"))).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("buttonAC"))),"Element not displayed");
        log.debug("Logged in Successfully");
    }
}
