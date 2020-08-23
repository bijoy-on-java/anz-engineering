package com.anz.app;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

/**
 * ANZ Engineering Test Cases: Test Suite.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("ANZ Engineering - Test Suite")
@SelectPackages("com.anz.app")
@IncludePackages({ "com.anz.app.controller", "com.anz.app.service", "com.anz.app.facade" })
public class ANZEngineeringApplicationTestSuite {

}
