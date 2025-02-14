package pageObject.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObject.orangeHRM.pim.PageGenerator;

public class AddNewEmployeePO extends BasePage {
    public AddNewEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public void enterToLastNameTextBox(String s) {
    }

    public void enterTolastNameTextBox(String s) {
    }

    public String getEmployeeID() {
        return null;
    }

    public PersonalDetailsPO clicktoSaveButton() {
        return PageGenerator.getPersonalDetailsPage(driver);
    }
}
