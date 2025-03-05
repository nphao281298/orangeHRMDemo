package pageObject.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPO extends EmployeeTabs {
    public ContactDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private WebDriver driver;
}
