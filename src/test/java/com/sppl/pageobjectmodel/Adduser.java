package com.sppl.pageobjectmodel;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Adduser {
    private Page page;
    Sppllogin sppllogin = new Sppllogin(page);

    public Adduser(Page page) {
        this.page = page;
    }
    public void addUser(){

        sppllogin.userLogin();
        Locator locator= page.locator("//a[@href='/SPPL/en/admin']//ancestor::div[@class='toolbar-tab']");
        locator.dblclick();
        page.locator("//*[@id=\"toolbar-item-administration-tray\"]/nav/div[1]/ul/li[8]/a").hover();
        page.locator("//*[@id=\"toolbar-item-administration-tray\"]/nav/div[1]/ul/li[8]/ul/li[1]/a").click();

    }

}
