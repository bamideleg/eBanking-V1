// https://www.youtube.com/watch?v=M4Ye3SKT46g&list=PLUDwpEzHYYLsmuyHqL44P2GqU1FHrutZu
// Selenium Hybrid Framework Part-1 | e-Banking Automation Mini Project

package com.ebanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    WebDriver Idriver;

    public loginPage(WebDriver rdriver)
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

    @FindBy(name="ctl00$main$srch$ctl_qs$txtKey")
    @CacheLookup
    WebElement txtJobName;

    @FindBy(name="ctl00$main$srch$ctl_qs$txtLoc")
    WebElement txtLocation2;

    @FindBy(name="ctl00$main$srch$ctl_qs$btnSearch")
    WebElement btnSearch2;

    @FindBy(css=".cutout2")
    WebElement JobNumber2;


//  The next step is to write action steps
    public void setJobType(String jobT)
    {
        txtJobType.sendKeys(jobT);
    }
    public void setLocation(String loc)
    {

        txtLocation.sendKeys(loc);
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

    public void setTxtJobName(String jobT)
    {
        txtJobType.sendKeys(jobT);
    }
    public void setLocation2(String loc)
    {
        txtLocation.sendKeys(loc);
    }
    public void clickSearch2()
    {
        btnSearch.click();
    }
    public void getJobNumbers2()
    {
        String jobCount = JobNumber.getText();
        System.out.println(jobCount);
    }
}

// PageObject for login completed
