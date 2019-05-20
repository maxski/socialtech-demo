package com.demo.tests;

import com.demo.driver.DriverWrapper;
import com.demo.driver.SelenideDriverWrapper;
import com.demo.pages.AppProperties;
import com.demo.pages.BasePage;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


/**
 * Parent test that responsible to prepare browser/test context before tests
 * And close browser/context after tests
 */
public class BaseTest {

    protected DriverWrapper driver;
    protected AppProperties props;

    @BeforeSuite
    public void beforeSuite(){
        props = ConfigFactory.create(AppProperties.class
                , System.getProperties()
                , System.getenv()
        );
        driver = driverFactory();
        BasePage.setPageLoadTimeout(props.pageLoadTimeout());
    }


    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        driver.close();
    }

    private DriverWrapper driverFactory() {
        return new SelenideDriverWrapper();
    }
}

