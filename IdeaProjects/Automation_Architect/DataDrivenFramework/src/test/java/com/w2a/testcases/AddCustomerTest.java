package com.w2a.testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Test(dataProvider = "getData")
    public void addCustomer(String firstName, String lastName, String postalCode, String alerttext){
        log.debug("----Start the Add Customer Test----");
        driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
        log.debug("----Add Customer page opened----");
        driver.findElement(By.cssSelector(OR.getProperty("firstName"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(OR.getProperty("lastName"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(OR.getProperty("postalCode"))).sendKeys(postalCode);
        driver.findElement(By.cssSelector(OR.getProperty("addCusRec"))).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        try {
            Assert.assertTrue(alert.getText().contains(alerttext));
            log.debug("----New Customer Record added Successfully----");
        }catch (Throwable e){
            log.debug("----Failed to add new customer----");
        }
        alert.accept();
        Assert.fail("Customer not added successfully");
    }

    @DataProvider
    public Object[][] getData(){
        String sheetName = "AddCustomerTest";
    int rows = excel.getRowCount(sheetName);
    int cols = excel.getColumnCount(sheetName);
    Object[][] data = new Object[rows-1][cols];
        for (int rowNum = 2; rowNum <=rows ; rowNum++) {
            for (int colNum = 0; colNum <cols ; colNum++) {
                data[rowNum - 2][colNum]= excel.getCellData(sheetName, colNum, rowNum);
            }
        }
        return data;
    }
}
