package com.demo.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.demo.driver.chrome.ChromeDriverSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import static com.codeborne.selenide.Selenide.open;

public class SelenideDriverWrapper implements DriverWrapper {

    private DriverSetUp driverSetUp;

    public SelenideDriverWrapper() {
        setUp();
    }

    @Override
    public void setUp() {
        Reporter.log("Init browser: " + Configuration.browser, true);
        driverSetUpFactory().setUp();
        setReportsFolder(driverSetUpFactory().properties().reportFolder());
    }

    @Override
    public void close() {
        Reporter.log("Close browser");
        Selenide.close();
    }

    @Override
    public void openUrl(String url) {
        Reporter.log("Open url: " + url, true);
        open(url);
    }

    @Override
    public WebDriver get() {
        return WebDriverRunner.getWebDriver();
    }

    private void setReportsFolder(String path) {
        Configuration.reportsFolder = path;
    }

    private DriverSetUp driverSetUpFactory() {
        if (driverSetUp == null) {
            if (WebDriverRunner.isChrome()) {
                driverSetUp = new ChromeDriverSetUp();
            }
        }
        return driverSetUp;
    }
}
