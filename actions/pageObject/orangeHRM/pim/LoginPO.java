package pageObject.orangeHRM.pim;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.LoginPUI;

public class LoginPO extends BasePage {

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    @Step("Enter User Name to text box: {0}")
    public void enterToUsernameTextBox(String username) {
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
        sendKeysToElement(driver, LoginPUI.USERNAME_TEXTBOX, username);
    }
    @Step("Enter Password to text box: {0}")
    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, LoginPUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click Login button")
    public DashboardPO clickToLoginButton() {
        waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getDashboardPage(driver);
    }
}
