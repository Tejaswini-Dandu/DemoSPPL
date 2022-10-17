package com.sppl.browserFactory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {

    public  Browser launchBrowser(String browserName) {
        if (browserName.equals("chrome")) {
            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
            return browser;

        }
        if (browserName.equals("firefox")) {
            Playwright playwright = Playwright.create();
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            return browser;

        }
        return null;
    }
}
