package com.demo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Reporter;


/**
 * Parent page that contains generic methods
 */
public abstract class BasePage {
    private static long pageLoadTimeout;

    public static void setPageLoadTimeout(long timeout) {
        pageLoadTimeout = timeout;
    }

    public void log(String text) {
        Reporter.log("[" + getClass().getSimpleName() + "] " + text, true);
    }

    protected void verifyPageLoaded(SelenideElement element) {
        verifyPageLoaded(element, pageLoadTimeout);
    }

    protected void verifyPageLoaded(SelenideElement element, long timeoutMs) {
        element.waitUntil(Condition.visible, timeoutMs);
    }


}
