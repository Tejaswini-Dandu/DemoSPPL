package com.sppl.testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.sppl.browserFactory.BrowserFactory;
import com.sppl.pageobjectmodel.Adduser;
import com.sppl.pageobjectmodel.Sppllogin;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CreateUser {
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

    @Given("Check Add user page")
    public void checkAddUserPage(){
    sppllogin.addUser();
    }

    @And("check on Admin checkbox under Roles")
    public void checkOnAdminCheckboxUnderRoles() {
        page.locator("//*[@id=\"edit-roles-administrator\"]").click();

    }

    @And("Enter all required fields")
    public void enterAllRequiredFields() throws InterruptedException {
        page.locator("//*[@id=\"edit-mail\"]").fill("testuser@mail.com");
        page.locator("//*[@id=\"edit-name\"]").fill("Testuser");
        page.locator("//*[@id=\"edit-pass-pass1\"]").fill("Tejaswini@2022");
        Thread.sleep(5000);
        page.locator("//*[@id=\"edit-pass-pass2\"]").fill("Tejaswini@2022");
        Thread.sleep(5000);
    }

    @Then("Click on create new account")
    public void clickOnCreateNewAccount() throws Exception {
        page.locator("//*[@id=\"edit-submit\"]").click();
        System.out.println(page.locator("//div[@role='contentinfo']").textContent());
        try{
            assertThat(page.locator("//div[@role='contentinfo']")).hasText("Created a new user account for Testuser. No email has been sent.");
        }catch (Exception e){
            deleteUser();
            throw new Exception("Assertion error");
        }


    }
    @After("@createuser")
   public void deleteUser(){
        System.out.println("hi i am delete");
        page.locator("//*[@id=\"toolbar-item-administration-tray\"]/nav/div[1]/ul/li[8]/a").click();
        page.locator("//*[@id=\"edit-user\"]").fill("testuser");
        page.locator("//*[@id=\"edit-submit-user-admin-people\"]").click();
        String  expectedText=page.locator("//*[@id=\"views-form-user-admin-people-page-1\"]/table/tbody/tr/td[2]").
                textContent();

        Assert.assertEquals(expectedText.trim().equalsIgnoreCase("testuser"),true);
        page.locator("//*[@id=\"edit-user-bulk-form-0\"]").click();
        page.locator("//*[@id=\"views-form-user-admin-people-page-1\"]/table/tbody/tr/td[7]/div/div/ul/li/a").click();
        page.locator("//*[@id=\"edit-delete\"]").click();
    }
}
