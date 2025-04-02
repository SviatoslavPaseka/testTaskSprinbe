package com.interviewTestApp.dataProviders;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object[][] {
                {"John", "Doe", 28},   // Data set 1
                {"Jane", "Smith", 34}, // Data set 2
                {"Michael", "Johnson", 45} // Data set 3
        };
    }
}
