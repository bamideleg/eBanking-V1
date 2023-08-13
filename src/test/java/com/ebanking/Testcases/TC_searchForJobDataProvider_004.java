
//Apache POI Tutorial Part10 - Data Driven Testing in Selenium | TestNG DataProvider and Excel
// https://www.youtube.com/watch?v=1nP9UlwzpgU&t=2032s

package com.ebanking.Testcases;

import com.ebanking.PageObjects.BaseClass;
import com.ebanking.PageObjects.searchForJobDataProviderPage;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TC_searchForJobDataProvider_004 extends BaseClass {

    @Test(dataProvider="JobSearchD")
    public void SearchForJobData(String JobTitle, String Location3, String exp) throws IOException {

        searchForJobDataProviderPage sp = new searchForJobDataProviderPage(driver);
        sp.setJobTitle(JobTitle);
        sp.setLocation(Location3);
        sp.clickSearch();

        captureScreen(driver, "Show the number of jobs found");

        sp.getJobNumbers();
        logger.info("User should see all the jobs found");

        sp.getJobNumbers();
        logger.info("User should see all the jobs found");


        String exp_Title = "IT Jobs, Engineering Jobs, Healthcare Jobs… Find your next job with JobServe";
        String act_Title = driver.getTitle();

        if (exp.equals("Valid")) {

            if (exp_Title.equals(act_Title)) {
                Assert.assertTrue(true);
                logger.info("Test passed");
            } else {
                captureScreen(driver, "job search Test");
                Assert.assertFalse(false);
                logger.info("Test failed");
            }

        } else if (exp_Title.equals("Invalid")) {

            if (exp_Title.equals(act_Title)) {
                Assert.assertTrue(false);
                logger.info("Test fail");
            } else {
                Assert.assertTrue(true);
            }

        }

    }

    @DataProvider(name="jobSearchD")
    Object[][] getData() {
       String jobSearchD [][] = {
                            {"QA","London","Valid"},
                            {"BA","Manchester","Invalid"},
                            {"PM","Reading","Valid"},
                            {"IT Support","London","Valid"}

                       };
        // Reading data from excel
        //       String path = ".\\testData\\JobSearchD.xlsx";
        //       XLUtility xlutils = new XLUtility(path);


          return jobSearchD;
    }

    @AfterClass
    public void tearDown()
    {
        driver.close();
    }
}


//  test 123 - push to git
//  test 125 - push to git
//  test 126- push to git
//  test 127- push to git


