package ui.components.header;

import org.openqa.selenium.WebDriver;
import ui.components.BaseComponent;
import ui.pages.cartPage.CartPage;
import ui.pages.loginPage.LoginPage;

public class Header extends BaseComponent {
    private final HeaderElements elements;

    public Header(WebDriver driver) {
        super(driver);
        this.elements = new HeaderElements(driver);
    }

    public int getAmountOfItemsOnCart() {
        String amount = getText(elements.cartBadge, "cart badge");
        return Integer.parseInt(amount);
    }

    public CartPage openCart() {
        click(elements.cartButton, "cart button");
        return new CartPage(driver);
    }

    public Header openMenu() {
        click(elements.menuButton, "menu button");
        return this;
    }

    public Header openAllItems() {
        click(elements.allItemsButton, "all items button");
        return this;
    }

    public Header openAboutPage() {
        click(elements.aboutPageButton, "about page button");
        return this;
    }

    public LoginPage logout() {
        click(elements.logoutButton, "logout button");
        return new LoginPage(driver);
    }

    public Header resetAppState() {
        click(elements.resetAppStateButton, "reset app state button");
        return this;
    }

    public Header closeMenu() {
        click(elements.menuCloseButton, "menu close button");
        return this;
    }

    public boolean isAllItemsTextColorChangedOnHover() {
        return isTextColorChangedOnHover(elements.allItemsButton, "all items button");
    }

    public boolean isAboutTextColorChangedOnHover() {
        return isTextColorChangedOnHover(elements.aboutPageButton, "about page button");
    }

    public boolean isLogoutTextColorChangedOnHover() {
        return isTextColorChangedOnHover(elements.logoutButton, "logout button");
    }

    public boolean isResetAppStateTextColorChangedOnHover() {
        return isTextColorChangedOnHover(elements.resetAppStateButton, "reset app state button");
    }

    public boolean isWebsiteTitleVisible() {
       return explicitWaitForVisibility(elements.websiteTitle, "website title");
    }

    public boolean isMenuVisible() {
        return explicitWaitForVisibility(elements.menu, "manu ");
    }
}
