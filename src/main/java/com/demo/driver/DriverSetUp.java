package com.demo.driver;

/**
 * Define work with drivers set up
 */
public interface DriverSetUp {

    /**
     * Get driver specific properties
     * @return DriverProperties
     */
    DriverProperties properties();

    /**
     * Driver setup procedures
     */
    void setUp();
}
