package com.demo.pages.main;

import com.codeborne.selenide.SelenideElement;
import com.demo.pages.BasePage;
import com.demo.pages.auth.SignInPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * PageObject that describes Header panel
 */
public class HeaderPage extends BasePage {

    public HeaderPage() {
        verifyPageLoaded(headerPanel());
    }

    public SignInPage clickSignIn() {
        log("Click Sign In");
        signInLink().click();
        return new SignInPage();
    }

    private SelenideElement headerPanel() {
        return $(By.className("header"));
    }

    private SelenideElement signInLink() {
        return headerPanel().$("a[class*='user-link']");
    }

}
