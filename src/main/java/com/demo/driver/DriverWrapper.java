package com.demo.driver;

import org.openqa.selenium.WebDriver;

/**
 * Define work with driver
 */

public interface DriverWrapper {

    /**
     * Set up driver
     */
    void setUp();

    /**
     * Close driver
     */
    void close();

    /**
     * Open url in current tab
     * @param url, String
     */
    void openUrl(String url);

    /**
     * Get driver instance
     * @return WebDriver
     */
    WebDriver get();
}
