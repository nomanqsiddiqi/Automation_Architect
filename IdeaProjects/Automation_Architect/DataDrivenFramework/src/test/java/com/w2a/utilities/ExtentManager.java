package com.w2a.utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance(){
        if(extent == null){
            extent = new ExtentReports();
        }

    }
}
