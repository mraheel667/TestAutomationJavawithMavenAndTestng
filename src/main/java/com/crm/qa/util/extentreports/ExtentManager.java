package com.crm.qa.util.extentreports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports("./extent-reports/extent-report.html");

    public synchronized static ExtentReports createExtentReports() {
//        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
//        reporter.config().setReportName("Sample Extent Report");
//        extentReports.attachReporter(reporter);
//        extentReports.setSystemInfo("Blog Name", "SW Test Academy");
//        extentReports.setSystemInfo("Author", "Onur Baskirt");
        return extentReports;
    }
}
