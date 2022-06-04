package com.ebanking.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.print.attribute.standard.JobName;

public class searchForJobPage_002 extends BaseClass
{

    WebDriver Idriver;

    public searchForJobPage_002(WebDriver rdriver)
    {
        Idriver=rdriver;
        PageFactory.initElements(rdriver,this); // To initialised pageFactory
    }
    @FindBy(name="ctl00$main$srch$ctl_qs$txtKey")
    @CacheLookup
    WebElement txtJobName;

    @FindBy(name="ctl00$main$srch$ctl_qs$txtLoc")
    WebElement txtLocation;

    @FindBy(name="ctl00$main$srch$ctl_qs$btnSearch")
    WebElement btnSearch;

    @FindBy(css=".cutout2")
    WebElement JobNumber;

    //   @FindBy(name="jjjkjjjk")
    //   WebElement logoutButton;


    //  The next step is to write action steps
    public void setJobName(String JobName)
    {
        txtJobName.sendKeys(JobName);
    }
    public void setLocation(String Location2)
    {
        txtLocation.sendKeys(Location2);
    }
    public void clickSearch()
    {
        btnSearch.click();
    }
    public void getJobNumbers()
    {
        String jobCount = JobNumber.getText();
        System.out.println(jobCount);
    }
}

// PageObject for search complete



