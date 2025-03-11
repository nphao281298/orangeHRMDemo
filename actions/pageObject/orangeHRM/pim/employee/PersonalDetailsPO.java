package pageObject.orangeHRM.pim.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageObject.orangeHRM.pim.PageGenerator;
import pageUIs.orangeHRM.DashboardPUI;
import pageUIs.orangeHRM.pimD.employee.EmployeeListPUI;
import pageUIs.orangeHRM.pimD.employee.PersonalDetailsPUI;

public class PersonalDetailsPO extends EmployeeTabs {
    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private WebDriver driver;

    @Step("click to employee avatar image")
    public void clickToEmployeeAvatarImage() {
        waitForElementClickable(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE);
        clickToElement(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE);
    }

    @Step("Click to save btn at profile container")
    public void clickToSaveButtonAtProfileContainer() {
        waitForElementClickable(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PROFILE_PICTURE);
        clickToElement(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PROFILE_PICTURE);
    }

    @Step("Verify Message success is displayed")
    public Boolean isSuccessMessageIsDisplayed( ) {
        waitForElementVisible(driver, PersonalDetailsPUI.SUCCESS_MESSAGE);
        return isElementDisplayed(driver, PersonalDetailsPUI.SUCCESS_MESSAGE);
    }

    @Step("Get Avatar size")
    public Dimension getAvatarSize() {
        return getElementSize(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE);
    }

    @Step("Veryfi Avatar update sucess")
    public boolean isProfileAvatarUpdateSuccess(Dimension beforeUpload) {
        Dimension afterUpload = getAvatarSize();
        return !(beforeUpload.equals(afterUpload));
    }

    @Step("Get EmployeeID PD")
    public String getEmployeeIdPD() {
        waitAllLoadingIconInvisible(driver);
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX_PD);
        return getElementAttribute(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX_PD, "value");
    }

    public AddNewEmployeePO clickToaddEmployeeButton() {
        waitForElementClickable(driver, PersonalDetailsPUI.ADD_EMPLOYEE_PD_BUTTON);
        clickToElement(driver, PersonalDetailsPUI.ADD_EMPLOYEE_PD_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getAddNewEmployeePage(driver);
    }
}
