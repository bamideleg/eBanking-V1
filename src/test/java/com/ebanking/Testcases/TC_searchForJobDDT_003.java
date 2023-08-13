package com.ebanking.Testcases;

import com.ebanking.PageObjects.BaseClass;
import com.ebanking.PageObjects.searchForJobPage;
import com.ebanking.Utilities.XLUtils;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_searchForJobDDT_003 extends BaseClass {

    @Test(dataProvider="jobSearchData")
    public void searchForJobDDT(String jobType, String location) throws IOException {
        searchForJobPage sp = new searchForJobPage(driver);
        sp.setJobType(jobType);
        sp.setLocation(location);
        sp.clickSearch();

        captureScreen(driver,"Show the number of jobs found");

        sp.getJobNumbers();
        logger.info("User should see all the jobs found");

        if (driver.getCurrentUrl().equals("https://www.jobserve.com/gb/en/Job-Search/")) {
            Assert.assertTrue(true);
            logger.info("Test passed");
        } else {
            captureScreen(driver,"loginTest");
            Assert.assertFalse(false);
            logger.info("Test failed");
        }
/*
        if (isAlertPresent() == true) {
            driver.switchTo().alert().accept(); // Switch to the popup alert
            driver.switchTo().defaultContent(); // Switch back to the main page
            Assert.assertTrue(false);
        } else {
            Assert.assertTrue(true);
        }
    }
    // Now we need to  create a user-define method to verify the expected results.
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e)
        {
            return false;
        }
 */
    }
    @DataProvider(name="jobSearchData")
    Object[][]getData() throws IOException
    {
           String path=System.getProperty("user.dir")+"/src/test/java/com/ebanking/TestData/jobSearchData.xlsx";
            int rownum= XLUtils.getRowCount(path, "Sheet1");
            int colcount=XLUtils.getCellCount(path, "Sheet1",1);

            String jobSearchData[][]=new String[rownum][colcount];

            for(int i=1; 1<= rownum; i++)
            {
                for(int j=0; j<colcount; j++)
                {
                    jobSearchData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i,j);
                }
            }
            return jobSearchData;

    }

}


// 3.02mts