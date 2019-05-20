package com.demo.pages.account;

import com.codeborne.selenide.SelenideElement;
import com.demo.pages.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * PageObject that describes Profile page
 */
public class ProfilePage extends BasePage {

    public ProfilePage() {
        verifyPageLoaded(contentPanel());
    }

    public void awaitConfirmation() {
        confirmMessagePanel().isDisplayed();
    }

    public String getEmailText() {
        emailLabel().isDisplayed();
        String text = emailLabel().text();
        log("Email text: " + text);
        return text;
    }

    private SelenideElement contentPanel() {
        return $(By.name("profile-content"));
    }

    private SelenideElement confirmMessagePanel() {
        return $(By.id("message_confirm"));
    }

    private SelenideElement emailLabel() {
        return $(By.xpath("(//div[@class='profile-info-l-i-text'])[2]"));
    }

}
