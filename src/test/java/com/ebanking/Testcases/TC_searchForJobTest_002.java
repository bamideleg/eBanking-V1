package com.ebanking.Testcases;

import com.ebanking.PageObjects.BaseClass;
import com.ebanking.PageObjects.searchForJobPage;
import com.ebanking.PageObjects.searchForJobPage_002;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.print.attribute.standard.JobName;


public class TC_searchForJobTest_002 extends BaseClass

  {
      @Test
      public void searchForJob_002() {


          logger.info("User open the browser");

          searchForJobPage_002 sp = new searchForJobPage_002(driver);
          sp.setJobName(JobName);
          logger.info("User enter job type");
          sp.setLocation(Location2);
          logger.info("User enter the location");
          sp.clickSearch();

          sp.getJobNumbers();
          logger.info("User should see all the jobs found");

          if (driver.getCurrentUrl().equals("https://www.jobserve.com/gb/en/Job-Search/")) {
              Assert.assertTrue(true);
              logger.info("Test passed");
          } else {
              Assert.assertFalse(false);
              logger.info("Test failed");
          }
      }
  }

