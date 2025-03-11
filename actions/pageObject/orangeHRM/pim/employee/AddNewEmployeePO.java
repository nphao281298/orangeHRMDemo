package pageObject.orangeHRM.pim.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import jsonData.EmployeeInforJson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import pageObject.orangeHRM.pim.PageGenerator;
import pageUIs.orangeHRM.pimD.employee.AddNewPUI;
import pojoData.EmployeeInfor;

public class AddNewEmployeePO extends BasePage {
    public AddNewEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    @Step("Enter FirstName into text box {0}")
    public void enterToFirstNameTextBox(String firstName) {
        waitForElementVisible(driver, AddNewPUI.FIRSTNAME_TEXTBOX);
        sendKeysToElement(driver, AddNewPUI.FIRSTNAME_TEXTBOX, firstName);
    }

    @Step("Enter LastName into text box {0}")
    public void enterTolastNameTextBox(String lastName) {
        waitForElementVisible(driver, AddNewPUI.LASTNAME_TEXTBOX);
        sendKeysToElement(driver, AddNewPUI.LASTNAME_TEXTBOX, lastName);
    }

    @Step("Get EmployeeID")
    public String getEmployeeId() {
        waitForElementVisible(driver, AddNewPUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, AddNewPUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    @Step("Click Save Button at Employee Container")
    public PersonalDetailsPO clicktoSaveButtonAtEmployeeContainer() {
        waitForElementClickable(driver, AddNewPUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        clickToElement(driver, AddNewPUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    public void clickToSaveButtonAtAddNewEmployee() {
        waitForElementClickable(driver, AddNewPUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        clickToElement(driver, AddNewPUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
    }

    @Step("Create new employee")
    public PersonalDetailsPO createNewEmployee(String firstName, String lastName){
        enterToFirstNameTextBox(firstName);
        enterTolastNameTextBox(lastName);
        clickToSaveButtonAtAddNewEmployee();
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    @Step("Create new employee")
    public PersonalDetailsPO createNewEmployee(EmployeeInfor employeeInfor){
        enterToFirstNameTextBox(employeeInfor.getFirstName());
        enterTolastNameTextBox(employeeInfor.getLastName());
        clickToSaveButtonAtAddNewEmployee();
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    @Step("Create new employee")
    public PersonalDetailsPO createNewEmployee(EmployeeInforJson employeeInforJson){
        enterToFirstNameTextBox(employeeInforJson.getFirstname());
        enterTolastNameTextBox(employeeInforJson.getLastname());
        clickToSaveButtonAtAddNewEmployee();
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }
}
