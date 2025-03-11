package com.orangeHRM.pim;

import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jsonData.EmployeeInforJson;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
import pojoData.EmployeeInfor;
import utilities.ExcelConfig;

public class PIM_01_Employee extends BaseTest {
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);
        dashboardPage = loginPage.loginSystem(GlobalConstants.USERNAME, GlobalConstants.PASSWORD);
        employeeInfor = EmployeeInfor.getInstance();
        employeeInfor.setFirstName("John");
        employeeInfor.setLastName("Wick");
        /*------------------*/
        employeeInforJson = EmployeeInforJson.getInstance();
        /*-----------------*/
        excelConfig = ExcelConfig.getExcelData();
        excelConfig.switchToSheet("employeeDataExcel");
        firstName = excelConfig.getCellData("FirstName", 1);
        lastName = excelConfig.getCellData("LastName", 1);
    }
    @Description("Add new employee")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Employee_01_Add_New_Employee_By_Object(){
        employeeListPage = dashboardPage.clickToPIMPage();
        addNewEmployeePage = employeeListPage.clickToaddEmployeeButton();
        employeeID = addNewEmployeePage.getEmployeeId();
        personalDetailsPage = addNewEmployeePage.createNewEmployee(employeeInforJson);
        empployeeIdPD = personalDetailsPage.getEmployeeIdPD();
        Assert.assertEquals(employeeID, empployeeIdPD);
    }

    @Description("Add new employee")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Employee_02_Add_New_Employee_By_JSON(){
        addNewEmployeePage = personalDetailsPage.clickToaddEmployeeButton();
        employeeID = addNewEmployeePage.getEmployeeId();
        personalDetailsPage = addNewEmployeePage.createNewEmployee(employeeInfor);
        empployeeIdPD = personalDetailsPage.getEmployeeIdPD();
    }

    @Description("Add new employee")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Employee_03_Add_New_Employee_By_Excel(){
        addNewEmployeePage = personalDetailsPage.clickToaddEmployeeButton();
        employeeID = addNewEmployeePage.getEmployeeId();
        personalDetailsPage = addNewEmployeePage.createNewEmployee(firstName, lastName);
        System.out.println(firstName + lastName);
        empployeeIdPD = personalDetailsPage.getEmployeeIdPD();
    }

    @Test
    public void Employee_02_Upload_Avatar(){
        personalDetailsPage.clickToEmployeeAvatarImage();
        Dimension beforeUpload = personalDetailsPage.getAvatarSize();
        personalDetailsPage.uploadMultipleFiles(driver, avatarImageName);
        personalDetailsPage.clickToSaveButtonAtProfileContainer();
        personalDetailsPage.isSuccessMessageIsDisplayed();
        personalDetailsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(personalDetailsPage.isProfileAvatarUpdateSuccess(beforeUpload));
    }

    @Test
    public void Employee_03_Personal_Details(){

    }


    //    @Test
    public void Employee_04_Contact_Details(){

    }

    //    @Test
    public void Employee_05_Emergency_Details(){

    }

    //    @Test
    public void Employee_06_Dependents(){

    }

    //    @Test
    public void Employee_07_Immigration(){

    }

    //    @Test
    public void Employee_08_Jobs(){

    }

    //    @Test
    public void Employee_09_Salary(){

    }

    //    @Test
    public void Employee_10_ReportTo(){

    }

    //    @Test
    public void Employee_11_Qualifications(){

    }

    //    @Test
    public void Employee_12_(){

    }
    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

    WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private AddNewEmployeePO addNewEmployeePage;
    private PersonalDetailsPO personalDetailsPage;
    private String employeeID, firstName, lastName, empployeeIdPD;
    private EmployeeInfor employeeInfor;
    private EmployeeInforJson employeeInforJson;
    private ExcelConfig excelConfig;
    private String avatarImageName = "avatar.png";
}
