package com.orangeHRM.pim;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PIM_00_Example extends BaseTest {
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){

    }

    @Description("Description")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void ID_TC_01(){
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
