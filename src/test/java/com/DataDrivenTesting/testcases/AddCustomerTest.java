package com.DataDrivenTesting.testcases;

import com.DataDrivenTesting.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Test(dataProvider = "data-provider")
    public void addCustomer(String firstName, String lastName, String postCode) {
        driver.findElement(By.cssSelector(OR.getProperty("textBoxFirstname"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(OR.getProperty("textBoxLastName"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(OR.getProperty("textBoxPostCode"))).sendKeys(postCode);
        driver.findElement(By.cssSelector(OR.getProperty("buttonSubmitAddCustomer"))).submit();
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataprovider()  {
        String sheetName = "TestData";
        int rows = excelReader.getRowCount(sheetName);
        int col = excelReader.getColumnCount(sheetName);
        Object[][] data = new Object[rows - 1][col];

        for (int rownum = 2; rownum < rows; rownum++) {
            for (int colnum = 0; colnum < col; colnum++) {
                data[rownum - 2][colnum] = excelReader.getCellData(sheetName, colnum, rownum);
            }
        }
        return data;

    }
}
