package com.orangeHRM.pim;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.orangeHRM.pim.DashboardPO;
import pageObject.orangeHRM.pim.LoginPO;
import pageObject.orangeHRM.pim.PageGenerator;
import pageObject.orangeHRM.pim.employee.AddNewEmployeePO;
import pageObject.orangeHRM.pim.employee.EmployeeListPO;
import pageObject.orangeHRM.pim.employee.PersonalDetailsPO;

public class PIM_01_Employee extends BaseTest {
    WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private String employeeID;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);

        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.enterToUsernameTextBox("automationfc");
        loginPage.enterToPasswordTextBox("G7m!k#Pq2$X8zT@3");
        dashboardPage = loginPage.clickToLoginButton();
    }

    @Test
    public void Employee_01_Add_New_Employee(){
        employeeListPage = dashboardPage.clickToPIMPage();
        addNewEmployeePage = employeeListPage.clickToaddEmployeeButton();

        addNewEmployeePage.enterToLastNameTextBox("");
        addNewEmployeePage.enterTolastNameTextBox("");
        employeeID = addNewEmployeePage.getEmployeeID();

        personalDetailsPage = addNewEmployeePage.clicktoSaveButton();
    }

    @Test
    public void Employee_02_Upload_Avatar(){

    }

    @Test
    public void Employee_03_Personal_Details(){

    }


    @Test
    public void Employee_04_Contact_Details(){

    }

    @Test
    public void Employee_05_Emergency_Details(){

    }

    @Test
    public void Employee_06_Dependents(){

    }

    @Test
    public void Employee_07_Immigration(){

    }

    @Test
    public void Employee_08_Jobs(){

    }

    @Test
    public void Employee_09_Salary(){

    }

    @Test
    public void Employee_10_ReportTo(){

    }

    @Test
    public void Employee_11_Qualifications(){

    }

    @Test
    public void Employee_12_(){

    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
