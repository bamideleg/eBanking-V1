package com.ebanking.Testcases;

import com.ebanking.PageObjects.BaseClass;
import com.ebanking.PageObjects.loginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_LoginTest_002 extends BaseClass

  {
      @Test
      public void loginTest2() {


          logger.info("User open the browser");

          loginPage lp = new loginPage(driver);
          lp.setTxtJobName(JobType);
          logger.info("User enter job type");
          lp.setLocation(Location);
          logger.info("User enter the location");
          lp.clickSearch();
          lp.getJobNumbers();
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

