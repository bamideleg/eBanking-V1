// https://www.youtube.com/watch?v=M4Ye3SKT46g&list=PLUDwpEzHYYLsmuyHqL44P2GqU1FHrutZu
// Selenium Hybrid Framework Part-1 | e-Banking Automation Mini Project
//Selenium Hybrid Framework Part-2 | e-Banking Automation Mini Project
//https://www.youtube.com/watch?v=7cFwCXY2DSg

package com.ebanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class searchForJobPage {

    WebDriver Idriver;

    public searchForJobPage(WebDriver rdriver)
    {
        Idriver=rdriver;
        PageFactory.initElements(rdriver,this); // To initialised pageFactory
    }
    @FindBy(name="ctl00$main$srch$ctl_qs$txtKey")
    @CacheLookup
    WebElement txtJobType;

    @FindBy(name="ctl00$main$srch$ctl_qs$txtLoc")
    WebElement txtLocation;

    @FindBy(name="ctl00$main$srch$ctl_qs$btnSearch")
    WebElement btnSearch;

    @FindBy(css=".cutout2")
    WebElement JobNumber;

 //   @FindBy(name="jjjkjjjk")
 //   WebElement logoutButton;


//  The next step is to write action steps
    public void setJobType(String jobType)
    {
        txtJobType.sendKeys(jobType);
    }
    public void setLocation(String location)
    {
        txtLocation.sendKeys(location);
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

// PageObject for search completed
