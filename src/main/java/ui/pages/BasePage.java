package ui.pages;

import actions.CustomActions;
import org.openqa.selenium.WebDriver;
import ui.components.footer.Footer;
import ui.components.header.Header;

public abstract class BasePage {
    public Header header;
    public Footer footer;
    protected WebDriver driver;
    protected CustomActions customActions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.customActions = new CustomActions(driver);
        this.header = new Header(driver, customActions);
        this.footer = new Footer(driver, customActions);
    }

    public String getCurrentUrl(String message) {
        return customActions.getCurrentUrl(message);
    }
}