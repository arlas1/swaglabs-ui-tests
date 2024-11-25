package ui.components.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderElements {

    @FindBy(className = "app_logo")
    protected WebElement websiteTitle;

    @FindBy(className = "shopping_cart_link")
    protected WebElement cartButton;

    @FindBy(className = "shopping_cart_badge")
    protected WebElement cartBadge;

    @FindBy(id = "react-burger-menu-btn")
    protected WebElement menuButton;

    @FindBy(className = "bm-menu")
    protected WebElement menu;

    @FindBy(id = "inventory_sidebar_link")
    protected WebElement allItemsButton;

    @FindBy(id = "about_sidebar_link")
    protected WebElement aboutPageButton;

    @FindBy(id = "user-logout_sidebar_link")
    protected WebElement logoutButton;

    @FindBy(id = "reset_sidebar_link")
    protected WebElement resetAppStateButton;

    @FindBy(id = "react-burger-cross-btn")
    protected WebElement menuCloseButton;

    public HeaderElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
