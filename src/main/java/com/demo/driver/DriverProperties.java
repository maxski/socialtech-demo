package com.demo.driver;

import org.aeonbits.owner.Config;

/**
 * Define driver properties
 */
public interface DriverProperties extends Config {

    @Key("driver.path.prop")
    String driverPathProp();

    @Key("driver.path.value")
    String driverPathValue();

    @Key("report.folder")
    @DefaultValue("target/surefire-reports")
    String reportFolder();
}
