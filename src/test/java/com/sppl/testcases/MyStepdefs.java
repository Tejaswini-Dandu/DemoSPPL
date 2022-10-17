package com.sppl.testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.sppl.browserFactory.BrowserFactory;
import com.sppl.pageobjectmodel.Sppllogin;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class MyStepdefs  {
    BrowserFactory browserFactory=new BrowserFactory();
    Browser browser;
    Page page;
    Sppllogin sppllogin;
    @Before
    public void setUp(){
         browser=browserFactory.launchBrowser("chrome");
         page= browser.newPage();
         sppllogin=new Sppllogin(page);
    }

    @Given("Naviagte to SPPL page enter credentials and click on login then verify Dashboard page")
    public void naviagteToSPPLPageEnterCredentialsAndClickOnLoginThenVerifyDashboardPage() {
        sppllogin.userLogin();

    }

    @Given("Click on manage")
    public void clickOnManage() throws InterruptedException {
        sppllogin.userLogin();
        Thread.sleep(3000);

       Locator locator= page.locator("//a[@href='/SPPL/en/admin']//ancestor::div[@class='toolbar-tab']");
       locator.dblclick();
    }

    @And("Verify people button is dipslayed and click it")
    public void verifyPeopleButtonIsDipslayedAndClickIt() {
        String expected=page.locator("//*[@id=\"toolbar-item-administration-tray\"]/nav/div[1]/ul/li[8]/a")
                .innerText();
    Assert.assertEquals("People",expected);
    page.locator("//*[@id=\"toolbar-item-administration-tray\"]/nav/div[1]/ul/li[8]/a").hover();
    }

    @And("Click on Add user button")
    public void clickOnAddUserButton() {
        page.locator("//*[@id=\"toolbar-item-administration-tray\"]/nav/div[1]/ul/li[8]/ul/li[1]/a").click();
    }

    @Then("Verify Add user page is displayed")
    public void verifyAddUserPageIsDisplayed() {
        String expectedPageTitle = page.locator("//*[@id=\"block-seven-page-title\"]/h1").innerText();
        Assert.assertEquals("Add user",expectedPageTitle);
    }


}
