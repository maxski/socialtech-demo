package com.demo.pages.auth;

import com.codeborne.selenide.SelenideElement;
import com.demo.pages.BasePage;
import com.demo.pages.account.ProfilePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * PageObject that describes Sign Up modal
 */
public class SignUpPage extends BasePage {

    public SignUpPage() {
        verifyPageLoaded(signUpForm());
    }

    public SignUpPage typeName(String name) {
        log("Type name: " + name);
        nameInput().val(name);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        log("Type email: " + email);
        emailInput().val(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        log("Type password: " + password);
        passwordInput().val(password);
        return this;
    }

    public ProfilePage clickSignUp() {
        log("Click Sign Up");
        signUpButton().click();
        return new ProfilePage();
    }

    private SelenideElement signUpForm() {
        return $(By.id("signup_form"));
    }

    private SelenideElement nameInput() {
        return signUpForm().$(By.name("title"));
    }

    private SelenideElement emailInput() {
        return signUpForm().$(By.name("login"));
    }

    private SelenideElement passwordInput() {
        return signUpForm().$(By.name("password"));
    }

    private SelenideElement signUpButton() {
        return signUpForm().$("button.btn-link-i");
    }


}
