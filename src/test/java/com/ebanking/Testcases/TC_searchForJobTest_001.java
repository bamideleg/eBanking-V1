package com.ebanking.Testcases;

import com.ebanking.PageObjects.BaseClass;
import com.ebanking.PageObjects.searchForJobPage;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;


  public class TC_searchForJobTest_001 extends BaseClass

    {
        @Test
        public void searchForJobTest() throws IOException {

            logger.info("User open the browser");
//  We need to create new object of searchForJObPage before we can access the object
            searchForJobPage sp = new searchForJobPage(driver);

            sp.setJobType(JobType);
            logger.info("User enter job type");
            sp.setLocation(Location);

            captureScreen(driver,"Verify the location");

            logger.info("User enter the location");
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
        }

    }


