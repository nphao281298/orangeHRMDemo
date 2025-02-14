package pageObject.orangeHRM.pim;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.LoginPUI;

public class LoginPO extends BasePage {

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public void enterToUsernameTextBox(String username) {
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
        sendKeysToElement(driver, LoginPUI.USERNAME_TEXTBOX, username);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, LoginPUI.PASSWORD_TEXTBOX, password);
    }

    public DashboardPO clickToLoginButton() {
        waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);
        return PageGenerator.getDashboardPage(driver);
    }
}
