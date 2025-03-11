package pageUIs.orangeHRM.pimD.employee;

public class PersonalDetailsPUI {
    public static final String EMPLOYEE_IMAGE = "Css=div.orangehrm-edit-employee-image>img.employee-image";
    public static final String SAVE_BUTTON_AT_CHANGE_PROFILE_PICTURE = "Xpath=//button[contains(string(),'Save')]";
    public static final String SUCCESS_MESSAGE = "Xpath=//div[contains(@class,'oxd-toast-content')]/p[text()='Successfully Updated']";
    public static final String EMPLOYEE_ID_TEXTBOX_PD = "Xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String PIM_LINK = "Xpath=//ul[@class='oxd-main-menu']//span[text()='PIM']";
    public static final String ADD_EMPLOYEE_PD_BUTTON = "Xpath=//a[contains(@class,'nav-tab') and text()='Add Employee']";
}
