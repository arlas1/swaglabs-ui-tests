package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class CustomActions {
    private static final Logger logger = LoggerFactory.getLogger(CustomActions.class);
    private final Actions actions;
    private final WebDriver driver;

    public CustomActions(WebDriver driver) {
        this.actions = new Actions(driver);
        this.driver = driver;
    }

    public boolean explicitWaitForVisibility(WebElement element, String elementName) {
        try {
            int timeOut = 10;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            wait.until(ExpectedConditions.visibilityOf(element));
            logger.info("Explicit wait successful: {} is visible.", elementName);
            return true;
        } catch (Exception e) {
            logger.error("Explicit wait failed: {} was not visible within 10 seconds. Error: {}", elementName, e.getMessage());
            return false;
        }
    }

    public void clearField(WebElement element, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            element.clear();
            logger.info("Successfully cleared the '{}'.", elementName);
        } catch (Exception e) {
            logger.error("Unable to clear the '{}'. Error: {}", elementName, e.getMessage());
        }
    }


    public void click(WebElement element, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            actions.moveToElement(element).click().perform();
            logger.info("Successfully clicked on the {}.", elementName);
        } catch (Exception e) {
            logger.error("Unable to click on the {}. Error: {}", elementName, e.getMessage());
        }
    }

    public boolean explicitWaitForVisibilityOfList(List<WebElement> elementsList, String elementName) {
        try {
            for (int i = 0; i < elementsList.size(); i++) {
                WebElement product = elementsList.get(i);
                if (!this.explicitWaitForVisibility(product, elementName)) {
                    throw new AssertionError("Product at index " + i + " with text '" + product.getText() + "' is not visible.");
                }
            }
            logger.info("All elements in the {} are visible.", elementName);
            return true;
        } catch (Exception e) {
            logger.error("Explicit wait failed for elements in: {}. Error: {}", elementName, e.getMessage());
            return false;
        }
    }

    public void sendKeys(WebElement element, String text, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            element.clear();
            element.sendKeys(text);
            logger.info("Successfully entered '{}' in {}.", text, elementName);
        } catch (Exception e) {
            logger.error("Unable to enter text in the {}. Error: {}", elementName, e.getMessage());
        }
    }

    public String getText(WebElement element, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            String text = element.getText().trim();
            logger.info("Successfully retrieved '{}' from {}", text, elementName);
            return text;
        } catch (Exception e) {
            logger.error("Unable to retrieve text from {} Error: {}", elementName, e.getMessage());
            return "";
        }
    }

    public void moveToElement(WebElement element, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            actions.moveToElement(element).perform();
            logger.info("Successfully moved to {}.", elementName);
        } catch (Exception e) {
            logger.error("Unable to move to {}. Error: {}", elementName, e.getMessage());
        }
    }

    public boolean openUrl(WebDriver driver, String url) {
        try {
            driver.navigate().to(url);
            logger.info("Successfully opened URL: {}.", url);
            return true;
        } catch (Exception e) {
            logger.error("Failed to open URL: {}. Error: {}", url, e.getMessage());
            return false;
        }
    }

    public String getInputValue(WebElement element, String elementName) {
        try {
            this.explicitWaitForVisibility(element, elementName);
            String value = element.getAttribute("value");
            logger.info("Successfully retrieved '{}' from {}.", value, elementName);
            return value != null ? value : "";
        } catch (Exception e) {
            logger.error("Unable to retrieve text from {}. Error: {}", elementName, e.getMessage());
            return "";
        }
    }
}
