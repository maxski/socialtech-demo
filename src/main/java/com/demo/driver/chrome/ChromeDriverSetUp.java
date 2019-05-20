package com.demo.driver.chrome;

import com.demo.driver.DriverSetUp;
import org.aeonbits.owner.ConfigFactory;

/**
 * Implementation of DriverSetUp for ChromeDriver
 */
public class ChromeDriverSetUp implements DriverSetUp {

    ChromeProperties properties;

    @Override
    public ChromeProperties properties() {
        if (properties == null) {
            properties = ConfigFactory.create(ChromeProperties.class
                    , System.getProperties()
                    , System.getenv()
            );
        }
        return properties;
    }

    @Override
    public void setUp() {
        System.setProperty(properties().driverPathProp(), properties().driverPathValue());
        System.setProperty(properties().chromeOptionsProp(),properties().chromeOptionsValue());
    }
}
