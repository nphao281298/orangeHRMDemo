package pageObject.orangeHRM.pim.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import pageObject.orangeHRM.pim.PageGenerator;
import pageUIs.orangeHRM.DashboardPUI;
import pageUIs.orangeHRM.pim.employee.EmployeeListPUI;

public class EmployeeListPO extends BasePage {
    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    @Step("Click Add Employee button")
    public AddNewEmployeePO clickToaddEmployeeButton() {
        waitForElementClickable(driver, EmployeeListPUI.ADD_EMPLOYEE_NAV_BUTTON);
        clickToElement(driver, EmployeeListPUI.ADD_EMPLOYEE_NAV_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getAddNewEmployeePage(driver);
    }
}
