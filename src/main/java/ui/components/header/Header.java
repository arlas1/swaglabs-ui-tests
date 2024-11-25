package ui.components.header;

import actions.CustomActions;
import org.openqa.selenium.WebDriver;
import ui.components.BaseComponent;
import ui.pages.cartPage.CartPage;
import ui.pages.loginPage.LoginPage;

public class Header extends BaseComponent {
    private final HeaderElements elements;

    public Header(WebDriver driver, CustomActions customActions) {
        super(driver, customActions);
        this.elements = new HeaderElements(driver);
    }

    public int getAmountOfItemsOnCart() {
        String amount = customActions.getText(elements.cartBadge, "cart badge");
        return Integer.parseInt(amount);
    }

    public CartPage openCart() {
        customActions.click(elements.cartButton, "cart button");
        return new CartPage(driver);
    }

    public Header openMenu() {
        customActions.click(elements.menuButton, "menu button");
        return this;
    }

    public Header openAllItems() {
        customActions.click(elements.allItemsButton, "all items button");
        return this;
    }

    public void openAboutPage() {
        customActions.click(elements.aboutPageButton, "about page button");
    }

    public LoginPage logout() {
        customActions.click(elements.logoutButton, "logout button");
        return new LoginPage(driver);
    }

    public Header resetAppState() {
        customActions.click(elements.resetAppStateButton, "reset app state button");
        return this;
    }

    public Header closeMenu() {
        customActions.click(elements.menuCloseButton, "menu close button");
        return this;
    }

    public Header hoverOverAllItemsButton() {
        customActions.moveToElement(elements.allItemsButton, "all items button");
        return this;
    }

    public Header hoverOverAboutPageButton() {
        customActions.moveToElement(elements.aboutPageButton, "about page button");
        return this;
    }

    public Header hoverOverLogoutButton() {
        customActions.moveToElement(elements.logoutButton, "logout button");
        return this;
    }

    public Header hoverOverResetAppStateButton() {
        customActions.moveToElement(elements.resetAppStateButton, "reset app state button");
        return this;
    }
}
