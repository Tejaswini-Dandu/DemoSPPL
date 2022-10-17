package com.sppl.testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.sppl.browserFactory.BrowserFactory;
import com.sppl.pageobjectmodel.Sppllogin;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.checkerframework.framework.qual.RequiresQualifier;
import org.testng.annotations.BeforeClass;

import java.util.List;

public class Brokenlinks {

    BrowserFactory browserFactory=new BrowserFactory();
    Browser browser;
    Page page;
    Sppllogin sppllogin;

    @Before
    public void setUp(){
        browser=browserFactory.launchBrowser("chrome");
        page= browser.newPage();


    }
    @Given("Open homepage")
    public void openHomepage() {
        page.navigate("http://localhost:8888/SPPL/en");
    }

    @And("Get all the links on the page")
    public void getAllTheLinksOnThePage() {
        List allUrls= (List) page.locator("a");

    }

    @Then("Verify broken links")
    public void verifyBrokenLinks() {
    }
}
