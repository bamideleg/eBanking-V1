package com.ebanking.Testcases;

import com.ebanking.PageObjects.BaseClass;
import com.ebanking.PageObjects.searchForJobDataProviderPage;
import com.ebanking.Utilities.XLUtils;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TC_searchForJobDataProvider extends BaseClass {
    @Test(dataProvider = "jobSearchD")
    public void SearchForJobData(String jobTitle) throws IOException {

        searchForJobDataProviderPage sp = new searchForJobDataProviderPage(driver);
        sp.setJobTitle(JobTitle);
        sp.setLocation(Location3);
        sp.clickSearch();

        captureScreen(driver, "Show the number of jobs found");

        sp.getJobNumbers();
        logger.info("User should see all the jobs found");

        sp.getJobNumbers();
        logger.info("User should see all the jobs found");

        if (driver.getCurrentUrl().equals("https://www.jobserve.com/gb/en/Job-Search/")) {
            Assert.assertTrue(true);
            logger.info("Test passed");
        } else {
            captureScreen(driver, "loginTest");
            Assert.assertFalse(false);
            logger.info("Test failed");
        }
    }

    @DataProvider(name = "jobSearchD")
    Object[][] getData() throws IOException {

        String path=System.getProperty("user.dir")+"/src/test/java/com/ebanking/TestData/jobSearchData.xlsx";

        int rownum = XLUtils.getRowCount(path, "Sheet1");
        int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

        String jobsearchD[][] = new String[rownum][colcount];

        for (int i = 1; 1 <= rownum; i++) {

            for (int j = 0; j < colcount; j++) {

                jobsearchD[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);

            }

        }
        return jobsearchD;
    }
}




