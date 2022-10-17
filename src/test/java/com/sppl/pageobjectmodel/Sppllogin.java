package com.sppl.pageobjectmodel;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class Sppllogin {
    private final Page page;

    public Sppllogin(Page page){
        this.page=page;
    }
    public void userLogin(){
        page.navigate("http://localhost:8888/SPPL/en/user/login");
        page.locator("//*[@id='edit-name']").type("Tejaswini");
        page.locator("//*[@id='edit-pass']").type("Teju@123");
        page.locator("//*[@id='edit-submit']").click();
        String expected =page.locator("//*[@id='toolbar-item-user']").innerText();
        System.out.println(expected);
        Assert.assertEquals(expected,"Tejaswini");
    }

    public void addUser(){
        userLogin();
        Locator locator= page.locator("//a[@href='/SPPL/en/admin']//ancestor::div[@class='toolbar-tab']");
        locator.dblclick();
        page.locator("//*[@id=\"toolbar-item-administration-tray\"]/nav/div[1]/ul/li[8]/a").hover();
        page.locator("//*[@id=\"toolbar-item-administration-tray\"]/nav/div[1]/ul/li[8]/ul/li[1]/a").click();
    }


}


