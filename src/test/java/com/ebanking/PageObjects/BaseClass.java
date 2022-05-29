package com.ebanking.PageObjects;

import com.ebanking.Utilities.ReadConfig;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

    ReadConfig readconfig=new ReadConfig();

    public String baseUrl=readconfig.getApplicationURL();
    public String JobType=readconfig.getJobType();
    public String Location=readconfig.getLocation();
    public String JobName=readconfig.getjobName();
    public String Location2=readconfig.getLocation2();
    public String JobTitle=readconfig.getJobTitle();
    public String Location3=readconfig.getJobTitle();
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeTest
    public void setup (String br)
    {
        logger= Logger.getLogger("eBanking-V1");
        PropertyConfigurator.configure("log4j.properties");

        if(br.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
            driver=new ChromeDriver();
        }
        else if(br.equals("firefox"))
        {
            System.setProperty("webdriver.firefox.driver",readconfig.getFirefoxPath());
            driver=new FirefoxDriver();

         }else if(br.equals("ie"))
         {
             System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
             driver=new InternetExplorerDriver();
        }
        driver.get(baseUrl);
    }
    @AfterTest
    public void tearDown()
    {

        driver.quit();
    }
    public void captureScreen(WebDriver driver, String tname) throws IOException {
      TakesScreenshot ts = (TakesScreenshot) driver;
      File source = ts.getScreenshotAs(OutputType.FILE);
      File target = new File(System.getProperty("user dir") + "/Screenshots/" + tname + ".png");
      FileUtils.copyFile(source, target);
 //     FileUtils.copyFile(source, target);
      System.out.println("Screenshot taken");

    }




}
