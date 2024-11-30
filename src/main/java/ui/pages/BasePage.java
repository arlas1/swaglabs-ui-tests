package ui.pages;

import actions.PageActions;
import org.openqa.selenium.WebDriver;
import ui.components.footer.Footer;
import ui.components.header.Header;

public class BasePage extends PageActions{
    protected WebDriver driver;
    public Header header;
    public Footer footer;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.header = new Header(driver);
        this.footer = new Footer(driver);
    }
}