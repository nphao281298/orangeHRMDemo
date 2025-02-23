package pageObject.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObject.orangeHRM.pim.PageGenerator;
import pageUIs.orangeHRM.pim.employee.EmployeeTabsPUI;

public class EmployeeTabs extends BasePage {
    WebDriver driver;
    public EmployeeTabs(WebDriver driver) {
        this.driver = driver;
    }
    public PersonalDetailsPO openPersonalDetailPage(){
        waitForElementClickable(driver, EmployeeTabsPUI.PERSONAL_DETAL_LINK);
        clickToElement(driver, EmployeeTabsPUI.PERSONAL_DETAL_LINK);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    public ContactDetailsPO openContactDetailPage(){
        waitForElementClickable(driver, EmployeeTabsPUI.CONTACT_DETAL_LINK);
        clickToElement(driver, EmployeeTabsPUI.CONTACT_DETAL_LINK);
        return PageGenerator.getContactDetailsPage(driver);
    }

    public EmergencyContactsPO openEmergencyContactPage(){
        waitForElementClickable(driver, EmployeeTabsPUI.EMERGENCY_DETAL_LINK);
        clickToElement(driver, EmployeeTabsPUI.EMERGENCY_DETAL_LINK);
        return PageGenerator.getEmergencyContactsPage(driver);
    }
}
