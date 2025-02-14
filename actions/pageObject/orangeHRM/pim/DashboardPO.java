package pageObject.orangeHRM.pim;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObject.orangeHRM.pim.employee.EmployeeListPO;

public class DashboardPO extends BasePage {
    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public EmployeeListPO clickToPIMPage() {
        return PageGenerator.getEmployeeListPage(driver);
    }
}
