package com.demo.driver.chrome;

import com.demo.driver.DriverProperties;

/**
 * Define ChromeDriver properties
 */
public interface ChromeProperties extends DriverProperties {

    @Key("driver.path.prop")
    @DefaultValue("webdriver.chrome.driver")
    String driverPathProp();

    @Key("driver.path.value")
    @DefaultValue("libs/chromedriver.exe")
    String driverPathValue();

    @Key("chrome.options.prop")
    @DefaultValue("chromeoptions.args")
    String chromeOptionsProp();

    @Key("chrome.options.value")
    @DefaultValue("--disable-extensions,--disable-infobars")
    String chromeOptionsValue();
}
