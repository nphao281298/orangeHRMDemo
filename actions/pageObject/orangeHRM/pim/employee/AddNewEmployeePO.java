package pageObject.orangeHRM.pim.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObject.orangeHRM.pim.PageGenerator;
import pageUIs.orangeHRM.pim.employee.AddNewPUI;

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


}
