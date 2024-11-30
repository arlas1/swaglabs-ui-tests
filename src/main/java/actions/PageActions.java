package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
            String normalizedCurrentUrl = currentUrl.split("\\?")[0];
            logger.info("Retrieved URL '{}' for current page.", normalizedCurrentUrl);
            return currentUrl;
        } catch (Exception e) {
            logger.error("Failed to get URL for current page: {}", e.getMessage());
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

    public void switchToNewTab(String tabName) {
        try {
            String originalTab = driver.getWindowHandle();
            for (String tabHandle : driver.getWindowHandles()) {
                if (!tabHandle.equals(originalTab)) {
                    driver.switchTo().window(tabHandle);
                    logger.info("Switched to {} with URL '{}'.", tabName, driver.getCurrentUrl());
                    break;
                }
            }
        } catch (Exception e) {
            logger.error("Switched to {} with URL '{}' : {}", tabName, driver.getCurrentUrl(), e.getMessage());
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


    public boolean explicitWaitForVisibility(WebElement element, String elementName) {
        try {
            int timeOut = 3;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info("'{}' is visible after explicit wait.", elementName);
            return true;
        } catch (Exception e) {
            logger.error("Failed to wait for visibility of '{}': {}", elementName, e.getMessage());
            return false;
        }
    }

    public void clearField(WebElement element, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            element.clear();
            logger.info("Cleared field '{}'.", elementName);
        } catch (Exception e) {
            logger.error("Failed to clear field '{}': {}", elementName, e.getMessage());
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

    public String getText(WebElement element, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            String text = element.getText().trim();
            logger.info("Retrieved text '{}' from '{}'.", text, elementName);
            return text;
        } catch (Exception e) {
            logger.error("Failed to retrieve text from '{}': {}", elementName, e.getMessage());
            return "";
        }
    }

    public boolean isTextColorChangedOnHover(WebElement element, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            String initialColor = element.getCssValue("color");
            actions.moveToElement(element).perform();
            logger.info("Hovered over '{}'.", elementName);
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



    public String getInputValue(WebElement element, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            String value = element.getAttribute("value");
            logger.info("Retrieved input value '{}' from '{}'.", value, elementName);
            return value != null ? value : "";
        } catch (Exception e) {
            logger.error("Failed to retrieve input value from '{}': {}", elementName, e.getMessage());
            return "";
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


//    public void moveToElement(WebElement element, String elementName) {
//        try {
//            this.explicitWaitForVisibility(element, elementName);
//            actions.moveToElement(element).perform();
//            logger.info("Moved to '{}'.", elementName);
//        } catch (Exception e) {
//            logger.error("Failed to move to '{}': {}", elementName, e.getMessage());
//        }
//    }
}
