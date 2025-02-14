package pageObject.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import pageObject.orangeHRM.pim.PageGenerator;

public class EmployeeListPO extends BasePage {
    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public AddNewEmployeePO clickToaddEmployeeButton() {
        return PageGenerator.getAddNewEmployeePage(driver);
    }
}
