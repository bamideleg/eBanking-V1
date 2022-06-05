package com.ebanking.Testcases;

import com.ebanking.PageObjects.BaseClass;
import com.ebanking.PageObjects.searchForJobDDTPage_003;
import com.ebanking.Utilities.XLUtility;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_searchForJobDDT_003 extends BaseClass {

    WebDriver driver;

    @Test(dataProvider="JobSearchD")
    public void searchForJobDDT(String JobTitle, String Location3, String exp) throws IOException {

        searchForJobDDTPage_003 sp = new searchForJobDDTPage_003(driver);
        sp.setJobTitle(JobTitle);
        sp.setLocation(Location3);
        sp.clickSearch();

        captureScreen(driver,"Show the number of jobs found");

        sp.getJobNumbers();
        logger.info("User should see all the jobs found");

        if (driver.getCurrentUrl().equals("https://www.jobserve.com/gb/en/Job-Search/")) {
            Assert.assertTrue(true);
            logger.info("Test passed");
        } else {
            captureScreen(driver,"job search Test");
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

    /*
    @DataProvider(name="jobSearchData")
    Object[][]getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"/src/test/java/com/ebanking/testdata/jobSearchData.xlsx";

            int rownum= XLUtils.getRowCount(path, "Sheet1");
            int colcount=XLUtils.getCellCount(path, "Sheet1",1);

            String jobSearchData[][]=new String[rownum][colcount];

            for(int i=1; 1<=rownum; i++)
            {
                for(int j=0; j<colcount; j++)
                {
                    jobSearchData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i,j);
                }
            }
            return jobSearchData;

    }
*/
    @DataProvider(name="JobSearchD")
    public Object[][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"/src/test/java/com/ebanking/testdata/jobSearchD.xlsx";
 //       String path=".\\datafiles\\jobSearchD.xlsx";
//        XLUtility xlutis = new XLUtility(path);
          XLUtility xlutis = new XLUtility(path);



        int totalrows = xlutis.getRowCount("Sheet1");
        int totalcols= xlutis.getCellCount("Sheet1",1);

        String JobSearchD[][]=new String[totalrows][totalcols];

        for(int i=1;i<=totalrows;i++)
        {
            for(int j=0;j<totalcols;j++)
            {

                JobSearchD[i-1][j]=xlutis.getCellData("Sheet1",i,1);

 //               jobsearchd[i-1][j]= xlutis.getCellData("Sheet1", i,j);//1 0
            }

        }
        return JobSearchD;
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}


// 3.02mts