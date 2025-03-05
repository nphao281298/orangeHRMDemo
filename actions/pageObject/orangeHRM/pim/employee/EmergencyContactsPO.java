package pageObject.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class EmergencyContactsPO extends EmployeeTabs {
    public EmergencyContactsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private WebDriver driver;
}
