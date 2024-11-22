package ui.component;

import actions.CustomActions;
import org.openqa.selenium.WebDriver;

public abstract class BaseComponent {
    protected CustomActions customActions;
    protected WebDriver driver;

    public BaseComponent(WebDriver driver, CustomActions customActions) {
        this.driver = driver;
        this.customActions = customActions;
    }
}
