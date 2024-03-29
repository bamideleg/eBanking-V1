// How to find xpath: https://www.youtube.com/watch?v=W9_q7tZon2M
package com.ebanking.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchForJobDataProviderPage  extends BaseClass {


    WebDriver Idriver;

    public searchForJobDataProviderPage (WebDriver rdriver)
    {
        Idriver=rdriver;
        PageFactory.initElements(rdriver,this); // To initialised pageFactory
    }

    @FindBy(name="ctl00$main$srch$ctl_qs$txtKey")
    @CacheLookup
    WebElement txtJobTitle;

    @FindBy(name="ctl00$main$srch$ctl_qs$txtLoc")
    WebElement txtLocation3;

    @FindBy(name="ctl00$main$srch$ctl_qs$btnSearch")
    WebElement btnSearch;

    @FindBy(css=".cutout2")
    WebElement JobNumber;

    //   @FindBy(name="jjjkjjjk")
    //   WebElement logoutButton;


    //  The next step is to write action steps
    public void setJobTitle(String JobTitle)
    {
        txtJobTitle.sendKeys(JobTitle);
    }
    public void setLocation(String Location3)
    {
        txtLocation3.sendKeys(Location3);
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
