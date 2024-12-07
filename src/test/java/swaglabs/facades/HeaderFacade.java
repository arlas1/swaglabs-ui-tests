package swaglabs.facades;

import org.openqa.selenium.WebDriver;
import swaglabs.utils.CustomSoftAssert;
import ui.components.header.Header;

import static swaglabs.constants.PageUrl.*;
import static swaglabs.utils.CustomAssert.*;

public class HeaderFacade {
    private Header header;
    private CustomSoftAssert soft;

    public HeaderFacade(WebDriver driver) {
        this.header = new Header(driver);
        this.soft = new CustomSoftAssert();
    }

    public HeaderFacade openCart() {
        header.openCart();
        return this;
    }

    public HeaderFacade openMenu() {
        header.openMenu();
        return this;
    }

    public HeaderFacade openAllItemsPage() {
        header.openAllItems();
        return this;
    }

    public HeaderFacade openAboutPage() {
        header.openAboutPage();
        return this;
    }

    public HeaderFacade logout() {
        header.logout();
        return this;
    }

    public HeaderFacade closeMenu() {
        header.closeMenu();
        return this;
    }

    public HeaderFacade verifyWebsiteTitleIsVisible() {
        assertTrue(header.isWebsiteTitleVisible(),
                "Verifying that website title is visible.");
        return this;
    }

    public HeaderFacade verifyMenuIsVisible() {
        assertTrue(header.isMenuVisible(), "Verifying that menu is visible");
        return this;
    }

    public HeaderFacade verifyMenuIsNotVisible() {
        assertFalse(!header.isMenuVisible(), "Verifying that menu is not visible");
        return this;
    }

    public HeaderFacade verifyAllItemsTextColorChangesOnHover() {
        soft.assertTrue(header.isAllItemsTextColorChangedOnHover(), "Verifying that 'All items' text color changes on hover.");
        return this;
    }

    public HeaderFacade verifyAboutTextColorChangesOnHover() {
        soft.assertTrue(header.isAboutTextColorChangedOnHover(), "Verifying that 'About' text color changes on hover.");
        return this;
    }

    public HeaderFacade verifyLogoutTextColorChangesOnHover() {
        soft.assertTrue(header.isLogoutTextColorChangedOnHover(), "Verifying that 'Logout' text color changes on hover.");
        return this;
    }

    public HeaderFacade verifyResetAppStateTextColorChangesOnHover() {
        soft.assertTrue(header.isResetAppStateTextColorChangedOnHover(), "Verifying that 'Reset App State' text color changes on hover.");
        soft.assertAll();
        return this;
    }

    public void verifyRedirectTo(String redirectUrl) {
        String currentUrl = header.getCurrentUrl();
        assertEquals(currentUrl, redirectUrl,
                "Verifying that user is redirected to the" + redirectUrl + " ."
        );
        header.openUrl(INVENTORY_PAGE);
    }
}
