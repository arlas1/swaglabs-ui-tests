package ui.components;

import actions.PageActions;
import org.openqa.selenium.WebDriver;

public class BaseComponent extends PageActions {
    protected WebDriver driver;

    public BaseComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
