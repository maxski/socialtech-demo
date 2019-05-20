package com.demo.pages.auth;

import com.codeborne.selenide.SelenideElement;
import com.demo.pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

/**
 * PageObject that describes Sign In modal
 */
public class SignInPage extends BasePage {

    public SignInPage() {
        verifyPageLoaded(signInButton());
    }

    public SignUpPage clickSingUp() {
        log("Click Sign Up");
        signUpLink().followLink();
        return new SignUpPage();
    }

    private SelenideElement signInButton() {
        return $("button[class*='login-button']");
    }

    private SelenideElement signUpLink() {
        return $("a[class*='register-link']");
    }

}
