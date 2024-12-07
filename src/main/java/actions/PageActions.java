package actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class PageActions {
    private static final Logger logger = LoggerFactory.getLogger(PageActions.class);
    private final Actions actions;
    private final WebDriver driver;

    public PageActions(WebDriver driver) {
        this.actions = new Actions(driver);
        this.driver = driver;
    }

    public String getCurrentUrl() {
        try {
            String currentUrl = driver.getCurrentUrl();
            logger.info("Retrieved current page full URL - '{}'.", currentUrl);
            return currentUrl;
        } catch (Exception e) {
            logger.error("Failed to get full URL for current page: {}", e.getMessage());
            return "";
        }
    }

    public String getCurrentUrlWithoutParameters() {
        try {
            String currentUrl = driver.getCurrentUrl();
            String normalizedCurrentUrl = currentUrl.split("\\?")[0];
            logger.info("Retrieved current page URL without parameters - '{}'.", normalizedCurrentUrl);
            return normalizedCurrentUrl;
        } catch (Exception e) {
            logger.error("Failed to get URL without parameters for current page: {}", e.getMessage());
            return "";
        }
    }

    public boolean openUrl(String url) {
        try {
            driver.navigate().to(url);
            logger.info("Opened URL '{}'.", url);
            return true;
        } catch (Exception e) {
            logger.error("Failed to open URL '{}': {}", url, e.getMessage());
            return false;
        }
    }

    public boolean goToPreviousPage() {
        try {
            driver.navigate().back();
//            logger.info("Navigated to the previous page.");
            return true;
        } catch (Exception e) {
            logger.error("Failed to navigate to the previous page: {}", e.getMessage());
            return false;
        }
    }

    public void switchToNewTab(String tabName) {
        try {
            String originalTab = driver.getWindowHandle();
            for (String tabHandle : driver.getWindowHandles()) {
                if (!tabHandle.equals(originalTab)) {
                    driver.switchTo().window(tabHandle);
                    logger.info("Switched to opened {} with URL '{}'.", tabName, driver.getCurrentUrl());
                    break;
                }
            }
        } catch (Exception e) {
            logger.error("Unable to switch to {} with URL '{}' : {}", tabName, driver.getCurrentUrl(), e.getMessage());
        }
    }

    public void closeCurrentTabAndSwitchBack() {
        try {
            String originalTab = driver.getWindowHandles().iterator().next();
            driver.close();
            driver.switchTo().window(originalTab);
            logger.info("Closed current tab and switched back to the original tab.");
        } catch (Exception e) {
            logger.error("Failed to close the current tab or switch back: {}", e.getMessage());
        }
    }

    public void click(WebElement element, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            actions.moveToElement(element).click().perform();
            logger.info("Clicked on '{}'.", elementName);
        } catch (Exception e) {
            logger.error("Failed to click on '{}': {}", elementName, e.getMessage());
        }
    }

    public void sendKeys(WebElement element, String text, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            element.clear();
            element.sendKeys(text);
            logger.info("Entered '{}' into '{}'.", text, elementName);
        } catch (Exception e) {
            logger.error("Failed to enter text into '{}': {}", elementName, e.getMessage());
        }
    }

    public void clearField(WebElement element, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            element.clear();
//            logger.info("Cleared field '{}'.", elementName);
        } catch (Exception e) {
            logger.error("Failed to clear field '{}': {}", elementName, e.getMessage());
        }
    }

    public void scrollToElement(WebElement element, String elementName) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.info("Scrolled to element '{}'.", elementName);
        } catch (Exception e) {
            logger.error("Failed to scroll to element '{}': {}", elementName, e.getMessage());
        }
    }

    public void selectDropdownByValue(WebElement dropdownElement, String value, String dropdownName) {
        try {
            this.explicitWaitForVisibility(dropdownElement, dropdownName);
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByValue(value);
            logger.info("Selected '{}'.", dropdownName);
        } catch (Exception e) {
            logger.error("Failed to select value '{}' in dropdown '{}': {}", value, dropdownName, e.getMessage());
        }
    }

    public boolean explicitWaitForVisibility(WebElement element, String elementName) {
        try {
            int timeOut = 3;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            wait.until(ExpectedConditions.visibilityOf(element));
//            logger.info("'{}' is visible after explicit wait.", elementName);
            return true;
        } catch (Exception e) {
            logger.error("Failed to wait for visibility of '{}': {}", elementName, e.getMessage());
            return false;
        }
    }

    public boolean explicitWaitForVisibilityOfList(List<WebElement> elementsList, String elementName) {
        try {
            for (int i = 0; i < elementsList.size(); i++) {
                WebElement element = elementsList.get(i);
                if (!this.explicitWaitForVisibility(element, elementName)) {
                    throw new AssertionError("Element at index " + i + " with text '" + element.getText() + "' is not visible.");
                }
            }
            logger.info("All elements in '{}' are visible.", elementName);
            return true;
        } catch (Exception e) {
            logger.error("Failed to wait for visibility of elements in '{}': {}", elementName, e.getMessage());
            return false;
        }
    }

    public String getText(WebElement element, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            String text = element.getText().trim();
            logger.info("Retrieved text '{}' from '{}'.", text, elementName);
            return text;
        } catch (NoSuchElementException e) {
            logger.warn("Element '{}' not found. Returning empty string.", elementName);
            return "";
        } catch (Exception e) {
            logger.error("Failed to retrieve text from '{}': {}", elementName, e.getMessage());
            return "";
        }
    }

    public String getInputValue(WebElement element, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            String value = element.getAttribute("value");
//            logger.info("Retrieved input value '{}' from '{}'.", value, elementName);
            return value != null ? value : "";
        } catch (Exception e) {
            logger.error("Failed to retrieve input value from '{}': {}", elementName, e.getMessage());
            return "";
        }
    }

    public boolean isTextColorChangedOnHover(WebElement element, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            String initialColor = element.getCssValue("color");
            actions.moveToElement(element).perform();
            String hoverColor = element.getCssValue("color");
            boolean isColorChanged = !initialColor.equals(hoverColor);
            if (isColorChanged) {
                logger.info("Text color of '{}' changed from '{}' to '{}'.", elementName, initialColor, hoverColor);
            } else {
                logger.warn("Text color of '{}' did not change on hover. Initial color: '{}', Hover color: '{}'.",
                        elementName, initialColor, hoverColor);
            }
            return isColorChanged;
        } catch (Exception e) {
            logger.error("Failed to verify text color change on hover for '{}': {}", elementName, e.getMessage());
            return false;
        }
    }

    public WebElement findElement(WebElement parentElement, By locator, String elementName) {
        try {
            return parentElement.findElement(locator);
        } catch (NoSuchElementException e) {
            logger.warn("Element '{}' not found. Returning null.", elementName);
            return null;
        } catch (Exception e) {
            logger.error("Failed to locate element '{}': {}", elementName, e.getMessage());
            return null;
        }
    }
}
