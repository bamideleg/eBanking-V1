
// Read data from th Configuration file
package com.ebanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {


    Properties pro;

    public ReadConfig() {

        File src = new File("./Configuration/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is" + e.getMessage());

        }
    }
    public String getApplicationURL() {
        String url = pro.getProperty("baseURL");
        return url;
    }
    public String getJobType() {
        String jobType = pro.getProperty("jobType");
        return jobType;
    }
    public String getLocation() {
        String location = pro.getProperty("location");
        return location;
    }
    public String getChromePath() {
        String chromepath = pro.getProperty("chromepath");
        return chromepath;
    }
    public String getIEPath()
    {
        String iepath = pro.getProperty("iepath");
        return iepath;
    }
    public String getFirefoxPath()
    {
        String firefoxpath= pro.getProperty("firefoxpath");
        return firefoxpath;
    }



    public String getjobName() {
        String jobName = pro.getProperty("jobName");
        return jobName;
    }
    public String getLocation2() {
        String location2 = pro.getProperty("location2");
        return location2;
    }

  }


