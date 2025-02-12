package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.users.PageBaseUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    public static BasePage getBasePage(){
        return new BasePage();
    }

    public void openUrl(WebDriver webDriver, String url){
        webDriver.get(url);
    }

    public String getPageTitle(WebDriver webDriver){
        return webDriver.getTitle();
    }

    public String getCurrentPageUrl(WebDriver webDriver){
        return webDriver.getCurrentUrl();
    }

    public String getPageSource(WebDriver webDriver){
        return webDriver.getPageSource();
    }

    public void backToPage(WebDriver webDriver){
        webDriver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver webDriver){
        webDriver.navigate().refresh();
    }

    public Alert waitForAlertPresence(WebDriver webDriver){
        return new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver webDriver){
        waitForAlertPresence(webDriver).accept();
    }

    public void cancelToAlert(WebDriver webDriver){
        waitForAlertPresence(webDriver).dismiss();
    }

    public String getTextInAlert(WebDriver webDriver){
       return waitForAlertPresence(webDriver).getText();
    }

    public void sendKeyToAlert(WebDriver webDriver, String keysToSend){
        waitForAlertPresence(webDriver).sendKeys(keysToSend);
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public void sleepInSecond(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public Set<Cookie> getBrowserCookies(WebDriver webDriver){
        return webDriver.manage().getCookies();
    }

    public void setCookies(WebDriver webDriver, Set<Cookie> cookies){
        for (Cookie cookie: cookies){
            webDriver.manage().addCookie(cookie);
        }
    }

    public void deleteAllCookies(WebDriver webDriver){
        webDriver.manage().deleteAllCookies();
    }

    /*Web Emlement*/
    public By getByXpath(String locator){
        return By.xpath(locator);
    }

    private String castParameter(String locator, String... restParameter){
        return String.format(locator, (Object[]) restParameter);
    }

    public By getByLocator(String prefixLocator){
        By by = null;

        if (prefixLocator.toLowerCase().startsWith("id")){
            by = By.id(prefixLocator.substring(3));
        }else if (prefixLocator.toLowerCase().startsWith("class")){
            by = By.className(prefixLocator.substring(6));
        }else if (prefixLocator.toLowerCase().startsWith("name")){
            by = By.name(prefixLocator.substring(5));
        }else if (prefixLocator.toLowerCase().startsWith("tagname")){
            by = By.tagName(prefixLocator.substring(8));
        }else if (prefixLocator.toLowerCase().startsWith("css")){
            by = By.cssSelector(prefixLocator.substring(4));
        }else if (prefixLocator.toLowerCase().startsWith("xpath")){
            by = By.xpath(prefixLocator.substring(6));
        }else {
            throw new RuntimeException("Locator type is not support!!");
        }
        return by;
    }

    public WebElement getWebElement(WebDriver webDriver, String locator){
        return webDriver.findElement(getByLocator(locator));
    }

    public WebElement getWebElement(WebDriver webDriver, String locator, String restParamter){
        return webDriver.findElement(getByLocator(castParameter(locator, restParamter)));
    }

    public List<WebElement> getListWebElement (WebDriver webDriver, String locator){
        return webDriver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListWebElement (WebDriver webDriver, String locator, String restParamter){
        return webDriver.findElements(getByLocator(castParameter(locator, restParamter)));
    }

    public void clickToElement (WebDriver webDriver, String locator){
        getWebElement(webDriver, locator).click();
    }

    public void clickToElement (WebDriver webDriver, String locator, String restParameter){
        getWebElement(webDriver, castParameter(locator, restParameter)).click();
    }

    public void sendKeysToElement(WebDriver webDriver, String locator, String valueToSend){
        getWebElement(webDriver, locator).clear();
        getWebElement(webDriver, locator).sendKeys(valueToSend);
    }
    public void sendKeysToElement(WebDriver webDriver, String locator, String valueToSend, String restParameter){
        getWebElement(webDriver, castParameter(locator, restParameter)).clear();
        getWebElement(webDriver, castParameter(locator, restParameter)).sendKeys(valueToSend);
    }

    public String getElementText(WebDriver webDriver, String locator){
        return getWebElement(webDriver, locator).getText();
    }

    public void selecteItemInDefaultDropdown(WebDriver webDriver, String locator, String itemValue){
        new Select(getWebElement(webDriver, locator)).selectByVisibleText(itemValue);
    }

    public String getFirstSelectedTextInDefaultDropdown(WebDriver webDriver, String locator){
        return new Select(getWebElement(webDriver, locator)).getFirstSelectedOption().getText();
    }

    public Boolean isDefaultDropdownMultiple(WebDriver webDriver, String locator){
        return new Select(getWebElement(webDriver, locator)).isMultiple();
    }

    public void selectItemDropdown(WebDriver webDriver, String parentLocator, String childLocator, String expectedTextItem){
        getWebElement(webDriver, parentLocator).click();
        sleepInSecond(1);

        List<WebElement> speedDropdownItems =
                new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));

        for (WebElement tempItem : speedDropdownItems){
            if (tempItem.getText().trim().equals(expectedTextItem)){
                sleepInSecond(1);
                tempItem.click();
                break;
            }
        }
    }

    public String getElementAttribute(WebDriver webDriver, String locator, String attributeName){
        return getWebElement(webDriver, locator).getAttribute(attributeName);
    }

    public String getElementAttribute(WebDriver webDriver, String locator, String attributeName, String restParameter){
        return getWebElement(webDriver, castParameter(locator, restParameter)).getAttribute(attributeName);
    }

    public String getElementCssValue(WebDriver webDriver, String locator, String cssPropertyName){
        return getWebElement(webDriver, locator).getCssValue(cssPropertyName);
    }

    public String convertRGBAToHexaColor(WebDriver webDriver, String locator){
        return Color.fromString(getElementCssValue(webDriver, locator, "background-color")).asHex();
    }

    public int getListElementsSize(WebDriver webDriver, String locator){
        return getListWebElement(webDriver, locator).size();
    }

    /*
    * Apply for checkbox and radio button
    * @param webdriver
    * @param locator
    * */
    public void checkToElement(WebDriver webDriver, String locator){
        if (!getWebElement(webDriver, locator).isSelected()){
            getWebElement(webDriver, locator).click();
        }
    }

    /*
     * Apply for checkbox
     * @param webdriver
     * @param locator
     * */

    public void unCheckElement(WebDriver webDriver, String locator){
        if (getWebElement(webDriver, locator).isSelected()){
            getWebElement(webDriver, locator).click();
        }
    }

    public Boolean isElementDisplayed(WebDriver webDriver, String locator){
        return getWebElement(webDriver, locator).isDisplayed();
    }

    public Boolean isElementSelected(WebDriver webDriver, String locator){
        return getWebElement(webDriver, locator).isSelected();
    }

    public Boolean isElementEnabled(WebDriver webDriver, String locator){
        return getWebElement(webDriver, locator).isEnabled();
    }

    /*
    * Can xem lai
    * */
    public void switchToIframe(WebDriver webDriver, String locator){
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
//        webDriver.switchTo().frame(getWebElement(webDriver, locator));
    }

    public void switchToDefaultContent(WebDriver webDriver, String locator){
        webDriver.switchTo().defaultContent();
    }

    public void hoverToElement(WebDriver webDriver, String locator){
        new Actions(webDriver).moveToElement(getWebElement(webDriver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver webDriver, String locator){
        new Actions(webDriver).doubleClick(getWebElement(webDriver, locator)).perform();
    }

    public void rightClickToElement(WebDriver webDriver, String locator){
        new Actions(webDriver).contextClick(getWebElement(webDriver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver webDriver, String sourceLocator, String targetLocator){
        new Actions(webDriver).dragAndDrop(getWebElement(webDriver, sourceLocator), getWebElement(webDriver,targetLocator)).perform();
    }

    public void sendKeyBoradToElement(WebDriver webDriver, String lcoator, Keys key){
        new Actions(webDriver).sendKeys(getWebElement(webDriver,lcoator),key).perform();
    }

    /*
    * Xem lai JS executor
    * */

    public void hightlightElement(WebDriver driver, String locator) {
        WebElement element = getWebElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getWebElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getWebElement(driver, locator));
    }

    public void waitForElementVisible(WebDriver webDriver, String locator){
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForElementVisible(WebDriver webDriver, String locator, String restParameter){
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator, restParameter))));
    }
    public void waitForListElementVisible(WebDriver webDriver, String locator){
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(webDriver, locator)));
    }

    public void waitForElementInVisible(WebDriver webDriver, String locator){
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForListElementInVisible(WebDriver webDriver, String locator){
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(webDriver,locator)));
    }

    public void waitForElementClickable(WebDriver webDriver, String locator){
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getWebElement(webDriver,locator)));
    }
    public void waitForElementClickable(WebDriver webDriver, String locator, String restParameter){
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getWebElement(webDriver,castParameter(locator,restParameter))));
    }

    public void waitForElementClickable(WebDriver webDriver, String locator, String... restParameter){
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getWebElement(webDriver,castParameter(locator,restParameter))));
    }

}
